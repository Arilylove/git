package com.laison.entity.companyinfo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.laison.common.validategroup.AddGroup;
import com.laison.common.validategroup.FindGroup;
import com.laison.common.validategroup.UpdateGroup;
import com.laison.entity.stationinfo.StationInfo;

public class CompanyInfo {
	/**
	 * 公司信息，区域编码
	 */
	@NotNull(groups={UpdateGroup.class,FindGroup.class},message="{companycode.null}")
    private Long companyCode;
	/**
	 * 区域名称
	 */
    @Size(groups={AddGroup.class},min =1,max = 32,message="{company.name.size}")
    @NotBlank(groups={AddGroup.class},message="{company.name.null}")
    private String companyName;
    /**
     * 货币单位
     */
    @NotBlank(groups={AddGroup.class},message="{currencyUnit.null}")
    private String currencyUnit="";
    /**
     * 质量单位
     */
    @NotBlank(groups={AddGroup.class},message="{quantityUnit.null}")
    private String quantityUnit="";

    /**
     * 创建日期
     */
    private Date createDate;

   

    /**
     * 状态，0表示尚未启用，1正常
     */
    @Pattern(groups={AddGroup.class,UpdateGroup.class},regexp="[0|1|2]",message="{state.pattern}")
    private String state="1";

    /**
     * STS表使用的SGC
     * 0-DITK,  1-软加密DDTK,2-软加密DUTK,其他：硬加密DUTK，DDTK
     */
    private Integer stsKeyId;
    /**
     * 同营业厅信息相关联
     */
    private List<StationInfo> stations=new ArrayList<>();
    public Long getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(Long companyCode) {
        this.companyCode = companyCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getCurrencyUnit() {
        return currencyUnit;
    }

    public void setCurrencyUnit(String currencyUnit) {
        this.currencyUnit = currencyUnit == null ? null : currencyUnit.trim();
    }

    public String getQuantityUnit() {
        return quantityUnit;
    }

    public void setQuantityUnit(String quantityUnit) {
        this.quantityUnit = quantityUnit == null ? null : quantityUnit.trim();
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

    public Integer getStsKeyId() {
        return stsKeyId;
    }

    public void setStsKeyId(Integer stsKeyId) {
        this.stsKeyId = stsKeyId;
    }

	public List<StationInfo> getStations() {
		return stations;
	}

	public void setStations(List<StationInfo> stations) {
		this.stations = stations;
	}
    
    
    
}