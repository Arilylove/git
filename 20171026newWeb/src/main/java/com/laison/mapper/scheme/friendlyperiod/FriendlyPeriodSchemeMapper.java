package com.laison.mapper.scheme.friendlyperiod;

import com.laison.entity.scheme.friendlyperiod.FriendlyPeriodScheme;
import com.laison.entity.scheme.friendlyperiod.FriendlyPeriodSchemeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FriendlyPeriodSchemeMapper {
    int countByExample(FriendlyPeriodSchemeExample example);

    int deleteByExample(FriendlyPeriodSchemeExample example);

    int deleteByPrimaryKey(Long friendlyPeriodSchemeCode);

    int insert(FriendlyPeriodScheme record);

    int insertSelective(FriendlyPeriodScheme record);

    List<FriendlyPeriodScheme> selectByExample(FriendlyPeriodSchemeExample example);

    FriendlyPeriodScheme selectByPrimaryKey(Long friendlyPeriodSchemeCode);

    int updateByExampleSelective(@Param("record") FriendlyPeriodScheme record, @Param("example") FriendlyPeriodSchemeExample example);

    int updateByExample(@Param("record") FriendlyPeriodScheme record, @Param("example") FriendlyPeriodSchemeExample example);

    int updateByPrimaryKeySelective(FriendlyPeriodScheme record);

    int updateByPrimaryKey(FriendlyPeriodScheme record);
}