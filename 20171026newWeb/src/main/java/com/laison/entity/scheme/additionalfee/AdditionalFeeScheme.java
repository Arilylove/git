package com.laison.entity.scheme.additionalfee;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.laison.common.annotation.ID;
import com.laison.common.utils.DateUtils;
import com.laison.common.validategroup.AddGroup;
import com.laison.common.validategroup.FindGroup;
import com.laison.common.validategroup.UpdateGroup;
import com.laison.entity.scheme.additionalfee.detail.AdditionalFeeDetail;
import com.laison.entity.scheme.price.detail.PriceSchemeDetail;

public class AdditionalFeeScheme {
	/**
	 *  主键系统自动生成
	 */
	@NotNull(groups = { UpdateGroup.class,FindGroup.class }, message = "{additional.fee.scheme.code.null}")
	@ID
    private Long additionalFeeSchemeCode;

    /**
     * 方案名称
     */
    @NotBlank(groups = { AddGroup.class }, message = "{additional.fee.scheme.name.null}")
    private String additionalFeeSchemeName;

   
	/**
     *  创建时间
     */
    private Date createDate=DateUtils.utcDate();

    /**
     * 是否启用  1-启用,0-停用，2系统方案
     */
    @Pattern(groups={AddGroup.class,UpdateGroup.class},regexp="[0|1|2]",message="{state.pattern}")
    private String state;

   /**
    * 附加费detail
    */
    @Valid
    @NotNull(groups = { AddGroup.class }, message = "{additional.fee.scheme.details.null}")
    @Size(groups = { AddGroup.class },min=1, message = "{additional.fee.scheme.details.null}")
    List<AdditionalFeeDetail> additionalFeeDetails;
    public List<AdditionalFeeDetail> getAdditionalFeeDetails() {
		return additionalFeeDetails;
	}

	public void setAdditionalFeeDetails(List<AdditionalFeeDetail> additionalFeeDetails) {
		this.additionalFeeDetails = additionalFeeDetails;
	}

    
    public Long getAdditionalFeeSchemeCode() {
        return additionalFeeSchemeCode;
    }

    public void setAdditionalFeeSchemeCode(Long additionalFeeSchemeCode) {
        this.additionalFeeSchemeCode = additionalFeeSchemeCode;
    }

    public String getAdditionalFeeSchemeName() {
        return additionalFeeSchemeName;
    }

    public void setAdditionalFeeSchemeName(String additionalFeeSchemeName) {
        this.additionalFeeSchemeName = additionalFeeSchemeName == null ? null : additionalFeeSchemeName.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }
}