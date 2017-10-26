package com.laison.entity.stationinfo;

import java.util.Date;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.laison.common.validategroup.AddGroup;
import com.laison.common.validategroup.UpdateGroup;

public class StationInfo extends StationInfoKey {
	/**
	 * 站点名称（营业厅信息表）
	 */
	 @Size(groups={AddGroup.class},min =1,max = 32,message="{station.name.size}")
	 @NotBlank(groups={AddGroup.class},message="{station.name.null}")
    private String stationName;
	 /**
	  * 站点地址
	  */
	 @NotBlank(groups={AddGroup.class},message="{station.address.null}")
    private String stationAddress;

	 /**
	  * 创建日期
	  */
    private Date createDate;
    /**
     * 状态  0-尚未启用;1-正常
     */
    @Pattern(groups={AddGroup.class,UpdateGroup.class},regexp="[0|1]",message="{state.pattern}")
    private String state;

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName == null ? null : stationName.trim();
    }

    public String getStationAddress() {
        return stationAddress;
    }

    public void setStationAddress(String stationAddress) {
        this.stationAddress = stationAddress == null ? null : stationAddress.trim();
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