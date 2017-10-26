package com.laison.mapper.scheme.additionalfee;

import com.laison.entity.scheme.additionalfee.AdditionalFeeScheme;
import com.laison.entity.scheme.additionalfee.AdditionalFeeSchemeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdditionalFeeSchemeMapper {
    int countByExample(AdditionalFeeSchemeExample example);

    int deleteByExample(AdditionalFeeSchemeExample example);

    int deleteByPrimaryKey(Long additionalFeeSchemeCode);

    int insert(AdditionalFeeScheme record);

    int insertSelective(AdditionalFeeScheme record);

    List<AdditionalFeeScheme> selectByExample(AdditionalFeeSchemeExample example);

    AdditionalFeeScheme selectByPrimaryKey(Long additionalFeeSchemeCode);

    int updateByExampleSelective(@Param("record") AdditionalFeeScheme record, @Param("example") AdditionalFeeSchemeExample example);

    int updateByExample(@Param("record") AdditionalFeeScheme record, @Param("example") AdditionalFeeSchemeExample example);

    int updateByPrimaryKeySelective(AdditionalFeeScheme record);

    int updateByPrimaryKey(AdditionalFeeScheme record);
}