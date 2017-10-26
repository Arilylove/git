package com.laison.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;

import com.laison.common.cache.JedisCacheManager;
import com.laison.common.cache.JedisCacheManager.JedisCache;
import com.laison.common.utils.JedisUtils;
import com.laison.common.utils.JsonUtils;
import com.laison.common.utils.ObjectUtils;
import com.laison.entity.sysmenu.SysMenu;
import com.laison.entity.sysrole.SysRole;
import com.laison.entity.sysuser.SysUser;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) // 使用junit4进行测试
@ContextConfiguration({ "classpath:/spring/app*.xml" }) // 加载配置文件
public class ViewRedisValue {
	@Test
	public void test() {
		JedisCacheManager jedisCacheManager = new JedisCacheManager();
		jedisCacheManager.setCacheKeyPrefix("laison_shiro_cache_");
		JedisCache<Object, Object> cache = (JedisCache<Object, Object>) jedisCacheManager
				.getCache("activeSessionsCache");
		// System.out.println("##############################"+JsonUtils.objectToJson(cache));
		Object object = cache.get("9c72e9a5b1164c85a34ef8dac46b5e93");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@" + JsonUtils.objectToJson(object));

	}

	@Test
	public void testHkey() {
		JedisCacheManager jedisCacheManager = new JedisCacheManager();
		jedisCacheManager.setCacheKeyPrefix("laison_shiro_cache_");
		JedisCache<Object, Object> cache = (JedisCache<Object, Object>) jedisCacheManager
				.getCache("com.laison.common.shiro.UserRealm.authorizationCache");
		// System.out.println("##############################"+JsonUtils.objectToJson(cache));

		Set<Object> keys = cache.keys();
		for (Object object : keys) {
			byte[] bytesKey = JedisUtils.getBytesKey(object);
			Object objectKey = JedisUtils.getObjectKey(bytesKey);
			System.out.println(objectKey == object);
			cache.remove(object);
		}
	}
	@Test
	public void testHkey22() {
		JedisCacheManager jedisCacheManager = new JedisCacheManager();
		jedisCacheManager.setCacheKeyPrefix("laison_shiro_cache_");
		JedisCache<Object, Object> cache = (JedisCache<Object, Object>) jedisCacheManager
				.getCache("activeSessionsCache");
		// System.out.println("##############################"+JsonUtils.objectToJson(cache));

		Set<Object> keys = cache.keys();
		for (Object object : keys) {
			
			cache.remove(object);
		}
	}
	@Test
	public void testHkeya() {
		/*SysUser sysUser = new SysUser();
		sysUser.setLoginName("lihua");
		SysRole sysRole = new SysRole();
		sysRole.setName("admin");
		sysUser.setRole(sysRole);
		SysMenu sysMenu1 = new SysMenu();
		sysMenu1.setName("aaaaa");
		SysMenu sysMenu2 = new SysMenu();
		sysMenu2.setName("bbbb");
		SysMenu sysMenu3 = new SysMenu();
		sysMenu3.setName("cccc");
		SysMenu sysMenu4 = new SysMenu();
		sysMenu4.setName("dddd");
		List<SysMenu> menus = new ArrayList<>();
		menus.add(sysMenu1);
		menus.add(sysMenu2);
		menus.add(sysMenu3);
		menus.add(sysMenu4);
		sysUser.setMenus(menus);
		byte[] bytesKey = JedisUtils.getBytesKey(sysUser);
		SysUser objectKey = (SysUser)JedisUtils.getObjectKey(bytesKey);
		String loginName = objectKey.getLoginName();
		System.out.println("登录名是"+loginName);
		byte[] bytesKey2 = JedisUtils.getBytesKey(objectKey);
		if(bytesKey.equals(bytesKey2)) {
			System.out.println("相等");
		}else {
			System.out.println("不相等");
		}*/
		byte[] serialize = ObjectUtils.serialize("dfsdfsdf");
		String unserialize = (String) ObjectUtils.unserialize(serialize);
		System.out.println(unserialize);
	}
}
