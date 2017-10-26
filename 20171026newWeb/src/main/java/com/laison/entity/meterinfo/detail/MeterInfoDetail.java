package com.laison.entity.meterinfo.detail;

import javax.validation.constraints.NotNull;

import com.laison.common.validategroup.AddGroup;
import com.laison.common.validategroup.FindGroup;

public class MeterInfoDetail extends MeterInfoDetailKey {
	/**
	 * 表号
	 */
	@NotNull(groups = { AddGroup.class, FindGroup.class }, message = "{meter.num.null}")
    private String meterNum;

    public String getMeterNum() {
        return meterNum;
    }

    public void setMeterNum(String meterNum) {
        this.meterNum = meterNum == null ? null : meterNum.trim();
    }
}