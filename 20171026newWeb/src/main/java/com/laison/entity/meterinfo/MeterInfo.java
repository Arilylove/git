package com.laison.entity.meterinfo;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.laison.common.utils.DateUtils;
import com.laison.common.validategroup.AddGroup;
import com.laison.common.validategroup.FindGroup;
import com.laison.entity.meterinfo.detail.MeterInfoDetail;

public class MeterInfo extends MeterInfoKey {
	/**
	 * 客户类型代码
	 */
	@NotNull(groups = { AddGroup.class, FindGroup.class }, message = "{customer.type.code.null}")
    private Long customerTypeCode;
    /**
	 * TID base year
	 */
    Integer now = Integer.valueOf(DateUtils.getYear());
    @NotNull(groups = { AddGroup.class }, message = "{tid.base.year.null}")
    private Integer tidBaseYear = 1993+((now-1993)/21)*21;
    /**
	 * 秘钥
	 */
    @NotNull(groups = { AddGroup.class, FindGroup.class }, message = "{encrypt.key.null}")
    private Integer encryptKey;
    /**
	 * 加密方式 0硬加密 1软加密
	 */
    @NotNull(groups = { AddGroup.class, FindGroup.class }, message = "{encrypt.way.null}")
    private Integer encryptWay;
    /**
	 * 软加密 DDTK DUTK 
	 */
    private String softEncryptStates;
    /**
	 * lora上报模块
	 */
    private String loraReportFrequency;
    /**
	 * lora工作模块
	 */
    private String loraWorkFrequency;
    /**
     * 详细表号-》为批量添加
     */
    List<MeterInfoDetail> meterDetail;

    public List<MeterInfoDetail> getMeterDetail() {
		return meterDetail;
	}

	public void setMeterDetail(List<MeterInfoDetail> meterDetail) {
		this.meterDetail = meterDetail;
	}

	public Long getCustomerTypeCode() {
        return customerTypeCode;
    }

    public void setCustomerTypeCode(Long customerTypeCode) {
        this.customerTypeCode = customerTypeCode;
    }

    public Integer getTidBaseYear() {
        return tidBaseYear;
    }

    public void setTidBaseYear(Integer tidBaseYear) {
        this.tidBaseYear = tidBaseYear;
    }

    public Integer getEncryptKey() {
        return encryptKey;
    }

    public void setEncryptKey(Integer encryptKey) {
        this.encryptKey = encryptKey;
    }

    public Integer getEncryptWay() {
        return encryptWay;
    }

    public void setEncryptWay(Integer encryptWay) {
        this.encryptWay = encryptWay;
    }

    public String getSoftEncryptStates() {
        return softEncryptStates;
    }

    public void setSoftEncryptStates(String softEncryptStates) {
        this.softEncryptStates = softEncryptStates == null ? null : softEncryptStates.trim();
    }

    public String getLoraReportFrequency() {
        return loraReportFrequency;
    }

    public void setLoraReportFrequency(String loraReportFrequency) {
        this.loraReportFrequency = loraReportFrequency == null ? null : loraReportFrequency.trim();
    }

    public String getLoraWorkFrequency() {
        return loraWorkFrequency;
    }

    public void setLoraWorkFrequency(String loraWorkFrequency) {
        this.loraWorkFrequency = loraWorkFrequency == null ? null : loraWorkFrequency.trim();
    }
}