package com.laison.service;

import com.laison.common.utils.R;
import com.laison.entity.regioninfo.RegionInfo;

public interface RegionInfoService {

	/**
	* @Title: find 
	* @Description: TODO 查询行政区域信息
	* @return RegionInfo
	 */
	RegionInfo find(Long regionCode);

	/** 
	* @Title: add 
	* @Description: TODO 添加行政区域信息
	* @return R
	 */
	R add(RegionInfo regionInfo);

	/**
	* @Title: delRegion 
	* @Description: TODO 删除行政区域信息
	* @return R
	 */
	R delRegion(Long regionCode);

	/**
	* @Title: updateRegion 
	* @Description: TODO 更新行政区域信息
	* @return R
	 */
	R updateRegion(RegionInfo regionInfo);

}
