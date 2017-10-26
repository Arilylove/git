package com.laison.mapper.scheme.price.detail;

import com.laison.entity.scheme.price.detail.PriceSchemeDetail;
import com.laison.entity.scheme.price.detail.PriceSchemeDetailExample;
import com.laison.entity.scheme.price.detail.PriceSchemeDetailKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PriceSchemeDetailMapper {
    int countByExample(PriceSchemeDetailExample example);

    int deleteByExample(PriceSchemeDetailExample example);

    int deleteByPrimaryKey(PriceSchemeDetailKey key);

    int insert(PriceSchemeDetail record);

    int insertSelective(PriceSchemeDetail record);

    List<PriceSchemeDetail> selectByExample(PriceSchemeDetailExample example);

    PriceSchemeDetail selectByPrimaryKey(PriceSchemeDetailKey key);

    int updateByExampleSelective(@Param("record") PriceSchemeDetail record, @Param("example") PriceSchemeDetailExample example);

    int updateByExample(@Param("record") PriceSchemeDetail record, @Param("example") PriceSchemeDetailExample example);

    int updateByPrimaryKeySelective(PriceSchemeDetail record);

    int updateByPrimaryKey(PriceSchemeDetail record);
}