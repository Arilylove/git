package com.laison.mapper.scheme.additionalfee.detail;

import com.laison.entity.scheme.additionalfee.detail.AdditionalFeeDetail;
import com.laison.entity.scheme.additionalfee.detail.AdditionalFeeDetailExample;
import com.laison.entity.scheme.additionalfee.detail.AdditionalFeeDetailKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdditionalFeeDetailMapper {
    int countByExample(AdditionalFeeDetailExample example);

    int deleteByExample(AdditionalFeeDetailExample example);

    int deleteByPrimaryKey(AdditionalFeeDetailKey key);

    int insert(AdditionalFeeDetail record);

    int insertSelective(AdditionalFeeDetail record);

    List<AdditionalFeeDetail> selectByExample(AdditionalFeeDetailExample example);

    AdditionalFeeDetail selectByPrimaryKey(AdditionalFeeDetailKey key);

    int updateByExampleSelective(@Param("record") AdditionalFeeDetail record, @Param("example") AdditionalFeeDetailExample example);

    int updateByExample(@Param("record") AdditionalFeeDetail record, @Param("example") AdditionalFeeDetailExample example);

    int updateByPrimaryKeySelective(AdditionalFeeDetail record);

    int updateByPrimaryKey(AdditionalFeeDetail record);

	Long selectSchemeLastIndex(Long additionalFeeSchemeCode);
}