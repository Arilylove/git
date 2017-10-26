package com.laison.mapper.meterinfo.detail;

import com.laison.entity.meterinfo.detail.MeterInfoDetail;
import com.laison.entity.meterinfo.detail.MeterInfoDetailExample;
import com.laison.entity.meterinfo.detail.MeterInfoDetailKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MeterInfoDetailMapper {
    int countByExample(MeterInfoDetailExample example);

    int deleteByExample(MeterInfoDetailExample example);

    int deleteByPrimaryKey(MeterInfoDetailKey key);

    int insert(MeterInfoDetail record);

    int insertSelective(MeterInfoDetail record);

    List<MeterInfoDetail> selectByExample(MeterInfoDetailExample example);

    MeterInfoDetail selectByPrimaryKey(MeterInfoDetailKey key);

    int updateByExampleSelective(@Param("record") MeterInfoDetail record, @Param("example") MeterInfoDetailExample example);

    int updateByExample(@Param("record") MeterInfoDetail record, @Param("example") MeterInfoDetailExample example);

    int updateByPrimaryKeySelective(MeterInfoDetail record);

    int updateByPrimaryKey(MeterInfoDetail record);
}