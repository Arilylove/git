package com.laison.mapper.scheme.holiday;

import com.laison.entity.scheme.holiday.HolidayScheme;
import com.laison.entity.scheme.holiday.HolidaySchemeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HolidaySchemeMapper {
    int countByExample(HolidaySchemeExample example);

    int deleteByExample(HolidaySchemeExample example);

    int deleteByPrimaryKey(Long holidaySchemeCode);

    int insert(HolidayScheme record);

    int insertSelective(HolidayScheme record);

    List<HolidayScheme> selectByExample(HolidaySchemeExample example);

    HolidayScheme selectByPrimaryKey(Long holidaySchemeCode);

    int updateByExampleSelective(@Param("record") HolidayScheme record, @Param("example") HolidaySchemeExample example);

    int updateByExample(@Param("record") HolidayScheme record, @Param("example") HolidaySchemeExample example);

    int updateByPrimaryKeySelective(HolidayScheme record);

    int updateByPrimaryKey(HolidayScheme record);
}