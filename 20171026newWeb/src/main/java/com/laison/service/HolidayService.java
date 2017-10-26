package com.laison.service;

import com.laison.common.utils.R;
import com.laison.entity.scheme.holiday.HolidayScheme;

public interface HolidayService {

	/**
	* @Title: add 
	* @Description: TODO 添加节假日方案
	* @return R
	 */
	R add(HolidayScheme holidayScheme);

	/**
	* @Title: findOne 
	* @Description: TODO 查询某一个节假日方案
	* @return R
	 */
	R findOne(HolidayScheme holidayScheme);
	
	/**
	* @Title: uddateOne 
	* @Description: 更新节假日方案，如果修改了holidayDetail holidayDetail的holidayVersion加1
	* @param @param holidayScheme
	* @param @return   
	* @return R
	 */
	R updateOne(HolidayScheme holidayScheme);
	/**
	 * 
	* @Title: del 
	* @Description: 先判断有没有被友好事件方案使用，如果被使用了不能删除
	* @param @param holidayScheme
	* @param @return   
	* @return R
	 */
	R del(HolidayScheme holidayScheme);

	/**
	 * 
	* @Title: findAll 
	* @Description: 查找所有节假日方案，本身不多用不着分页
	* @param @return   
	* @return R
	 */
	R findAll();

}
