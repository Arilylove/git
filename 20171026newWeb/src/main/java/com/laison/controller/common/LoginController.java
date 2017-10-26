package com.laison.controller.common;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.laison.common.enumerate.Constant;
import com.laison.common.temp.updateCode;
import com.laison.common.utils.R;
import com.laison.common.validategroup.UpdateGroup;
import com.laison.entity.sysmenu.SysMenu;
import com.laison.entity.sysmenu.SysMenuExample;
import com.laison.entity.sysuser.SysUser;
import com.laison.service.SysMenuService;
import com.laison.service.SysUserService;

@Controller
public class LoginController {
	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private SysMenuService sysMenuService;
	@RequestMapping("/login")
	public @ResponseBody R login() throws Exception {

		Subject subject = SecurityUtils.getSubject();
		SysUser loginUser = (SysUser) subject.getPrincipal();
		R ok = R.ok("{already.login}");
		ok.put("user", loginUser);
		return ok;
	}

	@RequestMapping("/getLoginUser")
	public @ResponseBody R getLoginUser() throws Exception {
		Session session = SecurityUtils.getSubject().getSession();
		SysUser loginUser = (SysUser)session.getAttribute("user");;
		R ok = R.ok();
		ok.put("user", loginUser);
		return ok;
	}
	@RequestMapping("/updateUser")
	public @ResponseBody R updateUser(@RequestBody @Validated(value={UpdateGroup.class})SysUser sysuser)throws Exception{
		
		return sysUserService.updateUser(sysuser);
	}
	@RequestMapping("/logoutSuccess")
	public @ResponseBody R logoutSuccess() throws Exception {

		R ok = R.ok("{logout.success}");
		return ok;
	}

	@RequestMapping("/getMyManageMenu")
	public @ResponseBody R getManageMenu() throws Exception {
		Subject subject = SecurityUtils.getSubject();
		SysUser loginUser = (SysUser) subject.getPrincipal();
		Long userId = loginUser.getId();
		SysMenu menu = sysUserService.queryAllUserMenus(userId);
		R ok = R.ok("");
		ok.put("menu", null);
		List<SysMenu> childMenus = menu.getChildMenus();
		for (SysMenu sysMenu : childMenus) {
			if (sysMenu.getId().equals("1")) {
				ok.put("menu", sysMenu);
			}
		}
		return ok;
	}

	@RequestMapping("/getMyBusinessMenu")
	public @ResponseBody R getBusinessMenu() throws Exception {
		Subject subject = SecurityUtils.getSubject();
		SysUser loginUser = (SysUser) subject.getPrincipal();
		Long userId = loginUser.getId();
		SysMenu menu = sysUserService.queryAllUserMenus(userId);
		R ok = R.ok("");
		ok.put("menu", null);
		List<SysMenu> childMenus = menu.getChildMenus();
		for (SysMenu sysMenu : childMenus) {
			if (sysMenu.getId().equals("2")) {
				ok.put("menu", sysMenu);
			}
		}
		return ok;
	}

	@RequestMapping("/getMyAllMenu")
	public @ResponseBody R getMyAllMenu() throws Exception {
		Subject subject = SecurityUtils.getSubject();
		SysUser loginUser = (SysUser) subject.getPrincipal();
		Long userId = loginUser.getId();
		SysMenu menu = sysUserService.queryAllUserMenus(userId);
		R ok = R.ok("");
		ok.put("menu", menu);
		return ok;
	}
	@RequestMapping("/test")
	public @ResponseBody R test() throws Exception {
		Thread thread1 = new Thread(new updateCode());
		thread1.start();
		Thread thread2 = new Thread(new updateCode());
		thread2.start();
		return R.ok("完成");
	}
}
