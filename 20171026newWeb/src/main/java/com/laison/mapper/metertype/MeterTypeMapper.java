package com.laison.mapper.metertype;

import com.laison.entity.metertype.MeterType;
import com.laison.entity.metertype.MeterTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MeterTypeMapper {
    int countByExample(MeterTypeExample example);

    int deleteByExample(MeterTypeExample example);

    int deleteByPrimaryKey(Long meterTypeCode);

    int insert(MeterType record);

    int insertSelective(MeterType record);

    List<MeterType> selectByExample(MeterTypeExample example);

    MeterType selectByPrimaryKey(Long meterTypeCode);

    int updateByExampleSelective(@Param("record") MeterType record, @Param("example") MeterTypeExample example);

    int updateByExample(@Param("record") MeterType record, @Param("example") MeterTypeExample example);

    int updateByPrimaryKeySelective(MeterType record);

    int updateByPrimaryKey(MeterType record);
}