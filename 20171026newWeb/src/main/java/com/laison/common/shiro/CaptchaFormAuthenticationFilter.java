package com.laison.common.shiro;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;

import com.laison.common.enumerate.Constant;
import com.laison.common.utils.JsonUtils;
import com.laison.common.utils.R;
import com.laison.common.web.ValidateCodeServlet;
import com.laison.entity.sysuser.SysUser;


public class CaptchaFormAuthenticationFilter extends FormAuthenticationFilter {

	String username;
	String password;
	String captcha;
	String loginFor;

	public CaptchaFormAuthenticationFilter() {
	}

	@Override
	/**
	 * 登录验证
	 */
	protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {

		username = getUsername(request);
		password = getPassword(request);
		captcha = getCaptcha(request);
		loginFor = WebUtils.getCleanParam(request,"loginFor" );
		if(loginFor==null) {
			loginFor="business";
		}
		if (username == null || password == null || captcha == null) {
			R r = R.error("{parameter.miss}");
			response.setCharacterEncoding("utf-8");
			response.setContentType("application/json;charset=utf-8");
			response.getWriter().write(JsonUtils.objectToJsonWhitI18N(r));
			return false;
		}
		CaptchaUsernamePasswordToken token = createToken(request, response);
		token.setLoginFor(loginFor);
		try {
			/* 图形验证码验证 */
			//doCaptchaValidate((HttpServletRequest) request, token);
			Subject subject = getSubject(request, response);
			subject.login(token);// 正常验证

			return onLoginSuccess(token, subject, request, response);
		} catch (AuthenticationException e) {

			return onLoginFailure(token, e, request, response);
		}
	}

	// 验证码校验
	protected void doCaptchaValidate(HttpServletRequest request, CaptchaUsernamePasswordToken token) {

		Subject subject = SecurityUtils.getSubject();
		// Session session = subject.getSession(false);
		HttpSession session = request.getSession();

		String code = (String) session.getAttribute(ValidateCodeServlet.VALIDATE_CODE);
		if (code == null || token.getCaptcha() == null || !token.getCaptcha().toUpperCase().equals(code)) {
			throw new AuthenticationException("{validate.error}");
		}
	}

	@Override
	protected CaptchaUsernamePasswordToken createToken(ServletRequest request, ServletResponse response) {

		boolean rememberMe = isRememberMe(request);
		String host = getHost(request);

		return new CaptchaUsernamePasswordToken(username, password.toCharArray(), rememberMe, host, captcha);
	}

	public static final String DEFAULT_CAPTCHA_PARAM = ValidateCodeServlet.VALIDATE_CODE;

	private String captchaParam = DEFAULT_CAPTCHA_PARAM;

	public String getCaptchaParam() {
		return captchaParam;
	}

	public void setCaptchaParam(String captchaParam) {
		this.captchaParam = captchaParam;
	}

	protected String getCaptcha(ServletRequest request) {
		return WebUtils.getCleanParam(request, getCaptchaParam());
	}

	@Override
	protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request,
			ServletResponse response) throws Exception {

		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;

		/*if (!"XMLHttpRequest".equalsIgnoreCase(httpServletRequest.getHeader("X-Requested-With"))) {// 不是ajax请求
			issueSuccessRedirect(request, response);
		} else {*/
			response.setCharacterEncoding("utf-8");
			response.setContentType("application/json;charset=utf-8");
			PrintWriter out = httpServletResponse.getWriter();
			R ok = R.ok("登入成功");
			SysUser loginUser = (SysUser) subject.getPrincipal();
			ok.put("user", loginUser);
			out.write(JsonUtils.objectToJsonWhitI18N(ok));
			
		/*}*/
		return false;
	}

	/**
	 * 登录失败调用事件
	 */
	@Override
	protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request,
			ServletResponse response) {
		

			
			response.setCharacterEncoding("utf-8");
			response.setContentType("application/json;charset=utf-8");
			R error = R.error(e.getMessage());
			try {
				response.getWriter().write(JsonUtils.objectToJsonWhitI18N(error));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		return false;//是不是要继续解析

	}
	/**
	 * 访问被拒绝是：一般是未登录造成的
	 */
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		if (isLoginRequest(request, response)) {
			if (isLoginSubmission(request, response)) {
				return executeLogin(request, response);
			} else {
				return true;
			}
		} else {

			R r = R.error(Constant.NO_LOGIN_CODE,"{no.login}");
		
			response.setCharacterEncoding("utf-8");
			response.setContentType("application/json;charset=utf-8");
			response.getWriter().write(JsonUtils.objectToJsonWhitI18N(r));

			return false;
		}
	}

	// 保存异常对象到request
	/*@Override
	protected void setFailureAttribute(ServletRequest request, AuthenticationException ae) {
		request.setAttribute(getFailureKeyAttribute(), ae);
	}*/
}