package com.laison.mapper.scheme.holiday.detail;

import com.laison.entity.scheme.holiday.detail.HolidayDetail;
import com.laison.entity.scheme.holiday.detail.HolidayDetailExample;
import com.laison.entity.scheme.holiday.detail.HolidayDetailKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HolidayDetailMapper {
    int countByExample(HolidayDetailExample example);

    int deleteByExample(HolidayDetailExample example);

    int deleteByPrimaryKey(HolidayDetailKey key);

    int insert(HolidayDetail record);

    int insertSelective(HolidayDetail record);

    List<HolidayDetail> selectByExample(HolidayDetailExample example);

    HolidayDetail selectByPrimaryKey(HolidayDetailKey key);

    int updateByExampleSelective(@Param("record") HolidayDetail record, @Param("example") HolidayDetailExample example);

    int updateByExample(@Param("record") HolidayDetail record, @Param("example") HolidayDetailExample example);

    int updateByPrimaryKeySelective(HolidayDetail record);

    int updateByPrimaryKey(HolidayDetail record);
}