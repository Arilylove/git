package com.laison.service;

import com.laison.common.utils.R;
import com.laison.entity.scheme.friendlyperiod.FriendlyPeriodScheme;

public interface FriendlyPeriodService {
	
	/**
	 * 
	* @Title: add 
	* @Description: 
	* 	添加一个友好时段方案  主键根据配置文件决定是否自动生成
	* 生成主键是需要上锁 防止生成的主键有相同的值，如果id是用户上传，则id的合法性防止bean里进行
	* 如果开启了节假日功能，则必须上传holidaySchemeCode 否则报错
	* @param @param friendlyPeriodScheme
	* @param @return   
	* @return R
	 */
	R add(FriendlyPeriodScheme friendlyPeriodScheme);

	/**
	 * 
	* @Title: del 
	* @Description: TODO 删除友好时段
	* @return R
	 */
	R del(FriendlyPeriodScheme friendlyPeriodScheme);

	/**
	 * 
	* @Title: findOne 
	* @Description: TODO 查询一个友好时段
	* @return R
	 */
	R findOne(FriendlyPeriodScheme friendlyPeriodScheme);

	/**
	 * 
	* @Title: findAll 
	* @Description: TODO 查询所有友好时段
	* @return R
	 */
	R findAll(FriendlyPeriodScheme friendlyPeriodScheme);

}
