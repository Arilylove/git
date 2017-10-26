package com.laison.service;

import java.util.List;

import com.laison.common.sql.Query;
import com.laison.common.utils.R;
import com.laison.entity.sysmenu.SysMenu;
import com.laison.entity.sysmenu.SysMenuExample;


public interface SysMenuService {

	/**
	 * 
	 * @Title: addMenu 
	 * @Description: 添加menu 并让添加者所在角色拥有该menu
	 * @param menu
	 * @return R
	 */
	R addMenu(SysMenu menu);
	/**
	 * 
	 * @Title: findAllManageMenus 
	 * @Description: 查找所有管理后台的菜单
	 * @return R
	 */
	R findAllManageMenus();
	/**
	 * 
	 * @Title: findRMenuById 
	 * @Description: 查找所有菜单
	 * @param id
	 * @return R
	 */
	R findRMenuWhitChildsById(String id);
	
	/**
	 * 
	 * @Title: findRMenuById 
	 * @Description:查找menu不带child  
	 * @param id
	 * @return R
	 */
	R findRMenuById(String id);
	/**
	 * 
	 * @Title: findAllBusinessMenus 
	 * @Description: 查找所有业务系统菜单
	 * @return R
	 */
	R findAllBusinessMenus();
	/**
	 * 
	 * @Title: findAllMenus 
	 * @Description: 查找所有菜单 按前后台分类
	 * @return R
	 */
	R findAllMenus();
	/**
	 * 
	 * @Title: delMenu 
	 * @Description: 删除菜单 然后刷新权限
	 * @param id
	 * @return R
	 */
	R delMenu(String id);
	/**
	 * 
	 * @Title: delMenu 
	 * @Description: 查找菜单
	 * @param id
	 * @return R
	 */
	SysMenu findMenuById(String id);
	/**
	 * 
	 * @Title: queryPageList
	 * @Description: 分页查找
	 * @param query
	 * @return List<SysMenu>
	 * @throws
	 */
	R queryPageList(Query q);
	List<SysMenu> selectByExample(SysMenuExample example);
	/**
	 * 
	* @Title: updateMenu 
	* @Description: 更新菜单，同时更新子菜单 
	* @param @param menu
	* @param @return   
	* @return R
	 */
	R updateMenu(SysMenu menu);
	
	/**
	 * 
	 * @Title: delMenus 
	 * @Description: 批量删除menus 
	 * @param ids
	 * @return R
	 */
	R delMenus(List<String> ids);

}
