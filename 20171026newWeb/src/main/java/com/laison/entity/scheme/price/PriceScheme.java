package com.laison.entity.scheme.price;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import com.laison.common.annotation.ID;
import com.laison.common.utils.DateUtils;
import com.laison.common.validategroup.AddGroup;
import com.laison.common.validategroup.FindGroup;
import com.laison.common.validategroup.UpdateGroup;
import com.laison.entity.scheme.price.detail.PriceSchemeDetail;

public class PriceScheme {
	/**
	 * 主键
	 */
	@NotNull(groups = { UpdateGroup.class, FindGroup.class }, message = "{price.scheme.code.null}")
	@ID
    private Long priceSchemeCode;
	 /**
     * 价格方案名字
     */
    @NotBlank(groups = { AddGroup.class }, message = "{price.scheme.name.null}")
    private String priceSchemeName;

    /**
     * 是否启用月最低消费功能 0-不开启，1-开启  根据配置文件
     */
    private Boolean enableMinConsumedFlag;

    /**
     * 月最低消费量 启用模式下默认5.00  不启用模式下0.00
     */
    @Range(groups = { AddGroup.class,UpdateGroup.class }, min = 0, message = "{less.than.zero}")
    private BigDecimal mouthMinConsumedQuantity=new BigDecimal(5.00);

    /**
     * 月最低消费金额 默认5.00
     */
    @Range(groups = { AddGroup.class,UpdateGroup.class }, min = 0, message = "{less.than.zero}")
    private BigDecimal mouthMinConsumedAmount=new BigDecimal(5.00);;

    /**
     * 阶梯价格模式 0-多段模式,1-单段模式 根据配置
     */
    private Integer sectionMode;

    /**
     * EnableVAT 0-不开启，1-开启
     */
    private Boolean enableVatFlag;

    /**
     * 增值税百分比 取值范围0.00-100.00 默认0.00
     */
    @Range(groups = { AddGroup.class,UpdateGroup.class},min=0,max=100, message = "{vat.range.error}")
    private BigDecimal vat;

    private Date createDate=DateUtils.utcDate();
    /**
     * 是否启用  1-启用,0-停用，2系统方案
     */
    private String state;

    @Valid
    @NotNull(groups = { AddGroup.class }, message = "{price.scheme.details.null}")
    @Size(groups = { AddGroup.class },min=1, message = "{price.scheme.details.null}")
    List<PriceSchemeDetail> priceSchemeDetails;
    /**
     * 
    * @Title: getPriceSchemeCode 
    * @Description: 获取主键
    * @param @return   
    * @return Long
     */
    public Long getPriceSchemeCode() {
        return priceSchemeCode;
    }

    public void setPriceSchemeCode(Long priceSchemeCode) {
        this.priceSchemeCode = priceSchemeCode;
    }

    public String getPriceSchemeName() {
        return priceSchemeName;
    }

    public void setPriceSchemeName(String priceSchemeName) {
        this.priceSchemeName = priceSchemeName == null ? null : priceSchemeName.trim();
    }

    public Boolean getEnableMinConsumedFlag() {
        return enableMinConsumedFlag;
    }

    public void setEnableMinConsumedFlag(Boolean enableMinConsumedFlag) {
        this.enableMinConsumedFlag = enableMinConsumedFlag;
    }

    public BigDecimal getMouthMinConsumedQuantity() {
        return mouthMinConsumedQuantity;
    }

    public void setMouthMinConsumedQuantity(BigDecimal mouthMinConsumedQuantity) {
        this.mouthMinConsumedQuantity = mouthMinConsumedQuantity;
    }

    public BigDecimal getMouthMinConsumedAmount() {
        return mouthMinConsumedAmount;
    }

    public void setMouthMinConsumedAmount(BigDecimal mouthMinConsumedAmount) {
        this.mouthMinConsumedAmount = mouthMinConsumedAmount;
    }

    public Integer getSectionMode() {
        return sectionMode;
    }

    public void setSectionMode(Integer sectionMode) {
        this.sectionMode = sectionMode;
    }

    public Boolean getEnableVatFlag() {
        return enableVatFlag;
    }

    public void setEnableVatFlag(Boolean enableVatFlag) {
        this.enableVatFlag = enableVatFlag;
    }

    public BigDecimal getVat() {
        return vat;
    }

    public void setVat(BigDecimal vat) {
        this.vat = vat;
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

	public List<PriceSchemeDetail> getPriceSchemeDetails() {
		return priceSchemeDetails;
	}

	public void setPriceSchemeDetails(List<PriceSchemeDetail> priceSchemeDetails) {
		this.priceSchemeDetails = priceSchemeDetails;
	}
    
}