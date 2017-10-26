package com.laison.service;

import com.laison.common.utils.R;
import com.laison.entity.metertype.MeterType;

public interface MeterTypeService {

	/**
	* @Title: add 
	* @Description: TODO 添加表类型
	* @return R
	 */
	R add(MeterType meterType);

	/**
	* @Title: del 
	* @Description: TODO 删除表类型
	* @return R
	 */
	R del(MeterType meterType);

	/**
	* @Title: update 
	* @Description: TODO 更新表类型
	* @return R
	 */
	R update(MeterType meterType);

	/**
	* @Title: findOne 
	* @Description: TODO 查询某一个表类型
	* @return R
	 */
	R findOne(MeterType meterType);

	/***
	* @Title: findAll 
	* @Description: 
	* 查找所有,因为本身数量不多用不着分页
	* @param @return   
	* @return R
	 */
	R findAll();

	

}
