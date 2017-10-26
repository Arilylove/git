package com.laison.entity.metertype;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import com.laison.common.validategroup.AddGroup;
import com.laison.common.validategroup.FindGroup;
import com.laison.common.validategroup.UpdateGroup;

public class MeterType {
	@NotNull(groups = { UpdateGroup.class, FindGroup.class }, message = "{metertype.code.null}")
	private Long meterTypeCode;
	@NotBlank(groups = { AddGroup.class }, message = "{metertype.name.null}")
	private String meterTypeName;
	/**
	 * 计量方式 0-计量体积;1-计量金额
	 */
	
	@Range(groups = { AddGroup.class},min=0,max=1, message = "{measuremode.miss}")
	private Integer measureMode;
	/**
	 * 脉冲精度 Laison STS 表计规定 0=0.001,1=0.01,2= 0.1,3= 1,4=10,5= 100'
	 */
	@NotNull(groups = { AddGroup.class}, message = "{pulse.decimal.places.null}")
	@Range(groups = { AddGroup.class},min=0,max=5, message = "{decimal.places.miss}")
	private Integer pulseDecimalPlaces;
	/**
	 * 价格精度 Laison STS 表计规定 0=0.001,1=0.01,2= 0.1,3= 1,4=10,5= 100
	 */
	@NotNull(groups = { AddGroup.class}, message = "{price.dcimal.places.null}")
	@Range(groups = { AddGroup.class},min=0,max=5, message = "{decimal.places.miss}")
	private Integer priceDecimalPlaces;
	/**
	 * 计量精度，计量多少立方米执行一次扣费   Laison STS 表计规定 0=0.001,1=0.01,2= 0.1,3= 1,4=10,5= 100
	 */
	@NotNull(groups = { AddGroup.class}, message = "{measure.decimal.places.null}")
	@Range(groups = { AddGroup.class},min=0,max=5, message = "{decimal.places.miss}")
	private Integer measureDecimalPlaces;
	/**
	 * q3：表记的一个标准名称  如果没给默认值2.5
	 */
	private BigDecimal q3=new BigDecimal(2.5);
	/**
	 * 介质类型   STS协议规定：0-电、1-水、2-气
	 */
	@NotNull(groups = { AddGroup.class}, message = "{measure.decimal.places.null}")
	@Range(groups = { AddGroup.class},min=0,max=2, message = "{mediumtype.miss.null}")
	private Integer mediumType;
	/**
	 * 通信方式及加密类型   V2 = 2, V3 = 3, V4 =4, V5 = 5,
	 * 硬加密STS = 100, 
	 * 硬加密STS_Lora = 101, 
	 * 硬加密STSCard_Lora =121,
	 * 硬加密STS_NBIot = 130,
	 * 软加密STS = 200,
	 * 软加密STS_AMI =201,
	 * 软加密STS_STSCard=220,
	 * 软加密STS_STSCard_AMI =221, 
	 * 软加密STS_NBIot = 230
	 */
	@NotNull(groups = { AddGroup.class}, message = "{communication.type.null}")
	private Integer communicationType;
	
	/**
	 * 液晶屏类型  0-段式液晶 1-点阵式液晶
	 */
	@Range(groups = { AddGroup.class},min=0,max=1, message = "{lcdtype.miss}")
	@NotNull(groups = { AddGroup.class}, message = "{lcdtype.null}")
	private Integer lcdType;
	/**
	 * 货币符号  0-NIS,1-$ 仅段式液晶表计并且按金额尽量方式 才有效 校验要放在程序里面
	 */
	private Integer currencySymbol;

	/**
	 * 是否显示 符号K 默认false
	 */
	private Boolean kFlag=false;
	/**
	 * 是否支持逆流检测 默认false
	 */
	private Boolean currentDetectionFlag=false;

	private Date createDate;

	private String state="1";

	public Long getMeterTypeCode() {
		return meterTypeCode;
	}

	public void setMeterTypeCode(Long meterTypeCode) {
		this.meterTypeCode = meterTypeCode;
	}

	public String getMeterTypeName() {
		return meterTypeName;
	}

	public void setMeterTypeName(String meterTypeName) {
		this.meterTypeName = meterTypeName == null ? null : meterTypeName.trim();
	}

	public Integer getMeasureMode() {
		return measureMode;
	}

	public void setMeasureMode(Integer measureMode) {
		this.measureMode = measureMode;
	}

	public Integer getPulseDecimalPlaces() {
		return pulseDecimalPlaces;
	}

	public void setPulseDecimalPlaces(Integer pulseDecimalPlaces) {
		this.pulseDecimalPlaces = pulseDecimalPlaces;
	}

	public Integer getPriceDecimalPlaces() {
		return priceDecimalPlaces;
	}

	public void setPriceDecimalPlaces(Integer priceDecimalPlaces) {
		this.priceDecimalPlaces = priceDecimalPlaces;
	}

	public Integer getMeasureDecimalPlaces() {
		return measureDecimalPlaces;
	}

	public void setMeasureDecimalPlaces(Integer measureDecimalPlaces) {
		this.measureDecimalPlaces = measureDecimalPlaces;
	}

	public BigDecimal getQ3() {
		return q3;
	}

	public void setQ3(BigDecimal q3) {
		this.q3 = q3;
	}

	public Integer getMediumType() {
		return mediumType;
	}

	public void setMediumType(Integer mediumType) {
		this.mediumType = mediumType;
	}

	public Integer getCommunicationType() {
		return communicationType;
	}

	public void setCommunicationType(Integer communicationType) {
		this.communicationType = communicationType;
	}

	public Integer getLcdType() {
		return lcdType;
	}

	public void setLcdType(Integer lcdType) {
		this.lcdType = lcdType;
	}

	public Integer getCurrencySymbol() {
		return currencySymbol;
	}

	public void setCurrencySymbol(Integer currencySymbol) {
		this.currencySymbol = currencySymbol;
	}

	public Boolean getkFlag() {
		return kFlag;
	}

	public void setkFlag(Boolean kFlag) {
		this.kFlag = kFlag;
	}

	public Boolean getCurrentDetectionFlag() {
		return currentDetectionFlag;
	}

	public void setCurrentDetectionFlag(Boolean currentDetectionFlag) {
		this.currentDetectionFlag = currentDetectionFlag;
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