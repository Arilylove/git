package com.laison.service;

import com.laison.common.exception.CustomException;
import com.laison.common.sql.Query;
import com.laison.common.utils.R;
import com.laison.entity.sysrole.SysRole;
import com.laison.entity.sysrole.SysRoleExample;

/**
 * 
* @ClassName: SysRoleService 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author lihua
* @date 2017年9月11日 上午9:54:44 
*
 */
public interface SysRoleService {
	/**
	 * @throws CustomException
	 * @Title: save 
	 * @Description: 保存role
	 * @param role void
	 *
	 */
	R save(SysRole role) throws CustomException;
	/**
	 * 分页查找
	 * @Title: queryListPage 
	 * @Description: TODO
	 * @param query
	 * @return R
	 * @throws
	 */
	R queryListPage(Query query);
	
	/**
	 * 批量删除role,然后批量删除role_menu,然后批量删除user_role
	 * 如果要强制正在使用中的role不能删除，方案一：做外键，删除的时候报异常，然后捕获异常。，方案二：程序判断。
	 * @Title: deleteBatch 
	 * @Description: TODO
	 * @param @param roleIds
	 * @param @return   
	 * @return R
	 */
	R deleteBatch(String[] roleIds);
	/**
	 * 更新角色是要检查是否越权，更新完成后要刷新shiro权限
	 * @param role
	 * @return
	 * @throws CustomException
	 */
	R update(SysRole role) throws CustomException;
	/**
	 * 
	* @Title: list 
	* @Description: 根据类型列出所有角色
	* @param @param roleType 0所有 1管理员类型的角色  2操作员类型的角色 
	* @param @return   
	* @return R
	 */
	R list(String roleType,String state);
	
	SysRole findById(String id);
	
	
	int countByExample(SysRoleExample example);
	/**
	 * 根据角色id删除角色 正在使用的无法删除
	 * @param roleId
	 * @return
	 */
	R deleteByRoleId(String roleId);
	R listBypage(Query q);
	

}
