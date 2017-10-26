package com.laison.entity;

public class SysRoleMenu {
	/**
	 * 主键
	 */
    private String id;

    /**
	 * 角色id  关联角色
	 */
    private String roleId;
    /**
	 * 菜单id  关联菜单
	 */
    private String menuId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId == null ? null : menuId.trim();
    }
}