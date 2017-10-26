package com.laison.entity.stationinfo;

import javax.validation.constraints.NotNull;

import com.laison.common.validategroup.AddGroup;
import com.laison.common.validategroup.FindGroup;
import com.laison.common.validategroup.UpdateGroup;

public class StationInfoKey {
	/**
	 * 联合主键
	 * 公司编号
	 */
	@NotNull(groups={AddGroup.class,UpdateGroup.class,FindGroup.class},message="{companycode.null}")
    private Long companyCode;
	/**
	 * 联合主键
	 * 站点编号
	 */
	@NotNull(groups={UpdateGroup.class,FindGroup.class},message="{stationcode.null}")
    private Long stationCode;

    public Long getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(Long companyCode) {
        this.companyCode = companyCode;
    }

    public Long getStationCode() {
        return stationCode;
    }

    public void setStationCode(Long stationCode) {
        this.stationCode = stationCode;
    }
}