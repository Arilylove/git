package com.laison.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.laison.common.enumerate.Constant;
import com.laison.common.exception.CustomException;
import com.laison.common.shiro.UserRealm;
import com.laison.common.sql.Query;
import com.laison.common.utils.IdGen;
import com.laison.common.utils.JedisUtils;
import com.laison.common.utils.R;

import com.laison.entity.SysRoleMenu;
import com.laison.entity.sysmenu.SysMenu;
import com.laison.entity.sysrole.SysRole;
import com.laison.entity.sysrole.SysRoleExample;
import com.laison.entity.sysrole.SysRoleExample.Criteria;
import com.laison.entity.sysuser.SysUser;
import com.laison.entity.sysuserrole.SysUserRoleExample;
import com.laison.mapper.sysrole.SysRoleMapper;
import com.laison.mapper.sysuser.SysUserMapper;
import com.laison.mapper.sysuserrole.SysUserRoleMapper;
import com.laison.service.SysRoleMenuService;
import com.laison.service.SysRoleService;
import com.laison.service.SysUserService;

@Service("sysRoleService")
public class SysRoleServiceImpl implements SysRoleService {
	@Autowired
	SysRoleMapper sysRoleMapper;
	@Autowired
	UserRealm userRealm;
	@Autowired
	private SysUserMapper sysUserMapper;
	@Autowired
	private SysUserRoleMapper sysUserRoleMapper;
	@Autowired
	private SysRoleMenuService sysRoleMenuService;

	@Override
	public R save(SysRole role) throws CustomException {
		if (role.getId() == null) {
			role.setId(IdGen.uuid());
		}
		
		checkPrems(role);
		//判断是否已经有同名角色
		SysRoleExample example=new SysRoleExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andNameEqualTo(role.getName());
		int count= sysRoleMapper.countByExample(example);
		if(count>0) {
			return R.error("{role.name.repeat}");
		}
		sysRoleMapper.insert(role);
		

		// 保存角色与菜单关系
		List<String> menuIdList = role.getMenuIdList();
		ArrayList<SysRoleMenu> roleMenuList = new ArrayList<SysRoleMenu>();
		for (String menuId : menuIdList) {
			SysRoleMenu sysRoleMenu = new SysRoleMenu();
			sysRoleMenu.setId(IdGen.uuid());
			sysRoleMenu.setMenuId(menuId);
			sysRoleMenu.setRoleId(role.getId());
			roleMenuList.add(sysRoleMenu);
		}
		if (roleMenuList.size() > 0) {
			sysRoleMenuService.saveOrUpdate(role.getId(), roleMenuList);
		}
		return R.ok(Constant.ADD_OK);

	}

	/**
	 * 检查权限是否越权
	 * 
	 * @throws CustomException
	 */
	private void checkPrems(SysRole role) throws CustomException {
		SysUser loginUser = (SysUser)SecurityUtils.getSubject().getPrincipal();
		// 如果不是超级管理员，则需要判断角色的权限是否超过自己的权限
		if (loginUser.getState().equals(Constant.SUPER_ADMIN)) {
			return;
		}

		// 查询用户所拥有的菜单列表
		List<String> menuIdList = sysUserMapper.queryAllMenuId(role.getCreateBy());

		// 判断是否越权
		if (!menuIdList.containsAll(role.getMenuIdList())) {
			throw new CustomException("{role.add.noauthority}");
		}
	}

	@Override
	public R queryListPage(Query query) {
		/*
		 * Set<Entry<String, Object>> entrySet = query.entrySet();
		 * Iterator<Entry<String, Object>> iterator = entrySet.iterator();
		 * SysRoleExample sysRoleExample = new SysRoleExample(); Criteria
		 * createCriteria = sysRoleExample.createCriteria();
		 * createCriteria.andNameLike(""); while(iterator.hasNext()){
		 * 
		 * } PageHelper.startPage(1, 10); PageInfo<TbItem> pageInfo = new
		 * PageInfo<>(list);
		 */
		return null;
	}

	@Override
	public R deleteBatch(String[] roleIds) {
		sysRoleMapper.deleteBatch(roleIds);
		return R.ok(Constant.DEL_OK);
	}

	@Override
	public R update(SysRole role) throws CustomException {

		SysRoleExample example = new SysRoleExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andIdEqualTo(role.getId());
		sysRoleMapper.updateByExampleSelective(role, example);

		List<String> menuIdList = role.getMenuIdList();

		if (menuIdList != null && menuIdList.size() > 0) {// 有改变角色权限
			checkPrems(role);// 检查权限是否越权
			ArrayList<SysRoleMenu> roleMenuList = new ArrayList<SysRoleMenu>();
			for (String menuId : menuIdList) {
				SysRoleMenu sysRoleMenu = new SysRoleMenu();
				sysRoleMenu.setId(IdGen.uuid());
				sysRoleMenu.setMenuId(menuId);
				sysRoleMenu.setRoleId(role.getId());
				roleMenuList.add(sysRoleMenu);
			}
			sysRoleMenuService.saveOrUpdate(role.getId(), roleMenuList);
			//刷新shiro
			userRealm.clearCached();
			//刷新userMenuCache
			JedisUtils.delMapCache(SysUserServiceImpl.LAISON_USER_MENU_CACHE);
		}
		return R.ok(Constant.UPDATE_OK);
	}

	@Override
	public R list(String roleType, String state) {
		SysRoleExample example = new SysRoleExample();
		Criteria createCriteria = example.createCriteria();
		if (!roleType.equals("null")) {

			createCriteria.andRoleTypeEqualTo(roleType);
		}
		if (!state.equals("null")) {
			createCriteria.andStateEqualTo(state);
		}
		List<SysRole> roleList = sysRoleMapper.selectByExample(example);
		R ok = R.ok();
		ok.put("list", roleList);

		return ok;
	}

	@Override
	public SysRole findById(String id) {
		
		return sysRoleMapper.selectByPrimaryKey(id);
	}

	@Override
	public int countByExample(SysRoleExample example) {
		// TODO Auto-generated method stub
		return sysRoleMapper.countByExample(example);
	}

	@Override
	public R deleteByRoleId(String roleId) {
		SysUserRoleExample example = new SysUserRoleExample();
		com.laison.entity.sysuserrole.SysUserRoleExample.Criteria createCriteria = example.createCriteria();
		createCriteria.andRoleIdEqualTo(roleId);

		int count = sysUserRoleMapper.countByExample(example);
		if (count > 0) {
			return R.error("{role.cannot.del}");
		}
		sysRoleMapper.deleteByPrimaryKey(roleId);
		sysRoleMenuService.delRoleMenu(roleId);
		return R.ok("{del.ok}");
	}

	@Override
	public R listBypage(Query q) {
		PageHelper.startPage(q.getPage(), q.getLimit());
		SysRoleExample example = new SysRoleExample();
		List<SysRole> roleList = sysRoleMapper.selectByExample(example);
		PageInfo<SysRole> pageInfo = new PageInfo<SysRole>(roleList);
		R r = R.ok();
		r.put("pageInfo", pageInfo);
		return r;
	}
}
