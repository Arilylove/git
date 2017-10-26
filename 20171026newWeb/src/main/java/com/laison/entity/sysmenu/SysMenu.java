package com.laison.entity.sysmenu;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import com.laison.common.validategroup.AddGroup;
import com.laison.common.validategroup.FindGroup;
import com.laison.common.validategroup.UpdateGroup;


public class SysMenu implements Serializable{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 主键
	 */
	@NotNull(groups={UpdateGroup.class,FindGroup.class},message="{menu.id.null}")
    private String id;
	/**
	 * 上级节点的id
	 */
    @NotNull(groups={AddGroup.class,UpdateGroup.class},message="{menu.pid.null}")
    private String parentId;
	/**
	 * 父菜单名称
	 */
	private String parentName;
    /**
	 * 路径 
	 * 所有的祖先节点id组成的路径，中间已英文逗号分开
	 */
    private String paths;
    /**
	 * 菜单名称
	 */
    @NotNull(groups={AddGroup.class,UpdateGroup.class},message="{menu.name.null}")
    private String name;
    /**
	 * 对应的URL
	 */
    private String url;
    /**
	 * 菜单对应的后台权限字符串
	 * 注：要和后台方法中的权限字符串一样，不能乱改
	 */
    private String perms;
    /**
     * 0:目录,1:url,2:button
     */
    @NotNull(groups={AddGroup.class},message="{menu.type.null}")
    @Null(groups={UpdateGroup.class},message="{menu.type.noneed}")//null检测Hibernate未实现
    private Integer type;
    /**
	 * 图标
	 */
    private String icon;
    /**
	 * 排序数值
	 */
    private Integer orderNum;
    /**
	 * 
	 */
    private String state="1";
    /**
	 * 
	 */
    private List<SysMenu> childMenus=new ArrayList<SysMenu>();
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    public String getPaths() {
        return paths;
    }

    public void setPaths(String paths) {
        this.paths = paths == null ? null : paths.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getPerms() {
        return perms;
    }

    public void setPerms(String perms) {
        this.perms = perms == null ? null : perms.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

	public List<SysMenu> getChildMenus() {
		return childMenus;
	}

	public void setChildMenus(List<SysMenu> childMenus) {
		this.childMenus = childMenus;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	
    
}