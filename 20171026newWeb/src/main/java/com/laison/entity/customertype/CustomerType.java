package com.laison.entity.customertype;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Value;

import com.laison.common.utils.DateUtils;
import com.laison.common.validategroup.AddGroup;
import com.laison.common.validategroup.FindGroup;
import com.laison.common.validategroup.UpdateGroup;

public class CustomerType {
	
	/**
	 *  主键 根据配置文件里的 auto.generate.customertype.code 值决定是否由系统产生
	 *  如果用户上传的 取值范围是0-1000000 
	 */
	@Range(groups = { AddGroup.class},min=0,max=1000000, message = "{customer.type.code.miss}")
	@NotNull(groups = { UpdateGroup.class, FindGroup.class }, message = "{customer.type.code.null}")
    private Long customerTypeCode;
	/**
	 * 客户类型名称
	 */
	@NotBlank(groups = { AddGroup.class }, message = "{customertype.name.null}")
    private String customerTypeName;
	/**
	 * 付费类型 0-预付费,1-后付费 默认=0 预付费 ，如果是预付费 则必须上传 预付费类型参数
	 */
	@NotNull(groups = { AddGroup.class}, message = "{pay.type.null}")
	@Range(groups = { AddGroup.class},min=0,max=1, message = "{pay.type.miss}")
    private Integer payType;
    
    /**
     * 预付费用户参数 级联检测
     */
	@Valid
    private PrepaymentCustomerParm prepaymentCustomerParm;
    
    /**
     * 用这个关联这类用户使用的表记类型
     */
    @NotNull(groups = {AddGroup.class}, message = "{metertype.code.null}")
    private Long meterTypeCode;

    /**
     * 用这个关联这类用户使用的价格方案
     */
    @NotNull(groups = {AddGroup.class}, message = "{price.scheme.type.code.null}")
    private Long priceSchemeCode;

    /**
     * 到了预约时间 启动这个价格方案 默认是0
     */
    private Long reservePriceSchemeCode=0l;
    /**
     * 预约价格启用日期 默认 默认为2000-1-1
     */
    private Date reservePriceSchemeStartTime=DateUtils.defaultDate();

    /**
     * 开户费 默认10.00 
     */ 
    private BigDecimal openAccountFee =new BigDecimal(10.00d);

    /**
     * 换表费 默认10.00
     */
    private BigDecimal replaceMeterFee=new BigDecimal(10.00d);

    /**
     * 退购手续费 默认1.00
     */
    private BigDecimal cancelPurchaseFee=new BigDecimal(1.00d);

    /**
     * 用户正常用水量上限 默认99999999
     */
    private Integer maxNormalWaterUsage;
	/**
	 * 用户正常用水量下限 默认0
	 */
    private Integer minNormalWaterUsage;
    /**
     * 冻结日 每月几号去冻结取值范围1-28 默认是1
     */
    private Integer reezeDay;
    /**
     * 创建时当地当前时间
     */
    private Date createDate=DateUtils.utcDate();
    /**
     * 32个字符分别表示1类事件到32类事件的启用状态0关闭,1打开
     * 默认 '00000000000000000000000000000000' 
     */
    private String eventFuncFlag;
    private String state;

    public Long getCustomerTypeCode() {
        return customerTypeCode;
    }
    
    /**
     * 
    * @Title: setCustomerTypeCode 
    * @Description: 设置主键
    * @param @param customerTypeCode   
    * @return void
     */
    public void setCustomerTypeCode(Long customerTypeCode) {
        this.customerTypeCode = customerTypeCode;
    }

    public String getCustomerTypeName() {
        return customerTypeName;
    }

    public void setCustomerTypeName(String customerTypeName) {
        this.customerTypeName = customerTypeName == null ? null : customerTypeName.trim();
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Long getMeterTypeCode() {
        return meterTypeCode;
    }

    public void setMeterTypeCode(Long meterTypeCode) {
        this.meterTypeCode = meterTypeCode;
    }

    public Long getPriceSchemeCode() {
        return priceSchemeCode;
    }

    public void setPriceSchemeCode(Long priceSchemeCode) {
        this.priceSchemeCode = priceSchemeCode;
    }

    public Long getReservePriceSchemeCode() {
        return reservePriceSchemeCode;
    }

    public void setReservePriceSchemeCode(Long reservePriceSchemeCode) {
        this.reservePriceSchemeCode = reservePriceSchemeCode;
    }

    public Date getReservePriceSchemeStartTime() {
        return reservePriceSchemeStartTime;
    }

    public void setReservePriceSchemeStartTime(Date reservePriceSchemeStartTime) {
        this.reservePriceSchemeStartTime = reservePriceSchemeStartTime;
    }

    public BigDecimal getOpenAccountFee() {
        return openAccountFee;
    }

    public void setOpenAccountFee(BigDecimal openAccountFee) {
        this.openAccountFee = openAccountFee;
    }

    public BigDecimal getReplaceMeterFee() {
        return replaceMeterFee;
    }

    public void setReplaceMeterFee(BigDecimal replaceMeterFee) {
        this.replaceMeterFee = replaceMeterFee;
    }

    public BigDecimal getCancelPurchaseFee() {
        return cancelPurchaseFee;
    }

    public void setCancelPurchaseFee(BigDecimal cancelPurchaseFee) {
        this.cancelPurchaseFee = cancelPurchaseFee;
    }

    public Integer getMaxNormalWaterUsage() {
        return maxNormalWaterUsage;
    }

    public void setMaxNormalWaterUsage(Integer maxNormalWaterUsage) {
        this.maxNormalWaterUsage = maxNormalWaterUsage;
    }

    public Integer getMinNormalWaterUsage() {
        return minNormalWaterUsage;
    }

    public void setMinNormalWaterUsage(Integer minNormalWaterUsage) {
        this.minNormalWaterUsage = minNormalWaterUsage;
    }

    public Integer getReezeDay() {
        return reezeDay;
    }

    public void setReezeDay(Integer reezeDay) {
        this.reezeDay = reezeDay;
    }

    public String getEventFuncFlag() {
        return eventFuncFlag;
    }

    public void setEventFuncFlag(String eventFuncFlag) {
        this.eventFuncFlag = eventFuncFlag == null ? null : eventFuncFlag.trim();
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

    public PrepaymentCustomerParm getPrepaymentCustomerParm() {
		return prepaymentCustomerParm;
	}

	public void setPrepaymentCustomerParm(PrepaymentCustomerParm prepaymentCustomerParm) {
		this.prepaymentCustomerParm = prepaymentCustomerParm;
	}

	public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }
}