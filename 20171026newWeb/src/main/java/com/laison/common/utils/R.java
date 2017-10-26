package com.laison.common.utils;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 返回数据
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年10月27日 下午9:59:27
 */
@JsonInclude(JsonInclude.Include.NON_NULL)  
public class R extends HashMap<Object,Object> {
	private static final long serialVersionUID = 1L;
	
	public R() {
		put("code", 0);
	}
	
	public static R error() {
		R r = new R();
		r.put("code", 500);
		return  r;
	}
	
	public static R error(String msg) {
		return error(500, msg);
	}
	
	public static R error(int code, String msg) {
		R r = new R();
		r.put("code", code);
		r.put("errors", msg);
		return r;
	}

	public static R ok(String msg) {
		R r = new R();
		r.put("msg", msg);
		return r;
	}
	
	public static R ok(Map<String, Object> map) {
		R r = new R();
		r.putAll(map);
		return r;
	}
	
	public static R ok() {
		return new R();
	}

	/*public R put(String key, Object value) {
		super.put(key, value);
		return this;
	}*/
	
	
	/*private HashMap<String , Object> contentMap =new HashMap<String , Object>();
	public void put (String key, Object value) {
		contentMap.put(key, value);
	}
	public void putAll (Map<String, Object> map) {
		contentMap.putAll( map);
	}

	public HashMap<String, Object> getContentMap() {
		return contentMap;
	}

	public void setContentMap(HashMap<String, Object> contentMap) {
		this.contentMap = contentMap;
	}
	*/
	
}
