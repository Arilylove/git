package com.laison.mapper.regioninfo;

import com.laison.entity.regioninfo.RegionInfo;
import com.laison.entity.regioninfo.RegionInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RegionInfoMapper {
    int countByExample(RegionInfoExample example);

    int deleteByExample(RegionInfoExample example);

    int deleteByPrimaryKey(Long regionCode);

    int insert(RegionInfo record);

    int insertSelective(RegionInfo record);

    List<RegionInfo> selectByExample(RegionInfoExample example);

    RegionInfo selectByPrimaryKey(Long regionCode);

    int updateByExampleSelective(@Param("record") RegionInfo record, @Param("example") RegionInfoExample example);

    int updateByExample(@Param("record") RegionInfo record, @Param("example") RegionInfoExample example);

    int updateByPrimaryKeySelective(RegionInfo record);

    int updateByPrimaryKey(RegionInfo record);
    String getRegionPaths(Long regionId);
    Integer getRegionType(Long regionId);
}