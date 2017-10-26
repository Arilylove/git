package com.laison.entity.scheme.additionalfee.detail;

import java.math.BigDecimal;
import java.util.Date;


import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import com.laison.common.utils.DateUtils;
import com.laison.common.utils.R;
import com.laison.common.validategroup.AddGroup;
import com.laison.common.validategroup.UpdateGroup;

public class AdditionalFeeDetail extends AdditionalFeeDetailKey {
	
	/**
	 * 附加费名称dd
	 */
	@NotBlank(groups = { AddGroup.class }, message = "{additional.fee.name.null}")
    private String additionalFeeName;
   /**
    * 0-普通扣费,1-还债,还债类型的附加费,用户债务为0时，不再扣除本项目 
    */
	@Range(groups = { AddGroup.class,UpdateGroup.class}, min = 0, max = 1, message = "{additional.fee.type.range.error}")
	@NotNull(groups = { AddGroup.class,UpdateGroup.class }, message = "{additional.fee.type.null}")
    private Integer additionalFeeType;
    /**
     * 扣费方式 0-按百分比,1-按次数扣费（每次扣除固定金额，次数递减到0时不再扣除）,
     * 2-按天扣费,3-按月扣费,4-按年1扣费,5-固定金额扣费（每次都扣除）,6-按上月使用量扣费
     */
	@Range(groups = { AddGroup.class,UpdateGroup.class}, min = 0, max = 6, message = "{additional.fee.deduction.mode.range.error}")
	@NotNull(groups = { AddGroup.class,UpdateGroup.class }, message = "{additional.fee.deduction.mode.null}")
    private Integer additionalFeeDeductionMode;
    /**
     * 按百分比扣费时的百分比
     */
	@Range(groups = { AddGroup.class,UpdateGroup.class}, min = 0, max = 100, message = "{rate.range.error}")
    private BigDecimal additionalFeeDeductionRate;
    /**
     * 仅当扣费方式为按次数扣费时有效.递减到0后不再扣除本项目
     */
	@Range(groups = { AddGroup.class,UpdateGroup.class}, min = 0, message = "{times.range.error}")
    private Integer additionalFeeDeductionTimes;
    /**
     * 按次数、天、月、年、固定金额扣费时，每次的扣除金额
     */
	@Range(groups = { AddGroup.class,UpdateGroup.class}, min = 0, message = "{less.than.zero}")
    private BigDecimal additionalFeeDeductionAmount;
    /**
     * 按量扣费时的单价 仅当扣费方式为按上月使用量扣费时有效.扣费金额=月使用量*单价
     */
	@Range(groups = { AddGroup.class,UpdateGroup.class}, min = 0, message = "{less.than.zero}")
    private BigDecimal additionalFeeDeductionUnitPrice;
    /**
     * 附加费税率 仅当系统VATMode=0时使用 取值范围0-100
     */
	@Range(groups = { AddGroup.class,UpdateGroup.class}, min = 0, max=100, message = "{vat.range.error}")
    private BigDecimal additionalFeeVat;
    /**
     * 开始扣费日期 从该日期开始计算费用
     */	
    private Date additionalFeeStartDate=DateUtils.defaultDate();

    public String getAdditionalFeeName() {
        return additionalFeeName;
    }

    public void setAdditionalFeeName(String additionalFeeName) {
        this.additionalFeeName = additionalFeeName == null ? null : additionalFeeName.trim();
    }

    public Integer getAdditionalFeeType() {
        return additionalFeeType;
    }

    public void setAdditionalFeeType(Integer additionalFeeType) {
        this.additionalFeeType = additionalFeeType;
    }

    /**
     * 
     * @Title: getAdditionalFeeDeductionMode 
     * @Description: 
     * 扣费方式 0-按百分比,1-按次数扣费（每次扣除固定金额，次数递减到0时不再扣除）,2-按天扣费,3-按月扣费,4-按年扣费,5-固定金额扣费（每次都扣除）,6-按上月使用量扣费
     * @return Integer
     */
    public Integer getAdditionalFeeDeductionMode() {
        return additionalFeeDeductionMode;
    }

    public void setAdditionalFeeDeductionMode(Integer additionalFeeDeductionMode) {
        this.additionalFeeDeductionMode = additionalFeeDeductionMode;

    }

    /**
     * 
    * @Title: getAdditionalFeeDeductionRate 
    * @Description: 获取按百分比扣费时的百分比
    * @param @return   
    * @return BigDecimal
     */
    public BigDecimal getAdditionalFeeDeductionRate() {
        return additionalFeeDeductionRate;
    }

    public void setAdditionalFeeDeductionRate(BigDecimal additionalFeeDeductionRate) {
        this.additionalFeeDeductionRate = additionalFeeDeductionRate;
    }

    public Integer getAdditionalFeeDeductionTimes() {
        return additionalFeeDeductionTimes;
    }

    public void setAdditionalFeeDeductionTimes(Integer additionalFeeDeductionTimes) {
        this.additionalFeeDeductionTimes = additionalFeeDeductionTimes;
    }
    /**
     * 按次数、天、月、年、固定金额扣费时，每次的扣除金额
     */
    public BigDecimal getAdditionalFeeDeductionAmount() {
        return additionalFeeDeductionAmount;
    }

    public void setAdditionalFeeDeductionAmount(BigDecimal additionalFeeDeductionAmount) {
        this.additionalFeeDeductionAmount = additionalFeeDeductionAmount;
    }

    public BigDecimal getAdditionalFeeDeductionUnitPrice() {
        return additionalFeeDeductionUnitPrice;
    }

    public void setAdditionalFeeDeductionUnitPrice(BigDecimal additionalFeeDeductionUnitPrice) {
        this.additionalFeeDeductionUnitPrice = additionalFeeDeductionUnitPrice;
    }

    public BigDecimal getAdditionalFeeVat() {
        return additionalFeeVat;
    }

    public void setAdditionalFeeVat(BigDecimal additionalFeeVat) {
        this.additionalFeeVat = additionalFeeVat;
    }

    public Date getAdditionalFeeStartDate() {
        return additionalFeeStartDate;
    }

    public void setAdditionalFeeStartDate(Date additionalFeeStartDate) {
        this.additionalFeeStartDate = additionalFeeStartDate;
    }
    
    /**
     * 
     * @Title: setPropToNull 
     * @Description:按着传进了的付费方式 清空不必要的字段  
     * @param additionalFeeDeductionMode void
     */
    public void setPropToNull (Integer additionalFeeDeductionMode) {
    	switch(additionalFeeDeductionMode) {
		case 0: //按百分比扣费
			this.additionalFeeDeductionAmount=new BigDecimal(0.00);
			this.additionalFeeDeductionTimes=0;
			this.additionalFeeDeductionUnitPrice=new BigDecimal(0.00);
			break;
		case 1:  //按次数扣费	
			this.additionalFeeDeductionRate=new BigDecimal(0.00);
			this.additionalFeeDeductionUnitPrice=new BigDecimal(0.00);
			
			break;
		case 2:  //按天扣费
			this.additionalFeeDeductionTimes=0;
			this.additionalFeeDeductionUnitPrice=new BigDecimal(0.00);
			this.additionalFeeDeductionRate=new BigDecimal(0.00);
			break;				
		case 3:  //按月扣费
			this.additionalFeeDeductionTimes=0;
			this.additionalFeeDeductionUnitPrice=new BigDecimal(0.00);
			this.additionalFeeDeductionRate=new BigDecimal(0.00);
			break;
		case 4:  //按年扣费
			this.additionalFeeDeductionTimes=0;
			this.additionalFeeDeductionUnitPrice=new BigDecimal(0.00);
			this.additionalFeeDeductionRate=new BigDecimal(0.00);
			break;
		case 5:  //按固定金额扣费（每次都扣除）
			this.additionalFeeDeductionTimes=0;
			this.additionalFeeDeductionUnitPrice=new BigDecimal(0.00);
			this.additionalFeeDeductionRate=new BigDecimal(0.00);
			break;
		case 6:  //按上月使用量扣费
			this.additionalFeeDeductionTimes=0;
			this.additionalFeeDeductionAmount=new BigDecimal(0.00);
			this.additionalFeeDeductionRate=new BigDecimal(0.00);
			break;
		default:
				break;
							
	}
    }
}