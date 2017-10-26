package com.laison.service;

import com.laison.common.utils.R;
import com.laison.entity.customertype.CustomerType;

public interface CustomerTypeService {

	/**
	* @Title: addCustomerType 
	* @Description: TODO 添加客户类型
	* @return R
	 */
	R addCustomerType(CustomerType customerType);

	/**
	* @Title: delCustomerType 
	* @Description: TODO 删除客户类型
	* @return R
	 */
	R delCustomerType(CustomerType customerType);

	/**
	 * 
	* @Title: findAll 查询所有客户类型
	* @Description: TODO
	* @return R
	 */
	R findAll();

	/**
	 * 
	* @Title: findOne 
	* @Description: TODO 查找一个客户类型
	* @return R
	 */
	R findOne(CustomerType customerType);

	/**
	 * 
	* @Title: findUseful 
	* @Description: TODO 查找有用的客户类型 （state=1）
	* @return R
	 */
	R findUseful();

}
