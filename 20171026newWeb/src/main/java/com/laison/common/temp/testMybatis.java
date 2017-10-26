package com.laison.common.temp;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.laison.entity.sysuser.SysUser;
import com.laison.mapper.sysuser.SysUserMapper;


public class testMybatis {
	SysUserMapper sysUserMapper;
	 @BeforeClass
	 public void init() {//junit之前init spring
	        @SuppressWarnings("resource")
			ApplicationContext   context = new ClassPathXmlApplicationContext("E:\\workset\\WebLapisAPI\\src\\main\\resources\\spring\\applicationContext-*.xml");//这里路径之前没有配对于是一直出错
	        sysUserMapper=context.getBean(SysUserMapper.class);
	 }
	 
	 @Test
	 void findRoleList() {
	        System.out.println("shuchu");
	        SysUser sysUser = new SysUser();
	        sysUser.setLoginName("admin");
	        sysUser.setPassword("123456");
	        sysUserMapper.insert(sysUser);
	       
	}

}