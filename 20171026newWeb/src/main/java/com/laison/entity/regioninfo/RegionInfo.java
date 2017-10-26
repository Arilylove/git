package com.laison.entity.regioninfo;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.laison.common.validategroup.AddGroup;
import com.laison.common.validategroup.FindGroup;
import com.laison.common.validategroup.UpdateGroup;


public class RegionInfo {
	/**
	 * 主键
	 * 行政区域编码
	 */
	@NotNull(groups={UpdateGroup.class,FindGroup.class},message="{regionCode.null}")
    private Long regionCode;
	/**
	 * 父节点id
	 */
    private Long parentRegionId=0l;

    /**
     * 路径
     */
    private String paths="0,";
    /**
     * 区域名称
     */
    @NotBlank(groups={AddGroup.class},message="{region.name.null}")
    private String regionName;

    /**
     * 区域类型
     */
    private Integer regionType;
    /**
     * 
     */
    private List<RegionInfo> childRegions=new ArrayList<RegionInfo>();
    public Long getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(Long regionCode) {
        this.regionCode = regionCode;
    }

    public Long getParentRegionId() {
        return parentRegionId;
    }

    public void setParentRegionId(Long parentRegionId) {
        this.parentRegionId = parentRegionId;
    }

    public String getPaths() {
        return paths;
    }

    public void setPaths(String paths) {
        this.paths = paths == null ? null : paths.trim();
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName == null ? null : regionName.trim();
    }

    public Integer getRegionType() {
        return regionType;
    }

    public void setRegionType(Integer regionType) {
        this.regionType = regionType;
    }

	public List<RegionInfo> getChildRegions() {
		return childRegions;
	}

	public void setChildRegions(List<RegionInfo> childRegions) {
		this.childRegions = childRegions;
	}
    
    
}