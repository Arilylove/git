package com.laison.controller.manage;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.laison.common.enumerate.Constant;
import com.laison.common.sql.Query;
import com.laison.common.utils.R;
import com.laison.common.validategroup.AddGroup;
import com.laison.common.validategroup.AddOperatorGroup;
import com.laison.common.validategroup.UpdateGroup;
import com.laison.common.web.BaseController;
import com.laison.entity.sysrole.SysRole;
import com.laison.entity.sysuser.SysUser;
import com.laison.service.SysUserService;
@Controller
@RequestMapping(value = "/sys/user")
public class UserController extends BaseController{
	@Autowired
	SysUserService sysUserService;
	//请求key/value响应json
	@RequestMapping("/addOperator")
	public @ResponseBody R addOperator(@RequestBody @Validated(value={AddOperatorGroup.class,AddGroup.class})SysUser sysuser)throws Exception{
		if(sysuser.getRole()==null||sysuser.getRole().getId()==null) {
			return R.error("{role.id.null}");
		}
		SysUser loginUser = (SysUser) SecurityUtils.getSubject().getPrincipal();
		sysuser.setCreateBy(loginUser.getId());//取出session用户
		return sysUserService.insert(sysuser,Constant.OPERATOR_ROLE);
	}
	@RequestMapping("/addAdmin")
	public @ResponseBody R addAdmin(@RequestBody @Validated(value={AddGroup.class})SysUser sysuser)throws Exception{
		if(sysuser.getRole()==null||sysuser.getRole().getId()==null) {
			return R.error("{role.id.null}");
		}
		SysUser loginUser = (SysUser) SecurityUtils.getSubject().getPrincipal();
		sysuser.setCreateBy(loginUser.getId());//取出session用户
		return sysUserService.insert(sysuser,Constant.ADMIN_ROLE);
	}
	

	@RequestMapping("/resetPassword")
	public @ResponseBody R resetPassword(@RequestBody @Validated(value={UpdateGroup.class})SysUser sysuser)throws Exception{
		return sysUserService.resetPassword(sysuser);
	}
	@RequestMapping("/changeState")
	public @ResponseBody R changeState(@RequestBody @Validated(value={UpdateGroup.class})SysUser sysuser)throws Exception{
		return sysUserService.changeState(sysuser);
	}
	@RequestMapping("/update")
	public @ResponseBody R update(@RequestBody @Validated(value={UpdateGroup.class})SysUser sysuser)throws Exception{
		return sysUserService.updateUser(sysuser);
	}
	@RequestMapping("/list")
	@RequiresPermissions("sys:user:list")
	public @ResponseBody R list()throws Exception{
		return sysUserService.list();
	}
	@RequestMapping("/listByPage")
	@RequiresPermissions("sys:user:list")
	public @ResponseBody R listByPage(Query q)throws Exception{
		return sysUserService.listByPage( q);
	}
	
	@RequestMapping("/del")
	public @ResponseBody R del(@RequestParam(required=true)Long id)throws Exception{
		return sysUserService.del( id);
	}
	@RequestMapping("/info")
	public @ResponseBody R info(@RequestParam(required=true)Long id) throws Exception{
		
		return sysUserService.findById(id);
	}
}
