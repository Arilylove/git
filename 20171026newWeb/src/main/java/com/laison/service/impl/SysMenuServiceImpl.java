package com.laison.service.impl;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

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
import com.laison.entity.SysRoleMenuExample;
import com.laison.entity.SysRoleMenuExample.Criteria;
import com.laison.entity.sysmenu.SysMenu;
import com.laison.entity.sysmenu.SysMenuExample;
import com.laison.entity.sysrole.SysRole;
import com.laison.entity.sysuser.SysUser;
import com.laison.mapper.SysRoleMenuMapper;
import com.laison.mapper.sysmenu.SysMenuMapper;
import com.laison.service.SysMenuService;

@Service("sysMenuService")
public class SysMenuServiceImpl implements SysMenuService {
	public final static String ROOT_MENU_ID = "0";
	public final static String MANAGE_MENU_ID = "1";
	public final static String BUSINESS_MENU_ID = "2";
	public final static String LAISON_MENU_CACHE = "laison_menu_cache";
	@Autowired
	SysMenuMapper sysMenuMapper;
	@Autowired
	SysRoleMenuMapper sysRoleMenuMapper;
	@Autowired
	UserRealm userRealm;

	@Override
	public R addMenu(SysMenu menu) {
		if (menu.getId() == null) {
			menu.setId(IdGen.uuid());
		}
		SysMenu pmenu = sysMenuMapper.selectByPrimaryKey(menu.getParentId());
		R checkR = checkMenuType(menu, pmenu);
		if (checkR != null) {
			return checkR;
		}
		menu.setPaths(pmenu.getPaths() + menu.getParentId() + ",");
		sysMenuMapper.insert(menu);

		// 将menu 添加给所在的角色
		Subject subject = SecurityUtils.getSubject();
		SysUser loginUser = (SysUser) subject.getPrincipal();
		SysRole role = loginUser.getRole();
		if (role != null) {
			SysRoleMenu sysRoleMenu = new SysRoleMenu();
			sysRoleMenu.setId(IdGen.uuid());
			sysRoleMenu.setMenuId(menu.getId());
			sysRoleMenu.setRoleId(role.getId());
			sysRoleMenuMapper.insert(sysRoleMenu);
		}
		// 刷新shiro
		userRealm.clearCached();
		// 刷新userMenuCache
		JedisUtils.delMapCache(SysUserServiceImpl.LAISON_USER_MENU_CACHE);
		R r = R.ok(Constant.ADD_OK);
		r.put("menu", menu);
		return r;
	}

	@Override
	public R updateMenu(SysMenu menu) {
		SysMenu scrMenu = findMenuById(menu.getId());
		if (scrMenu != null) {
			if(!menu.getType().equals(scrMenu.getType())) {
				return R.error("{can.not.edit.menu.type}");// 不去修改菜单类型
			}
			if (menu.getParentId()!=null&&!menu.getParentId().equals(scrMenu.getParentId())) {// 如果移动了菜单
				SysMenu pMenu = findMenuById(menu.getParentId());
				R checkR = checkMenuType(menu, pMenu);
				if (checkR != null) {
					return checkR;
				}
				menu.setPaths(pMenu.getPaths() + menu.getParentId() + ",");
				sysMenuMapper.updateByPrimaryKeySelective(menu);
				if (scrMenu.getChildMenus() != null && scrMenu.getChildMenus().size() > 0) {
					List<SysMenu> childMenus = scrMenu.getChildMenus();
					for (SysMenu subMenu : childMenus) {
						subMenu.setPaths(menu.getPaths() + menu.getId() + ",");
						sysMenuMapper.updateByPrimaryKeySelective(subMenu);
					}
				}
			} else {
				sysMenuMapper.updateByPrimaryKeySelective(menu);
			}
		} else {
			R r = R.error(Constant.MENU_NOT_EXIST);
			return r;
		}
		// 刷新shiro
		userRealm.clearCached();
		// 刷新userMenuCache
		JedisUtils.delMapCache(SysUserServiceImpl.LAISON_USER_MENU_CACHE);
		return R.ok("{update.ok}");
	}

	@Override
	public R findAllManageMenus() {
		// TODO Auto-generated method stub
		return findRMenuWhitChildsById(MANAGE_MENU_ID);
	}

	@Override
	public R findAllBusinessMenus() {
		// TODO Auto-generated method stub
		return findRMenuWhitChildsById(BUSINESS_MENU_ID);
	}

	@Override
	public R findAllMenus() {
		R r = R.ok();
		SysMenu manageMenu = sysMenuMapper.selectByPrimaryKey(MANAGE_MENU_ID);
		SysMenu busninessMenu = sysMenuMapper.selectByPrimaryKey(BUSINESS_MENU_ID);

		SysMenu menu = new SysMenu();
		menu.setId("0");
		menu.setName("root");
		List<SysMenu> childMenus = menu.getChildMenus();
		childMenus.add(manageMenu);
		childMenus.add(busninessMenu);
		r.put("menu", menu);
		return r;
	}

	@Override
	public R findRMenuById(String id) {
		R r;
		SysMenu menu = sysMenuMapper.findRMenuById(id);
		if (menu != null) {
			r = R.ok();
			r.put("menu", menu);
		} else {
			r = R.error(Constant.MENU_NOT_EXIST);
		}
		return r;
	}
	@Override
	public R findRMenuWhitChildsById(String id) {
		R r;
		SysMenu menu = sysMenuMapper.selectByPrimaryKey(id);
		if (menu != null) {
			r = R.ok();
			r.put("menu", menu);
		} else {
			r = R.error(Constant.MENU_NOT_EXIST);
		}
		return r;
	}

	@Override
	public SysMenu findMenuById(String id) {

		return sysMenuMapper.selectByPrimaryKey(id);

	}

	@Override
	public R delMenu(String id) {
		R r;
		SysMenu menu = findMenuById(id);
		if (menu != null) {
			if (menu.getChildMenus() != null && menu.getChildMenus().size() > 0) {
				r = R.error(Constant.MENU_CANNOT_DEL);
			} else {
				sysMenuMapper.deleteByPrimaryKey(id);
				SysRoleMenuExample example =new SysRoleMenuExample();
				Criteria createCriteria = example.createCriteria();
				createCriteria.andMenuIdEqualTo(id);
				sysRoleMenuMapper.deleteByExample(example );
				r = R.ok(Constant.DEL_OK);
			}
		} else {
			r = R.error(Constant.MENU_NOT_EXIST);
		}
		// 刷新shiro权限
		userRealm.clearCached();
		// 刷新userMenuCache
		JedisUtils.delMapCache(SysUserServiceImpl.LAISON_USER_MENU_CACHE);
		return r;
	}

	@Override
	public R queryPageList(Query q) {
		PageHelper.startPage(q.getPage(), q.getLimit());
		List<SysMenu> list = sysMenuMapper.selectAll();
		PageInfo<SysMenu> pageInfo = new PageInfo<>(list);
		R r = R.ok();
		r.put("pageInfo", pageInfo);
		return r;
	}

	@Override
	public List<SysMenu> selectByExample(SysMenuExample example) {
		// TODO Auto-generated method stub
		return sysMenuMapper.selectByExample(example);
	}

	/**
	 * 
	 * @Title: checkMenuType
	 * @Description: 检测menu是否按规则添加 目录下可以添加url和目录类型，url下可以点击button类型
	 * @param @param
	 *            menu
	 * @param @param
	 *            pmenu
	 * @param @return
	 * @return R
	 */
	public R checkMenuType(SysMenu menu, SysMenu pmenu) {

		if (pmenu == null || pmenu.getType() == null) {
			R r = R.error("{menu.pid.notexist}");
			return r;
		}
		if (pmenu.getType().equals(0)) {
			if (menu.getType().equals(2)) {
				R r = R.error("{cata.cannot.add.button}");
				return r;
			}
		} else if (pmenu.getType().equals(1)) {
			if (!menu.getType().equals(2)) {
				R r = R.error("{url.only.add.button}");
				return r;
			}
		} else if (pmenu.getType().equals(2)) {
			R r = R.error("{pmenu.cannot.button}");
			return r;
		}
		return null;

	}

	@Override
	public R delMenus(List<String> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
