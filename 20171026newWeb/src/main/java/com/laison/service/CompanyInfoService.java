package com.laison.service;

import com.laison.common.utils.R;
import com.laison.entity.companyinfo.CompanyInfo;
import com.laison.entity.stationinfo.StationInfo;

public interface CompanyInfoService {

	/**
	 * 
	* @Title: addCompany 
	* @Description: TODO 添加公司信息
	* @return R
	 */
	R addCompany(CompanyInfo company);
	/**
	 * 
	* @Title: addStation 
	* @Description: TODO 添加营业厅信息
	* @return R
	 */
	R addStation(StationInfo stationInfo);
	/**
	 * 
	* @Title: delCompany 
	* @Description: TODO 删除公司信息
	* @return R
	 */
	R delCompany(CompanyInfo company);
	/**
	 * 
	* @Title: delStation 
	* @Description: TODO 删除营业厅信息
	* @return R
	 */
	R delStation(StationInfo station);
	/**
	 * 
	* @Title: updateCompany 
	* @Description: TODO 更新公司信息
	* @return R
	 */
	R updateCompany(CompanyInfo company);
	/**
	 * 
	* @Title: updateStation 
	* @Description: TODO 更新营业厅信息
	* @return R
	 */
	R updateStation(StationInfo station);
	/**
	 * 
	* @Title: findCompany 
	* @Description: TODO 查询公司信息
	* @return R
	 */
	R findCompany(CompanyInfo company);
}
