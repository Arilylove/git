package com.laison.common.shiro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import com.laison.common.enumerate.Constant;
import com.laison.common.utils.AesUtils;
import com.laison.common.utils.StringUtils;
import com.laison.common.web.ValidateCodeServlet;
import com.laison.entity.sysmenu.SysMenu;
import com.laison.entity.sysmenu.SysMenuExample;
import com.laison.entity.sysrole.SysRole;
import com.laison.entity.sysuser.SysUser;
import com.laison.entity.sysuser.SysUserExample;
import com.laison.entity.sysuser.SysUserExample.Criteria;
import com.laison.service.SysMenuService;
import com.laison.service.SysUserService;

/**
 * 
 * @author Administrator
 *
 */
public class UserRealm extends AuthorizingRealm {

	@Autowired
	private SysMenuService sysMenuService;
	@Autowired
	private SysUserService sysUserService;

	/**
	 * 授权(验证权限时调用)
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SysUser user = (SysUser) principals.getPrimaryPrincipal();
		int state = user.getState();
		Long userId = user.getId();
		List<String> permsList = null;
		// 系统管理员，拥有所有权限
		if (state == (Constant.SUPER_ADMIN)) {
			SysMenuExample example = new SysMenuExample();
			List<SysMenu> menus = sysMenuService.selectByExample(example);

			permsList = new ArrayList<>(menus.size());
			for (SysMenu menu : menus) {
				permsList.add(menu.getPerms());
			}
		} else {
			permsList = sysUserService.queryAllPerms(userId);
		}

		// 用户权限列表
		Set<String> permsSet = new HashSet<String>();
		for (String perms : permsList) {
			if (StringUtils.isBlank(perms)) {
				continue;
			}
			permsSet.addAll(Arrays.asList(perms.trim().split(",")));
		}

		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.setStringPermissions(permsSet);
		return info;
	}

	/**
	 * 认证(登录时调用)
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username = (String) token.getPrincipal();
		String password = new String((char[]) token.getCredentials());
		String loginFor = ((CaptchaUsernamePasswordToken)token).getLoginFor();
		// 查询用户信息

		SysUserExample example = new SysUserExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andLoginNameEqualTo(username);
		List<SysUser> users = sysUserService.selectByExample(example);
		SysUser user;
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession(false);
		String code = (String) session.getAttribute(ValidateCodeServlet.VALIDATE_CODE);
		if (((CaptchaUsernamePasswordToken) token).getCaptcha() == null
				|| !((CaptchaUsernamePasswordToken) token).getCaptcha().toUpperCase().equals(code)) {
			throw new AuthenticationException("{validate.error}");
		}
		// 账号不存在
		if (users == null || users.size() == 0) {
			throw new UnknownAccountException("{unknown.account}");
		}
		user = users.get(0);
		// 密码错误
		if (!password.equals(AesUtils.decryptText(user.getPassword()))) {
			throw new IncorrectCredentialsException("{unknown.account}");
		}

		// 账号锁定
		if (user.getState() == 0) {
			throw new LockedAccountException("{locked.account}");
		}
		if(user.getUserType()==2&&!loginFor.equals("business")) {
			throw new IncorrectCredentialsException("{login.reject}");
		}
		/*List<SysMenu> menus = sysUserService.queryAllUserMenus(user.getId());*/
		SysRole role = sysUserService.queryUserRole(user.getId());
		if (role != null) {
			user.setRole(role);
		}
		//user.setMenus(menus);
		user.setPassword(null);
		session.setAttribute("user", user);
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, password, getName());
		return info;
	}

	public void clearCached() {
		//###########清空session 不能清除否则全部要重新登录######
		/*PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
		super.clearCache(principals);*/

		//##############清空所有 权限信息 清空会重新去数据库获取###########
		Cache<Object, AuthorizationInfo> cache = getAuthorizationCache();
		if (cache != null) {
			for (Object key : cache.keys()) {
				cache.remove(key);
			}
		}
	
	}

}
