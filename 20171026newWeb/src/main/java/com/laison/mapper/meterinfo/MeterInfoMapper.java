package com.laison.mapper.meterinfo;

import com.laison.entity.meterinfo.MeterInfo;
import com.laison.entity.meterinfo.MeterInfoExample;
import com.laison.entity.meterinfo.MeterInfoKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MeterInfoMapper {
    int countByExample(MeterInfoExample example);

    int deleteByExample(MeterInfoExample example);

    int deleteByPrimaryKey(MeterInfoKey key);

    int insert(MeterInfo record);

    int insertSelective(MeterInfo record);

    List<MeterInfo> selectByExample(MeterInfoExample example);

    MeterInfo selectByPrimaryKey(Long key);

    int updateByExampleSelective(@Param("record") MeterInfo record, @Param("example") MeterInfoExample example);

    int updateByExample(@Param("record") MeterInfo record, @Param("example") MeterInfoExample example);

    int updateByPrimaryKeySelective(MeterInfo record);

    int updateByPrimaryKey(MeterInfo record);
}