package com.laison.controller.manage;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.laison.common.exception.CustomException;
import com.laison.common.sql.Query;
import com.laison.common.utils.R;
import com.laison.common.validategroup.AddGroup;
import com.laison.common.validategroup.UpdateGroup;
import com.laison.common.web.BaseController;
import com.laison.entity.sysrole.SysRole;
import com.laison.entity.sysuser.SysUser;
import com.laison.service.SysRoleMenuService;
import com.laison.service.SysRoleService;
/**
 * <p>Title:</p>
 * <p>Description: </p>
 * <p>Company: laison</p> 
 * @author	lihua
 * @date	2017年9月8日
 */
@RestController
@RequestMapping("/sys/role")
public class RoleController extends BaseController{
	@Autowired
	private SysRoleService sysRoleService;
	@Autowired
	private SysRoleMenuService sysRoleMenuService;      
	
	/**
	 * 保存角色
	 * @throws CustomException 
	 */
	@RequestMapping("/save")
	/*@RequiresPermissions("sys:role:save")*/
	public R save(@Validated(value={AddGroup.class}) @RequestBody SysRole role) throws CustomException{	
		SysUser loginUser = (SysUser) SecurityUtils.getSubject().getPrincipal();
		role.setCreateBy(loginUser.getId());//从session取出userid
		return sysRoleService.save(role);
	}
	/**
	 * 批量删除角色
	 */
	@RequestMapping("/deleteBatch")
	/*@RequiresPermissions("sys:role:delete")*/
	public R deleteBatch(@RequestBody String[] roleIds){
		return sysRoleService.deleteBatch(roleIds);
	}
	/**
	 * 删除一个角色
	 */
	@RequestMapping("/delete")
	/*@RequiresPermissions("sys:role:delete")*/
	public R delete( @RequestParam(required=true) String roleId){
		return sysRoleService.deleteByRoleId(roleId);
	}
	/**
	 * 修改角色
	 * @throws CustomException 
	 */

	@RequestMapping("/update")
	@RequiresPermissions("sys:role:edit")
	public R update( @Validated(value={UpdateGroup.class}) @RequestBody SysRole role) throws CustomException{
		SysUser loginUser = (SysUser) SecurityUtils.getSubject().getPrincipal();
		role.setCreateBy(loginUser.getId());//从session取出userid
		return sysRoleService.update(role);
	}
	/**
	 * 角色列表 默认所有类型 的所有状态的role list
	 */
	@RequestMapping("/list")
	@RequiresPermissions("sys:role:list")
	public R list(@RequestParam(defaultValue="null")String roleType,@RequestParam(defaultValue="null")String state){
		return sysRoleService.list(roleType,state);
	}
	@RequestMapping("/listBypage")
	@RequiresPermissions("sys:role:list")
	public R listBypage(Query q){
		
		return sysRoleService.listBypage(q);
	}
	@RequestMapping("/info")
	public @ResponseBody R info(@RequestParam(required=true)String id) throws Exception{
		SysRole role = sysRoleService.findById(id);
		if(role==null) {
			return R.error("{role.not.exist}");
		}
		R ok = R.ok();
		ok.put("role", role);
		return ok;
	}
}
