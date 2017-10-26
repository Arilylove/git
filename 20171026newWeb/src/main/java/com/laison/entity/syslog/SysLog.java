package com.laison.entity.syslog;

import java.util.Date;

public class SysLog {
	/**
	 * 系统日志id 主键
	 */
    private Long id;

    /**
	 * 用户名
	 */
    private String user;

    /**
	 * 用户操作
	 */
    private String operationType;
    /**
	 * 请求方法
	 */
    private String method;
    /**
	 * 更新后的值
	 */
    private String newValue;
    /**
	 * 更新前的值
	 */
    private String oldValue;
    /**
	 * 用户IP地址
	 */
    private String ip;
    /**
	 * 创建时间
	 */
    private Date createDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user == null ? null : user.trim();
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType == null ? null : operationType.trim();
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method == null ? null : method.trim();
    }

    public String getNewValue() {
        return newValue;
    }

    public void setNewValue(String newValue) {
        this.newValue = newValue == null ? null : newValue.trim();
    }

    public String getOldValue() {
        return oldValue;
    }

    public void setOldValue(String oldValue) {
        this.oldValue = oldValue == null ? null : oldValue.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}