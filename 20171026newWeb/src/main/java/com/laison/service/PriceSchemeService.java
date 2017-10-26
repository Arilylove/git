package com.laison.service;

import com.laison.common.utils.R;
import com.laison.entity.scheme.price.PriceScheme;

public interface PriceSchemeService {
	
	/**
	 * 
	* @Title: add 添加价格方案
	* @Description: 
	* 添加价格方案时必须将所有的PriceSchemeDetails一起提交
	* vatMode=0时 不用提交vat提交了 enableVatFlag=false,vatMode=1或者=2时 enableVatFlag=true
	* enable.min.consumed=1时 可以上传 enableMinConsumedFlag，=0 enableMinConsumedFlag=false;
	* @param @param priceScheme
	* @param @return   
	* @return R
	 */
	R add(PriceScheme priceScheme);

	/**
	 * 
	* @Title: checkAndSetPriceScheme 
	* @Description:  根据配置文件检查并设置 priceScheme
	* vatMode=0时 不用提交vat提交了 enableVatFlag=false,vatMode=1或者=2时 enableVatFlag=true
	* enable.min.consumed=1时 可以上传 enableMinConsumedFlag，=0 enableMinConsumedFlag=false;
	* @param @param priceScheme
	* @param @return   
	* @return R
	 */
	R checkAndSetPriceScheme(PriceScheme priceScheme);

	/**
	 * 
	* @Title: findOne 
	* @Description: TODO
	* @param priceScheme  根据主键查找价格方案 
	* @return R
	 */
	R findOne(PriceScheme priceScheme);

	/**
	 * 
	* @Title: update 
	* @Description: 更新前检查下是否可以更新，是否有更新阶梯价格，如有必须先删除原先所有的
	* @param priceScheme
	* @return R
	 */
	R update(PriceScheme priceScheme);

	/**
	* @Title: findAll  查询说有价格方案
	* @Description: TODO
	* @return R
	 */
	R findAll();
	
	/**
	* @Title: findAllUseful 
	* @Description: TODO
	* @param @return   
	* @return R
	 */
	R findAllUseful();

	/**
	* @Title: findById  
	* @Description: TODO 获取id
	* @return PriceScheme
	 */
	PriceScheme findById(Long id);
}
