package com.laison.service;

import java.util.List;

import com.laison.common.sql.Query;
import com.laison.common.utils.R;
import com.laison.entity.sysmenu.SysMenu;
import com.laison.entity.sysrole.SysRole;
import com.laison.entity.sysuser.SysUser;
import com.laison.entity.sysuser.SysUserExample;

public interface SysUserService extends BaseService {

	SysUser login(SysUser record);

	/**
	 * 
	 * @Title: queryAllMenuId
	 * @Description: 查询用户所有的menuid
	 * @param uid
	 * @return List<Long>
	 */
	List<String> queryAllMenuId(long uid);

	/**
	 * 
	 * @Title: queryAllUserMenus
	 * @Description: 查询用户所有的menu 管理员有全部menu
	 * @param @param
	 *            uid
	 * @param @return
	 * @return List<SysMenu>
	 */
	SysMenu queryAllUserMenus(long uid);

	/**
	 * 
	 * @Title: insert
	 * @Description: 插入一个 用户，用户类型是 roleType,1是admin 2是Operator
	 * @param sysuser
	 *            roleType
	 * @return R
	 */
	R insert(SysUser sysuser, String roleType);

	List<SysUser> selectByExample(SysUserExample example);

	SysUser selectByPrimaryKey(String useId);

	/**
	 * 
	 * @Title: queryAllPerms
	 * @Description: 查询所有权限
	 * @param @param
	 *            userId
	 * @param @return
	 * @return List<String>
	 */
	List<String> queryAllPerms(long userId);

	/**
	 * 
	 * @Title: queryUserRole
	 * @Description: 查询用户的角色
	 * @param id
	 * @return SysRole
	 */
	SysRole queryUserRole(Long id);

	/**
	 * 
	 * @Title: updateUser
	 * @Description:  更新用户，操作员不能更改其他用户管理员能更新除超级管理员外的所有角色
	 * @param sysuser
	 * @return R
	 */
	R updateUser(SysUser sysuser);

	/**
	 * 
	 * @Title: resetPassword 
	 * @Description: 重置用户的密码  
	 * @param sysuser
	 * @return R
	 */
	R resetPassword(SysUser sysuser);

	/**
	 * 
	 * @Title: changeState 
	 * @Description: 只能管理员更改操作员  
	 * @param sysuser
	 * @return R
	 */
	R changeState(SysUser sysuser);

	R list();

	R listByPage(Query q);

	/**
	 * 
	 * @Title: findById 
	 * @Description:  根据id查找用户 
	 * @param id
	 * @return R
	 */
	R findById(Long id);

	/**
	 * 
	 * @Title: del 
	 * @Description: 删除用户 同时删除用户的各种信息  
	 * 超级管理员不能被任何用户删除
	 * 管理员可以创建或删除其他的管理员，但是不能删除自己，也不能删除超级管理员
	 * @param id
	 * @return R
	 */
	R del(Long id);

}
