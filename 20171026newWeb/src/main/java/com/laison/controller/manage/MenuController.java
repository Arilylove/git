package com.laison.controller.manage;


import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.laison.common.sql.Query;
import com.laison.common.utils.R;
import com.laison.common.validategroup.AddGroup;
import com.laison.common.validategroup.FindGroup;
import com.laison.common.validategroup.UpdateGroup;
import com.laison.common.web.BaseController;
import com.laison.entity.sysmenu.SysMenu;
import com.laison.entity.sysuser.SysUser;
import com.laison.service.SysMenuService;
@Controller
@RequestMapping(value = "/sys/menu")
public class MenuController extends BaseController{
	
	@Autowired
	SysMenuService sysMenuService;
	//请求key/value响应json
	@RequestMapping("/add")
	public @ResponseBody R add(@Validated(value={AddGroup.class}) @RequestBody  SysMenu menu, BindingResult result)throws Exception{
		
		R r=sysMenuService.addMenu(menu);
		return r;
	}
	
	@RequestMapping("/update")
	public @ResponseBody R update(@Validated(value={UpdateGroup.class}) @RequestBody  SysMenu menu, BindingResult result)throws Exception{
		
		R r=sysMenuService.updateMenu(menu);
		return r;
	}
	@RequestMapping("/findAllMenus")
	public @ResponseBody R findAllMenus()throws Exception{
		R r = sysMenuService.findAllMenus();
		return r;
	}
	
	@RequestMapping("/findAllManageMenus")
	public @ResponseBody R findAllManageMenus()throws Exception{
		R r = sysMenuService.findAllManageMenus();
		return r;
	}
	@RequestMapping("/findAllBusinessMenus")
	public @ResponseBody R findAllBusinessMenus()throws Exception{
		R r = sysMenuService.findAllBusinessMenus();
		return r;
	}
	@RequestMapping("/delMenu")
	public @ResponseBody R delMenu( @Validated(value={FindGroup.class}) @RequestBody SysMenu menu )throws Exception{
		R r = sysMenuService.delMenu(menu.getId());
		return r;
	}
	@RequestMapping("/delMenus")
	public @ResponseBody R delMenus(   List<String> ids )throws Exception{
		R r = sysMenuService.delMenus(ids);
		return r;
	}
	@RequestMapping("/queryPageList")
	public @ResponseBody R queryPageList(Query q ) throws Exception{
		R r = sysMenuService.queryPageList(q);
		return r;
	}
	@RequestMapping("/info")
	public @ResponseBody R info(@RequestParam(required=true)String id) throws Exception{
		R r = sysMenuService.findRMenuById(id);
		return r;
	}
}
