package com.laison.entity.scheme.holiday;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.laison.common.validategroup.AddGroup;
import com.laison.common.validategroup.FindGroup;
import com.laison.common.validategroup.UpdateGroup;
import com.laison.entity.scheme.holiday.detail.HolidayDetail;

public class HolidayScheme {
	/**
	 * 主键 非自动增量 
	 */
	@NotNull(groups = { UpdateGroup.class, FindGroup.class }, message = "{holiday.scheme.code.null}")
    private Long holidaySchemeCode;
	@NotBlank(groups = { AddGroup.class }, message = "{holiday.scheme.name.null}")
    private String holidaySchemeName;

	/**
	 * 是否启用该方案 默认1 启用
	 */
    private Boolean enableHolidaySchemeFlag;

    /**
     * 是否启用 1-启用,0-停用 默认1
     */
    private String state;
    /**
     * 方案中节假日的定义 一次性定义近十年
     */
    @Valid
    List<HolidayDetail> holidayDetails;
    public Long getHolidaySchemeCode() {
        return holidaySchemeCode;
    }

    public void setHolidaySchemeCode(Long holidaySchemeCode) {
        this.holidaySchemeCode = holidaySchemeCode;
    }

    public String getHolidaySchemeName() {
        return holidaySchemeName;
    }

    public void setHolidaySchemeName(String holidaySchemeName) {
        this.holidaySchemeName = holidaySchemeName == null ? null : holidaySchemeName.trim();
    }

    public Boolean getEnableHolidaySchemeFlag() {
        return enableHolidaySchemeFlag;
    }

    public void setEnableHolidaySchemeFlag(Boolean enableHolidaySchemeFlag) {
        this.enableHolidaySchemeFlag = enableHolidaySchemeFlag;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

	public List<HolidayDetail> getHolidayDetails() {
		return holidayDetails;
	}

	public void setHolidayDetails(List<HolidayDetail> holidayDetails) {
		this.holidayDetails = holidayDetails;
	}
    
}