package com.laison.mapper.scheme.price;

import com.laison.entity.scheme.price.PriceScheme;
import com.laison.entity.scheme.price.PriceSchemeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PriceSchemeMapper {
    int countByExample(PriceSchemeExample example);

    int deleteByExample(PriceSchemeExample example);

    int deleteByPrimaryKey(Long priceSchemeCode);

    int insert(PriceScheme record);

    int insertSelective(PriceScheme record);

    List<PriceScheme> selectByExample(PriceSchemeExample example);

    PriceScheme selectByPrimaryKey(Long priceSchemeCode);

    int updateByExampleSelective(@Param("record") PriceScheme record, @Param("example") PriceSchemeExample example);

    int updateByExample(@Param("record") PriceScheme record, @Param("example") PriceSchemeExample example);

    int updateByPrimaryKeySelective(PriceScheme record);

    int updateByPrimaryKey(PriceScheme record);
}