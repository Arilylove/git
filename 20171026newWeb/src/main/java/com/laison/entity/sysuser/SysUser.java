package com.laison.entity.sysuser;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import com.laison.common.annotation.ID;
import com.laison.common.utils.DateUtils;
import com.laison.common.validategroup.AddGroup;
import com.laison.common.validategroup.AddOperatorGroup;
import com.laison.common.validategroup.FindGroup;
import com.laison.common.validategroup.UpdateGroup;
import com.laison.entity.sysmenu.SysMenu;
import com.laison.entity.sysrole.SysRole;

public class SysUser implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 如果系统配置允许自动生成 id由计算产生 否则由用户填写生成
	 */
	@NotNull(groups = { UpdateGroup.class, FindGroup.class }, message = "{user.id.null}")
	@ID
	private Long id;
	@Size(groups = { AddGroup.class, UpdateGroup.class }, min = 5, max = 20, message = "{username.size}")
	@Pattern(groups = { AddGroup.class, UpdateGroup.class }, regexp = "[_a-zA-Z0-9]+", message = "{username.pattern}")
	private String loginName;
	@Size(groups = { AddGroup.class, UpdateGroup.class }, min = 5, max = 20, message = "{password.size}")
	@Pattern(groups = { AddGroup.class,
			UpdateGroup.class }, regexp = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{5,20}$", message = "{password.pattern}")
	private String password;
	/**
	 * 工号
	 */
	private String jobNo;
	/**
	 * 花名昵称
	 */
	
	private String nickName;
	/**
	 * 邮箱email
	 */
	@Email(groups = { AddGroup.class, UpdateGroup.class }, message = "{email.pattern}")
	private String email;
	/**
	 * 电话
	 */
	private String phone;
	/**
	 * 手机
	 */
	@Pattern(groups = { AddGroup.class, UpdateGroup.class }, message = "{mobile.pattern}", regexp = "^[1][0-9]{10}$")
	private String mobile;
	/**
	 * 公司code
	 */
	private Long companyCode;
	/**
	 * 站点id
	 */
	private Long stationCode;
	/**
	 * 站点名字
	 */
	private String stationName;
	
	/**
	 * 用户类型 和role的类型绑定 1是admin 2是operator
	 */
	private Integer userType;
	/**
	 * 用户头像url
	 */
	private String photo;
	/**
	 * 创建者
	 */
	private Long createBy;

	/**
	 * 创建日期
	 */
	private Date createDate = DateUtils.utcDate();
	/**
	 * 备注
	 */

	private String remarks;
	/**
	 * 用户状态 0停用 1启用 2是系统用户 不可编辑
	 */
	@Range(groups = { AddGroup.class,UpdateGroup.class }, min=0,max=2, message = "{param.pattern}")
	private Integer state;
	/**
	 * 用户信用额度
	 */
	private BigDecimal creditLimit;
	/**
	 * 用户的角色 只有一个更改的时候先删除原来的角色
	 */
	private SysRole role;
	private String roleName;
	/**
	 * 用户所有的菜单
	 */
	List<SysMenu> menus;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(Long companyCode) {
		this.companyCode = companyCode;
	}

	public Long getStationCode() {
		return stationCode;
	}

	public void setStationCode(Long stationCode) {
		this.stationCode = stationCode;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName == null ? null : loginName.trim();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	public String getJobNo() {
		return jobNo;
	}

	public void setJobNo(String jobNo) {
		this.jobNo = jobNo == null ? null : jobNo.trim();
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName == null ? null : nickName.trim();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email == null ? null : email.trim();
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone == null ? null : phone.trim();
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile == null ? null : mobile.trim();
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo == null ? null : photo.trim();
	}

	public Long getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}

	public Date getCreateDate() {
		return createDate;
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

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public BigDecimal getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(BigDecimal creditLimit) {
		this.creditLimit = creditLimit;
	}

	public SysRole getRole() {
		return role;
	}

	public void setRole(SysRole role) {
		this.role = role;
	}

	public List<SysMenu> getMenus() {
		return menus;
	}

	public void setMenus(List<SysMenu> menus) {
		this.menus = menus;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}