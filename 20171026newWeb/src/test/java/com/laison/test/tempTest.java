package com.laison.test;

import java.util.ArrayList;
import java.util.HashMap;
import org.junit.Test;
import com.laison.common.utils.JsonUtils;
import com.laison.entity.sysuser.SysUser;
public class tempTest {
	@Test
	public void test() {
		/*ArrayList<SysMenu> arrayList = new ArrayList<SysMenu>();
		for (int i = 0; i < 5; i++) {
			arrayList.add(new SysMenu());
		}
		int j=0;
		for (SysMenu sysMenu : arrayList) {
			System.out.println(j);
			System.out.println(sysMenu);
			System.out.println(arrayList.get(j));
			j++;
		}
		int o=0;
		System.out.println("实参地址："+arrayList.hashCode());
		select(arrayList);
		System.out.println("改变后实参地址："+arrayList.hashCode());
		for (SysMenu sysMenu : arrayList) {
			System.out.println(o);
			System.out.println(sysMenu);
			System.out.println(arrayList.get(o));
			o++;
		}*/
		
		/*SysUser sysUser = new SysUser();
		SysRole sysRole = new SysRole();
		sysRole.setName("我的role");
		sysUser.setRole(sysRole);
		sysUser.setLoginName("seddd");
		String objectToJson = JsonUtils.objectToJson(sysUser);
		System.out.println(objectToJson);
		SysUser jsonToPojo = JsonUtils.jsonToPojo(objectToJson, SysUser.class);
		System.out.println(jsonToPojo.getLoginName());
		System.out.println(jsonToPojo.getRole().getName());*/
		
		HashMap<String, String> hashMap = new HashMap<String,String>();
		hashMap.put("a", "av");
		hashMap.put("b", "bv");
		System.out.println(hashMap.get("c"));
	}
	
	
	
}
