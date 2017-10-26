package com.laison.service.impl;


import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.laison.common.cache.lock.RedisLock;
import com.laison.common.enumerate.Constant;
import com.laison.common.shiro.UserRealm;
import com.laison.common.sql.Query;
import com.laison.common.utils.AesUtils;
import com.laison.common.utils.Encodes;
import com.laison.common.utils.IdGen;
import com.laison.common.utils.JedisUtils;
import com.laison.common.utils.JsonUtils;
import com.laison.common.utils.R;
import com.laison.common.utils.StringUtils;
import com.laison.entity.sysmenu.SysMenu;
import com.laison.entity.sysrole.SysRole;
import com.laison.entity.sysrole.SysRoleExample;
import com.laison.entity.sysuser.SysUser;
import com.laison.entity.sysuser.SysUserExample;
import com.laison.entity.sysuser.SysUserExample.Criteria;
import com.laison.entity.sysuser.UserView;
import com.laison.entity.sysuser.UserViewExample;
import com.laison.entity.sysuserrole.SysUserRole;
import com.laison.entity.sysuserrole.SysUserRoleExample;
import com.laison.mapper.sysmenu.SysMenuMapper;
import com.laison.mapper.sysuser.SysUserMapper;
import com.laison.mapper.sysuser.UserViewMapper;
import com.laison.mapper.sysuserrole.SysUserRoleMapper;
import com.laison.service.SysRoleService;
import com.laison.service.SysUserRoleService;
import com.laison.service.SysUserService;

@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {
	
	public final static String LAISON_USER_MENU_CACHE="laison_user_menu_cache";
	public final static String LAISON_USER_ROLE_CACHE="laison_user_role_cache";
	@Autowired
	SysUserMapper sysUserMapper;
	
	@Autowired
	SysMenuMapper sysMenuMapper;
	@Autowired
	SysUserRoleMapper sysUserRoleMapper;
	@Autowired
	UserViewMapper userViewMapper;
	@Autowired
	UserRealm userRealm;
	
	@Autowired
	private SysRoleService sysRoleService;
	

	public static final int HASH_INTERATIONS = 1024;
	public static final int SALT_SIZE = 8;
	/**
	 * 验证密码
	 * @param plainPassword 明文密码
	 * @param password 密文密码
	 * @return 验证成功返回true
	 * @throws Exception 
	 */
	public static boolean validatePassword(String plainPassword, String password)  {
		String plain = Encodes.unescapeHtml(plainPassword);
		String decryptText;
		try {
			decryptText = AesUtils.decryptText(password);
			return plain.equals(decryptText);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
		
		
	}


	@Override
	public List<SysUser> selectByExample(SysUserExample example) {
		
		return sysUserMapper.selectByExample(example);
	}
	@Override
	public SysUser login(SysUser record) {
		SysUserExample sysUserExample = new SysUserExample();
		SysUserExample.Criteria createCriteria = sysUserExample.createCriteria();
		createCriteria.andLoginNameEqualTo(record.getLoginName());
		List<SysUser> users = selectByExample(sysUserExample);
		if(users!=null&&!users.isEmpty()&&users.get(0)!=null) {
			if(validatePassword(record.getPassword(), users.get(0).getPassword())) {
				return users.get(0);
			}
		}
		
		return null;
	}


	@Override
	public List<String> queryAllMenuId(long userId) {
		return sysUserMapper.queryAllMenuId(userId);
		
	}

	@Override
	public R insert(SysUser sysuser, String roleType) {
		//检查是否由同名用户存在
		String loginName = sysuser.getLoginName();
		SysUserExample example=new SysUserExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andLoginNameEqualTo(loginName);
		int count = sysUserMapper.countByExample(example);
		if(count>0) {
			return R.error("{user.name.exist}");
		}
		RedisLock lock = JedisUtils.getLock("laison_lock_"+Constant.SYS_USER_CODE_TYPE);
		try {
            if(lock.lock()) {
            	//设置id
        		sysuser.setId(IdGen.getCode(Constant.SYS_USER_CODE_TYPE));
        		//设置密码
        		sysuser.setPassword(AesUtils.encrptText(sysuser.getPassword()));
        		if(roleType.contentEquals(Constant.ADMIN_ROLE)) {
        			sysuser.setUserType(Constant.ADMIN_USER_TYPE);
        		}else {
        			sysuser.setUserType(Constant.OPERATOR_USER_TYPE);
        		}
        		
        		//检测stationid 可以不做后期提供修改station方法
        		
        		//验证 role是不是匹配类型的role
        		SysRole role = sysRoleService.findById(sysuser.getRole().getId());
        		if(role==null||!role.getRoleType().equals(roleType)) {
        			return R.error("{role.mismatch}");
        		}
        		sysuser.setUserType(Integer.parseInt(roleType));
    				//添加user
    				sysUserMapper.insertSelective(sysuser);
    				IdGen.updateCode(Constant.SYS_USER_CODE_TYPE);
    				//添加userRole
    				SysUserRole sysUserRole = new SysUserRole();
    				sysUserRole.setId(IdGen.uuid());
    				sysUserRole.setRoleId(sysuser.getRole().getId());
    				sysUserRole.setUserId(sysuser.getId());
    				sysUserRoleMapper.insertSelective(sysUserRole);
    				return R.ok(Constant.ADD_OK);
    			
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            
            lock.unlock();
        }
		return R.error();
		
	}


	@Override
	public SysUser selectByPrimaryKey(String useId) {
		
		return null;
	}

	public List<SysUser> selectUser(String name) {
		SysUserExample sysUserExample = new SysUserExample();
		Criteria createCriteria = sysUserExample.createCriteria();
		
		createCriteria.andLoginNameEqualTo(name);
		List<SysUser> selectByExample = sysUserMapper.selectByExample(sysUserExample);
		if(selectByExample!=null) {
			return selectByExample;
		}
		return null;
	}
	@Override
	public SysMenu queryAllUserMenus(long uid) {
		
		String menuJson = JedisUtils.getFromMapCache(LAISON_USER_MENU_CACHE, uid+"");//先从内存找
		SysMenu menu =null;
		if(menuJson==null) {
			List<String> menuIds = queryAllMenuId(uid);
			SysMenu manageMenu = sysMenuMapper.selectByPrimaryKey(SysMenuServiceImpl.MANAGE_MENU_ID);
			SysMenu busninessMenu = sysMenuMapper.selectByPrimaryKey(SysMenuServiceImpl.BUSINESS_MENU_ID);
			 menu = new SysMenu();
			menu.setId("0");
			menu.setName("root");
			SysUser user = sysUserMapper.selectByPrimaryKey(uid);
			if(user!=null&&!user.getState().equals(Constant.SUPER_ADMIN)) {
				manageMenu = selectMenus(manageMenu, menuIds );
				busninessMenu=selectMenus(busninessMenu, menuIds );
			}
			
			List<SysMenu> childMenus = menu.getChildMenus();
			if(manageMenu!=null) {
				childMenus.add(manageMenu);
			}
			if(busninessMenu!=null) {
				childMenus.add(busninessMenu);
			}
			
			JedisUtils.setToMapCache(LAISON_USER_MENU_CACHE, uid+"", JsonUtils.objectToJson(menu));
		}else {
			menu=JsonUtils.jsonToPojo(menuJson, SysMenu.class);
					
		}
		
		
		
		return menu;
	}
	
   /**
	* 
	* @Title: selectMenus 
	* @Description: 从所有菜单中取出用户的菜单，移除不是自己的菜单
	* @param @param menu
	* @param @param menuIds   
	* @return SysMenu
	*/
	public SysMenu selectMenus(SysMenu menu,List<String> menuIds ) {
		
		
		if(menu!=null) {
			if(!menuIds.contains(menu.getId())||menu.getState().equals("0")){//  
				 //不能直接 menu=null ;null是基本类型修改了只在方法内有效，实参不会有作用
				return null;
			}else {
				List<SysMenu> childMenus = menu.getChildMenus();
				if(childMenus!=null&&!childMenus.isEmpty()) {
					for (int i = 0; i < childMenus.size(); i++) {
						
						childMenus.set(i,selectMenus(childMenus.get(i),menuIds ));
					}
					//删除所有变成null的对象
					Collection<Object> nuCon = new Vector<Object>(); 
					nuCon.add(null); 
					childMenus.removeAll(nuCon);
				}
				return menu;
			}
		}
		return null;
	}


	@Override
	public List<String> queryAllPerms(long userId) {
		return sysUserMapper.queryAllPerms(userId);
	}


	@Override
	public SysRole queryUserRole(Long uid) {
		String roleJson = JedisUtils.getFromMapCache(LAISON_USER_ROLE_CACHE, uid+"");//先从内存找
		SysRole role =null;
		if(roleJson==null) {
			List<SysRole> roles = sysUserMapper.queryUserRole(uid);
			if(roles!=null &&roles.size()>0) {
				role= roles.get(0);
			}
			JedisUtils.setToMapCache(LAISON_USER_ROLE_CACHE, uid+"", JsonUtils.objectToJson(role));
		}else {
			role=JsonUtils.jsonToPojo(roleJson, SysRole.class);
					
		}
		
		return role;
	}
	public void  clearMenuCache() {
		JedisUtils.delMapCache(LAISON_USER_MENU_CACHE);
	}

	public void  clearRoleCache() {
		JedisUtils.delMapCache(LAISON_USER_ROLE_CACHE);
	}
	@Override
	public R updateUser(SysUser sysuser) {
		if(sysuser.getId()==null) {
			return R.error("{user.id.null}");
		}
		SysUser oldSysUser = sysUserMapper.selectByPrimaryKey(sysuser.getId());

		if(oldSysUser==null) {
			return R.error("{user.not.exist}");
		}
		//原先的角色
		SysRole oldSysRole = queryUserRole(oldSysUser.getId());
		SysRole newRole = sysuser.getRole();
		
		if(newRole.getId()!=null) {
			newRole = sysRoleService.findById(sysuser.getRole().getId());
		}
		if(newRole==null) {
			return R.error("{role.not.exist}");
		}
		if(!newRole.getRoleType().equals(oldSysRole.getRoleType()) ){//角色不匹配
			return R.error("{role.mismatch}");
		}
		SysUser loginUser = (SysUser) SecurityUtils.getSubject().getPrincipal();
		if((!oldSysUser.getId().equals(loginUser.getId()))
				&&
				( (!loginUser.getState().equals(Integer.parseInt(Constant.SYSTEM_STATE)))
						
				||loginUser.getRole()!=null&&!loginUser.getRole().getRoleType().equals(Constant.SYSTEM_STATE)	)) {
			return R.error("{cannot.edit.other.user}");
		}
		sysuser.setUserType(null);//不能修改用户类型
		sysuser.setLoginName(null);// 不能修改loginName
		String password = sysuser.getPassword();
		if(StringUtils.isNotBlank(password)) {//如果修改了密码
			sysuser.setPassword(AesUtils.encrptText(password));
		}
		//更新用户
		sysUserMapper.updateByPrimaryKeySelective(sysuser);
		
		//更新用户角色
		SysUserRoleExample example=new SysUserRoleExample();
		com.laison.entity.sysuserrole.SysUserRoleExample.Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(sysuser.getId());
		SysUserRole record =new SysUserRole();
		record.setRoleId(newRole.getId());
		sysUserRoleMapper.updateByExampleSelective(record, example);
		
		if(oldSysUser.getId().equals(loginUser.getId())) {//如果修改的是自己放入session
			SysUser newUser = sysUserMapper.selectByPrimaryKey(sysuser.getId());
			newUser.setPassword(null);
			SysRole role = queryUserRole(sysuser.getId());
			newUser.setRole(role);
			Session session = SecurityUtils.getSubject().getSession();
			session.setAttribute("user", newUser);//更新完放入session
		}
		clearMenuCache();
		clearRoleCache();
		userRealm.clearCached();
		return R.ok("{update.ok}");
	}
	
	
	/**
	 * 
	 * @Title: canEdit 
	 * @Description: 检查是否可以编辑  不能则返回一个error
	 * @param sysuser
	 * @param isResetPassword 是否是重置密码
	 * @param isChangState 是否是改变状态
	 * @return R
	 */
	public R canEdit(SysUser sysuser,Boolean isResetPassword,Boolean isChangState) {
		if(sysuser.getId()==null) {
			return R.error("{user.id.null}");
		}
		SysUser oldSysUser = sysUserMapper.selectByPrimaryKey(sysuser.getId());
		if(oldSysUser==null) {
			return R.error("{user.not.exist}");
		}
		SysUser loginUser = (SysUser) SecurityUtils.getSubject().getPrincipal();
		Integer loginUserType = loginUser.getUserType();
		/*if(!oldSysUser.getId().equals(loginUser.getId())&&!(isResetPassword!=null&&isResetPassword)&&!(isChangState!=null&&isChangState)) {//不是更改自己的信息,并且不是重置密码，并且不是改变用户改变状态
			return R.error("{cannot.edit.other.user}");
		}*/
		if(queryUserRole(oldSysUser.getId()).getRoleType().equals(Constant.ADMIN_ROLE)&&!(isResetPassword!=null&&isResetPassword)&&!(isChangState!=null&&isChangState)) {//不是更改自己的信息,并且不是重置密码，并且不是改变用户改变状态
			return R.error("{cannot.edit.other.user}");
		}
		Integer loginUserState = loginUser.getState();
		if(oldSysUser.getState().equals(Integer.parseInt(Constant.SYSTEM_STATE))&&!loginUserState.equals(Integer.parseInt(Constant.SYSTEM_STATE))) {// 如果不是超级管理员 ， 系统用户不可编辑
			return R.error("{system.user.cannot.edit}");
		}
		Integer oldUserType = oldSysUser.getUserType();
		if(isResetPassword!=null&&isResetPassword) {//如果是重置密码
			
			if(oldUserType.equals(1)&&!loginUserState.equals(2)) {//如果重置管理员的密码，并且自己不是超级管理员
				return R.error("{admin.can.only.reset.operator.password}");
			}
		}
		if(isChangState!=null&&isChangState) {//如果是改变用户状态
			
			if(oldUserType.equals(1)&&!loginUserState.equals(2)) {//如果更改管理员的用户状态，并且自己不是超级管理员
				return R.error("{admin.can.only.change.operator.state}");
			}
		}
		return null;
	}

	/**
	 * 
	 * @Title: canEdit 
	 * @Description: TODO   
	 * @param sysuser 
	 * @param isResetPassword 是不是重置密码
	 * @return R
	 */
	public R canEdit(SysUser sysuser,Boolean isResetPassword) {
		return canEdit(sysuser,isResetPassword,false);
	}
	public R canEdit(SysUser sysuser) {
		return canEdit(sysuser,false,false);
	}
	@Override
	public R resetPassword(SysUser sysuser) {
		R error = canEdit(sysuser,true);
		if(error!=null) {
			return error;
		}
		HashMap<String, Object> hashMap = new HashMap<>();
		hashMap.put("id", sysuser.getId());
		hashMap.put("password", AesUtils.encrptText(Constant.DEFAULT_PASSWORD));
		sysUserMapper.resetPassword(hashMap);
		return R.ok(Constant.UPDATE_OK);
	}
	
	@Override
	public R changeState(SysUser sysuser) {
		R error = canEdit(sysuser,false,true);
		if(error!=null) {
			return error;
		}
		HashMap<String, Object> hashMap = new HashMap<>();
		hashMap.put("id", sysuser.getId());
		Integer state = sysuser.getState();
		if(state==null||state>1) {//只能是0和1 默认给1
			state=1;
		}
		hashMap.put("state", state);
		sysUserMapper.changeState(hashMap);
		return R.ok(Constant.UPDATE_OK);
	}


	@Override
	public R list() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public R listByPage(Query q) {
		PageHelper.startPage(q.getPage(), q.getLimit());
		
		UserViewExample example=new UserViewExample();
		com.laison.entity.sysuser.UserViewExample.Criteria userViewCriteria = example.createCriteria();
		SysUser loginUser = (SysUser) SecurityUtils.getSubject().getPrincipal();
		Integer state = loginUser.getState();
		SysRole queryUserRole = queryUserRole(loginUser.getId());
		if(!(state.equals(2)||queryUserRole.getName().equals(Constant.SUPERROLE))) {//如果不是超级管理员
			userViewCriteria.andRoleNameNotEqualTo(Constant.SUPERROLE);
		}
		List<UserView> list = userViewMapper.selectByExample(example);
		PageInfo<UserView> pageInfo = new PageInfo<UserView>(list);
		R r = R.ok();
		r.put("pageInfo", pageInfo);
		return r;
		
		
	}


	@Override
	public R findById(Long id) {
		SysUser user = sysUserMapper.selectByPrimaryKey(id);
		user.setPassword(null);
		user.setRole(queryUserRole(id));
		R ok = R.ok();
		ok.put("user", user);
		return ok;
	}


	@Override
	public R del(Long uid) {
		SysUser loginUser = (SysUser) SecurityUtils.getSubject().getPrincipal();
		if(loginUser.getId().equals(uid)) {
			return R.error("{can.del.yourself}");
		}
		SysRole role = loginUser.getRole();
		SysRole delUserRole = queryUserRole(uid);
		if(delUserRole==null||delUserRole.getState().equals(Constant.SYSTEM_STATE)) {
			//如果没有角色或者角色状态是2
			return R.error("{AuthorizationException}");
		}
		sysUserMapper.deleteByPrimaryKey(uid);
		SysUserRoleExample example= new SysUserRoleExample();
		com.laison.entity.sysuserrole.SysUserRoleExample.Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(uid);
		sysUserRoleMapper.deleteByExample(example);
		//删除其他信息  #########################待编写###############################
		return R.ok(Constant.DEL_OK);
	}
}
