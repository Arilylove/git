package com.laison.entity.scheme.friendlyperiod;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import com.laison.common.utils.DateUtils;
import com.laison.common.validategroup.AddGroup;
import com.laison.common.validategroup.FindGroup;
import com.laison.common.validategroup.UpdateGroup;

public class FriendlyPeriodScheme {
	
	/**
	 * 主键
	 */
	@Range(groups = { AddGroup.class},min=0,max=1000000, message = "{friendly.period.scheme.code.miss}")
	@NotNull(groups = { UpdateGroup.class, FindGroup.class }, message = "{friendly.period.scheme.code.null}")
    private Long friendlyPeriodSchemeCode;

    /**
     * 友好时段方案名字
     */
    @NotBlank(groups = { AddGroup.class }, message = "{friendly.period.name.null}")
    private String friendlyPeriodSchemeName;

    /**
     * 友好时段使用次数0-255次 默认3次
     */
    @Range(groups = { AddGroup.class,UpdateGroup.class},min=0,max=255, message = "{friendly.period.use.count.miss}")
    private Integer friendlyPeriodUseCount;

    /**
     * 启用下班时间功能 0-禁用；1-启用 默认0-禁用
     */
    private Boolean enableOffdutyTimeFlag;
    /**
     * 启用周末功能  0-禁用；1-启用 默认0-禁用
     */
    private Boolean enableWeekendFlag;
    /**
     * 启用节假日功能  0-禁用；1-启用 默认0-禁用
     */
    private Boolean enableHolidayFlag=false;
    
    /**
     * 仅当启用节假日功能时(enableHolidayFlag=true)有效  默认0
     */
    private Long holidaySchemeCode;
    /**
     * 下班时间起始  默认17:30
     */
    private String offdutyTimeStart;
    /**
     * 下班时间结束 默认08:30
     */
    private String offdutyTimeEnd;

    /**
     * 哪几天是周末 从左到右分别代表周一到周日。如果是1则代表这一天是周末 默认 0000011-周六和周日
     */
    private String weekendDayString;

    
    /**
     * 创建时当地当前时间
     */
    private Date createDate=DateUtils.utcDate();
    
    /**
     * 状态 默认1 启用
     */
    private String state;
    
    /**
     * 
    * @Title: getFriendlyPeriodSchemeCode 
    * @Description:获取友好时段方案主键
    * @param @return   
    * @return Long
     */
    public Long getFriendlyPeriodSchemeCode() {
        return friendlyPeriodSchemeCode;
    }

    public void setFriendlyPeriodSchemeCode(Long friendlyPeriodSchemeCode) {
        this.friendlyPeriodSchemeCode = friendlyPeriodSchemeCode;
    }

    public String getFriendlyPeriodSchemeName() {
        return friendlyPeriodSchemeName;
    }

    public void setFriendlyPeriodSchemeName(String friendlyPeriodSchemeName) {
        this.friendlyPeriodSchemeName = friendlyPeriodSchemeName == null ? null : friendlyPeriodSchemeName.trim();
    }

    public Integer getFriendlyPeriodUseCount() {
        return friendlyPeriodUseCount;
    }

    public void setFriendlyPeriodUseCount(Integer friendlyPeriodUseCount) {
        this.friendlyPeriodUseCount = friendlyPeriodUseCount;
    }

    public Boolean getEnableOffdutyTimeFlag() {
        return enableOffdutyTimeFlag;
    }

    public void setEnableOffdutyTimeFlag(Boolean enableOffdutyTimeFlag) {
        this.enableOffdutyTimeFlag = enableOffdutyTimeFlag;
    }

    public Boolean getEnableWeekendFlag() {
        return enableWeekendFlag;
    }

    public void setEnableWeekendFlag(Boolean enableWeekendFlag) {
        this.enableWeekendFlag = enableWeekendFlag;
    }

    public Boolean getEnableHolidayFlag() {
        return enableHolidayFlag;
    }

    public void setEnableHolidayFlag(Boolean enableHolidayFlag) {
        this.enableHolidayFlag = enableHolidayFlag;
    }

    public String getOffdutyTimeStart() {
        return offdutyTimeStart;
    }

    public void setOffdutyTimeStart(String offdutyTimeStart) {
        this.offdutyTimeStart = offdutyTimeStart == null ? null : offdutyTimeStart.trim();
    }

    public String getOffdutyTimeEnd() {
        return offdutyTimeEnd;
    }

    public void setOffdutyTimeEnd(String offdutyTimeEnd) {
        this.offdutyTimeEnd = offdutyTimeEnd == null ? null : offdutyTimeEnd.trim();
    }

    public String getWeekendDayString() {
        return weekendDayString;
    }

    public void setWeekendDayString(String weekendDayString) {
        this.weekendDayString = weekendDayString == null ? null : weekendDayString.trim();
    }

    public Long getHolidaySchemeCode() {
        return holidaySchemeCode;
    }

    public void setHolidaySchemeCode(Long holidaySchemeCode) {
        this.holidaySchemeCode = holidaySchemeCode;
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