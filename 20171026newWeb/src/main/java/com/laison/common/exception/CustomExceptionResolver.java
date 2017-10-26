package com.laison.common.exception;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.AuthorizationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.laison.common.enumerate.Constant;
import com.laison.common.utils.JsonUtils;
import com.laison.common.utils.R;


/**
 * 
 * <p>Title:</p>
 * <p>Description: </p>
 * <p>Company: laison</p> 
 * @author	lihua
 * @date	2017年8月2日
 */
public class CustomExceptionResolver implements HandlerExceptionResolver  {

	//前端控制器DispatcherServlet在进行HandlerMapping、调用HandlerAdapter执行Handler过程中，如果遇到异常就会执行此方法
	//handler最终要执行的Handler，它的真实身份是HandlerMethod
	//Exception ex就是接收到异常信息
	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		String message = null;
		CustomException customException = null;
		//如果ex是系统 自定义的异常，直接取出异常信息
		//#####################注意######################
		/**
		 *#####所有中文提示要单独抽取出来放在properties文件中#### 
		 * */
		if(ex instanceof CustomException){
			customException = (CustomException)ex;
		}else if(ex instanceof DuplicateKeyException) {
			customException = new CustomException(Constant.DUPLICATEKEY_EXCEPTION);
		}else if(ex instanceof AuthorizationException) {
			customException = new CustomException(Constant.AUTHORIZATION_EXCEPTION);
		}else if(ex instanceof MissingServletRequestParameterException) {
			customException = new CustomException(Constant.MISSING_SERVLET_REQUEST_PARAMETER_EXCEPTION);
		}else if(ex instanceof HttpMessageNotReadableException) {
			customException = new CustomException(Constant.HTTP_MESSAGE_NOT_READABLE_EXCEPTION);
		}else if(ex instanceof MethodArgumentNotValidException) {//hibernate validator 验证未通过
			BindingResult bindingResult = ((MethodArgumentNotValidException)ex).getBindingResult();
			List<ObjectError> errors = bindingResult.getAllErrors();
			String defaultMessage=null;
			if(errors!=null&&errors.size()>0) {
				 defaultMessage = errors.get(0).getDefaultMessage();
			}else {
				defaultMessage=Constant.UNKNOWN_ERROR;
			}
			
			customException = new CustomException(defaultMessage);
		}else{
		
			//针对非CustomException异常，对这类重新构造成一个CustomException，异常信息为“未知错误”
			customException = new CustomException(Constant.UNKNOWN_ERROR);
			ex.printStackTrace();
		}
		
		//错误 信息
	
			try {
				R r = new R();
				r.put("code", customException.getCode());
				r.put("errors", customException.getMessage());
				
				response.setCharacterEncoding("utf-8");
				response.setContentType("application/json;charset=utf-8");
				response.getWriter().write(JsonUtils.objectToJsonWhitI18N(r));
			} catch (Exception e) {
				
				e.printStackTrace();
				
			}

			//要返回一个空的视图 modelAndView 否则异常会抛给服务器造成http 500
			ModelAndView modelAndView = new ModelAndView();
		
		
		return modelAndView;
	}

}
