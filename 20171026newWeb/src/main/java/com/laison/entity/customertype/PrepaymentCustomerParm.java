package com.laison.entity.customertype;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import com.laison.common.validategroup.AddGroup;

public class PrepaymentCustomerParm {
	/**
	 * 用户类型代码
	 */
    private Long customerTypeCode;
    /**
     * 月使用限量开关 0-关,1-开 默认关
     */
    private Boolean monthLimitFlag;
    /**
     * 每月最大使用量 默认99999999
     */
    private Integer monthMaxConsumeLimit;
    /**
     * 水表余额小于这个值时告警 默认5.00
     */
    private BigDecimal alarmValue;
    /**
     * 每月最大购买  默认9999999.00
     */
    private BigDecimal purchaseMax;
    /**
     * 每月最大透支    默认9999999.00
     */
    private BigDecimal overdraftMax;
    /**
     * 蜂鸣器告警开关 0-关,1-开 默认关
     */
    private Boolean buzzerAlarmFlag;
    /**
     * 告警时关阀功能开关 默认关
     */
    private Boolean alarmCloseValveFlag;
    /**
     * 节假日方案代码  根据配置文件里 enable.holiday的值 如果是1则 这个参数不能为空
     */
    private Long friendlyPeriodSchemeCode;

    public Long getCustomerTypeCode() {
        return customerTypeCode;
    }

    public void setCustomerTypeCode(Long customerTypeCode) {
        this.customerTypeCode = customerTypeCode;
    }
    @NotNull(groups = { AddGroup.class}, message = "{prepayment.customer.parm.monthLimitflag.null}")
    public Boolean getMonthLimitFlag() {
        return monthLimitFlag;
    }

    public void setMonthLimitFlag(Boolean monthLimitFlag) {
        this.monthLimitFlag = monthLimitFlag;
    }

    public Integer getMonthMaxConsumeLimit() {
        return monthMaxConsumeLimit;
    }

    public void setMonthMaxConsumeLimit(Integer monthMaxConsumeLimit) {
        this.monthMaxConsumeLimit = monthMaxConsumeLimit;
    }

    public BigDecimal getAlarmValue() {
        return alarmValue;
    }

    public void setAlarmValue(BigDecimal alarmValue) {
        this.alarmValue = alarmValue;
    }

    public BigDecimal getPurchaseMax() {
        return purchaseMax;
    }

    public void setPurchaseMax(BigDecimal purchaseMax) {
        this.purchaseMax = purchaseMax;
    }

    public BigDecimal getOverdraftMax() {
        return overdraftMax;
    }

    public void setOverdraftMax(BigDecimal overdraftMax) {
        this.overdraftMax = overdraftMax;
    }

    public Boolean getBuzzerAlarmFlag() {
        return buzzerAlarmFlag;
    }

    public void setBuzzerAlarmFlag(Boolean buzzerAlarmFlag) {
        this.buzzerAlarmFlag = buzzerAlarmFlag;
    }

    public Boolean getAlarmCloseValveFlag() {
        return alarmCloseValveFlag;
    }

    public void setAlarmCloseValveFlag(Boolean alarmCloseValveFlag) {
        this.alarmCloseValveFlag = alarmCloseValveFlag;
    }

    public Long getFriendlyPeriodSchemeCode() {
        return friendlyPeriodSchemeCode;
    }

    public void setFriendlyPeriodSchemeCode(Long friendlyPeriodSchemeCode) {
        this.friendlyPeriodSchemeCode = friendlyPeriodSchemeCode;
    }
}