package com.laison.service;

import com.laison.common.sql.Query;
import com.laison.common.utils.R;
import com.laison.entity.scheme.additionalfee.AdditionalFeeScheme;
import com.laison.entity.scheme.additionalfee.detail.AdditionalFeeDetail;

public interface AdditionalFeeSchemeService {

	/**
	* @Title: addScheme 
	* @Description:  添加附加费方案 
	* 每个附加费项目包含如下内容：名称，扣费类型(根据配置文件)，
	* @param additionalFeeScheme
	* @return R    返回类型 
	 */
	R addScheme(AdditionalFeeScheme additionalFeeScheme);

	/**
	* @Title: findAll 
	* @Description: TODO 查询所有附加费方案
	* @return R
	 */
	R findAll();

	/**
	* @Title: delScheme 
	* @Description: TODO 删除附加费方案 同时删除details 并且删除客户对应的附加费
	* @return R
	 */
	R delScheme(AdditionalFeeScheme additionalFeeScheme);

	/**
	* @Title: updateScheme 
	* @Description:只修改scheme  不去修改里面的附加费
	* @return R
	 */
	R updateScheme(AdditionalFeeScheme additionalFeeScheme);
	/**
	* @Title: findById 
	* @Description: TODO 获取id
	* @return AdditionalFeeScheme
	 */
	AdditionalFeeScheme findById(Long id);

	/**
	 * @Title: updateDetail 
	 * @Description: 
	 * 	更新 一个 detail  ,如果detail被使用则需要同时更新客户对应的detail 不能修改 客户附加费的次数 和 开始扣费日期
	 * 已经被用户使用的系统附加费，禁止删除。修改时，只能修改扣费金额、比例、次数
	 * 没有被用户使用的系统附加费，允许作任何修改。
	 * @param additionalFeeDetail
	 * @return R
	 */
	R updateDetail(AdditionalFeeDetail additionalFeeDetail);

	/**
	 * 
	 * @Title: insertDetailToScheme 
	 * @Description: 往方案里插入附加费项目   
	 * @param additionalFeeDetail
	 * @return R
	 */
	R insertDetailToScheme(AdditionalFeeDetail additionalFeeDetail);

	/**
	 * 
	 * @Title: delDetailFromScheme 
	 * @Description:  从方案里删除某个附加费项目，确认删除后，后端需要先删除该附加费方案，再删除客户附加费里的这些方案对应的项目。   
	 * @param additionalFeeDetail
	 * @return R
	 */
	R delDetailFromScheme(AdditionalFeeDetail additionalFeeDetail);

	/**
	 * 
	 * @Title: listByPage 
	 * @Description: 分页查找   
	 * @param q
	 * @return R
	 */
	R listByPage(Query q);

	
}
