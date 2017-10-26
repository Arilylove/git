package com.laison.entity.sysrole;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

import com.laison.common.utils.DateUtils;
import com.laison.common.validategroup.AddGroup;
import com.laison.common.validategroup.AddOperatorGroup;
import com.laison.common.validategroup.UpdateGroup;

public class SysRole implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;

	private String name;
	/**
	 * 角色类型(1管理员 2业务员)
	 */
	@Pattern(groups={AddGroup.class,UpdateGroup.class},regexp="^[0-2]$",message="{roletype.pattern}")
	@NotBlank(groups={AddGroup.class},message="{role.type.null}")
	private String roleType;
	 /**
     * 角色状态 1 可用  0不可用
     */
	private String state="1";
	/**
	 * 创建者
	 */
	private Long createBy;
	/**
	 * 创建日期
	 */
	private Date createDate=DateUtils.utcDate();
	/**
	 * 备注
	 */
	private String remarks;
	private List<String> menuIdList;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType == null ? null : roleType.trim();
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state == null ? null : state.trim();
	}

	public Long getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}

	public Date getCreateDate() {
		return createDate==null?DateUtils.utcDate():createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks == null ? null : remarks.trim();
	}

	public List<String> getMenuIdList() {
		return menuIdList;
	}

	public void setMenuIdList(List<String> menuIdList) {
		this.menuIdList = menuIdList;
	}
	
}