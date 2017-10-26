package com.laison.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
* @ClassName: SysLog 
* @Description: 打上这个注解的方法将记录日志
* @author lihua
* @date 2017年10月13日 下午6:15:48 
*
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLogAnnotation {
	/** 
     * 操作类型：四种（INSERT, UPDATE, SELECT, DELETE） 
     */  
	public String optType() ;  

	/**
	 * 用哪个对象去执行
	 */
	String filedName() ;
	
	/**
	 * 用对象这个方法去获取更新前的值
	 */
	String beforeMethod() ;
	/**
	 * 用对象这个方法去获取更新后的值
	 */
	String afterMethod() ;
}
