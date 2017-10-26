package com.laison.service;

import java.util.ArrayList;
import java.util.List;

import com.laison.entity.SysRoleMenu;

public interface SysRoleMenuService {

	
	/**
	 * 先删除角色菜单然后添加角色菜单
	 * @param id
	 * @param roleMenuList
	 */
	void saveOrUpdate(String id, ArrayList<SysRoleMenu> roleMenuList);
	void delRoleMenu(String roleId);
}
