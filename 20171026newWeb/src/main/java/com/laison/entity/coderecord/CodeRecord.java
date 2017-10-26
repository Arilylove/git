package com.laison.entity.coderecord;

import java.io.Serializable;

public class CodeRecord implements Serializable{
	
	/**
	 * 系统默认的序列版本id（没有具体用处--去除黄线警告）
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 主键uuid
	 */
    private String id;
    /**
     * code的前缀  前6位是年份月份，7-8位是系统编号，9-10位是code类型
     */
    private Integer codePrefix;
    /**
     * 当前记录值
     */
    private Integer currentNo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getCodePrefix() {
        return codePrefix;
    }

    public void setCodePrefix(Integer codePrefix) {
        this.codePrefix = codePrefix;
    }

    public Integer getCurrentNo() {
        return currentNo;
    }

    public void setCurrentNo(Integer currentNo) {
        this.currentNo = currentNo;
    }
}