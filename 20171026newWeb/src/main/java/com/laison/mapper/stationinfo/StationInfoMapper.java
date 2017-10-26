package com.laison.mapper.stationinfo;

import com.laison.entity.stationinfo.StationInfo;
import com.laison.entity.stationinfo.StationInfoExample;
import com.laison.entity.stationinfo.StationInfoKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StationInfoMapper {
    int countByExample(StationInfoExample example);

    int deleteByExample(StationInfoExample example);

    int deleteByPrimaryKey(StationInfoKey key);

    int insert(StationInfo record);

    int insertSelective(StationInfo record);

    List<StationInfo> selectByExample(StationInfoExample example);

    StationInfo selectByPrimaryKey(StationInfoKey key);

    int updateByExampleSelective(@Param("record") StationInfo record, @Param("example") StationInfoExample example);

    int updateByExample(@Param("record") StationInfo record, @Param("example") StationInfoExample example);

    int updateByPrimaryKeySelective(StationInfo record);

    int updateByPrimaryKey(StationInfo record);
}