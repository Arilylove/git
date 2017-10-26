package com.laison.service;

import com.laison.common.utils.R;
import com.laison.entity.meterinfo.MeterInfo;

public interface MeterInfoService {

	/**
	 * 表计入库
	 * @param meterInfo
	 * @return
	 */
	R addMeter(MeterInfo meterInfo);
	
	/**
	 * 查询表计信息
	 * @return
	 */
	R findAll();

	/**
	 * 更新表计信息
	 * @param meterInfo
	 * @return
	 */
	R updateMeter(MeterInfo meterInfo);

	/**
	 * 根据表号查询表计信息
	 * @param id
	 * @return
	 */
	R findMeterById(Long id);

	/**
	 * 根据表计信息查询表
	 * @param meterInfo
	 * @return
	 */
	R findMeterByInfo(MeterInfo meterInfo);
}
