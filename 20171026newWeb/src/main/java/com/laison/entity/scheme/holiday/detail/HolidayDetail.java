package com.laison.entity.scheme.holiday.detail;

import javax.validation.constraints.Pattern;

import com.laison.common.utils.StringUtils;
import com.laison.common.validategroup.AddGroup;
import com.laison.common.validategroup.UpdateGroup;

public class HolidayDetail extends HolidayDetailKey {
	/**
	 * 0-15，循环使用.每次保存时对此递增 第一次位0
	 */
    private Integer holidayVersion;

    /**
     * 96个字符表示48字节的HexString,每个bit对应1天是否为节假日.1是0否
     *  默认  '000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000'
     *  全部不是节假日
     *  
     *  前端传过来可能是384位的01字符串 ，需要转成96位
     */
    @Pattern(groups={AddGroup.class,UpdateGroup.class},regexp="^[0-9a-fA-F]{96}$",message="{holiday.hexString.pattern}")
    private String holidayHexString;

    public Integer getHolidayVersion() {
        return holidayVersion;
    }

    public void setHolidayVersion(Integer holidayVersion) {
        this.holidayVersion = holidayVersion;
    }
    
    
    public String getHolidayHexString() {
       // return StringUtils.hexStringTobinaryString(this.holidayHexString);
        return this.holidayHexString;
    }

    /**
     * 
    * @Title: setHolidayHexString 
    * @Description:  将前端传过来的二进制字符串转成十六进制字符串
    * @param @param holidayHexString   
    * @return void
     */
    public void setHolidayHexString(String holidayHexString) {
    	
    	if(StringUtils.isHexString(holidayHexString, 96)) {
    		this.holidayHexString = StringUtils.hexStringTobinaryString(holidayHexString);
    	}else if(StringUtils.isBinaryString(holidayHexString, 384)) {
    		this.holidayHexString = StringUtils.binaryStringToHexString(holidayHexString);
    	}
    }
}