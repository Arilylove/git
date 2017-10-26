package com.laison.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laison.entity.SysRoleMenu;
import com.laison.entity.SysRoleMenuExample;
import com.laison.entity.SysRoleMenuExample.Criteria;
import com.laison.mapper.SysRoleMenuMapper;
import com.laison.service.SysRoleMenuService;


@Service("sysRoleMenuService")
public class SysRoleMenuServiceImpl implements SysRoleMenuService {
	@Autowired
	private SysRoleMenuMapper sysRoleMenuMapper;
	@Override
	public void saveOrUpdate(String roleId,  ArrayList<SysRoleMenu> roleMenuList) {
		if(roleMenuList.size() == 0){
			return ;
		}
		//先删除角色与菜单关系
		sysRoleMenuMapper.deleteRoleMenus(roleId);
		//保存角色与菜单关系
		Map<String, Object> map = new HashMap<>();
		map.put("roleId", roleId);
		map.put("list", roleMenuList);
		sysRoleMenuMapper.saveRoleMenus(map);

	}
	@Override
	public void delRoleMenu(String roleId) {
		SysRoleMenuExample example =new SysRoleMenuExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andRoleIdEqualTo(roleId);
		sysRoleMenuMapper.deleteByExample(example );
		
	}

}
