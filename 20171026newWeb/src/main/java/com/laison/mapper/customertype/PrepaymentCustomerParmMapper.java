package com.laison.mapper.customertype;

import com.laison.entity.customertype.PrepaymentCustomerParm;
import com.laison.entity.customertype.PrepaymentCustomerParmExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PrepaymentCustomerParmMapper {
    int countByExample(PrepaymentCustomerParmExample example);

    int deleteByExample(PrepaymentCustomerParmExample example);

    int deleteByPrimaryKey(Long customerTypeCode);

    int insert(PrepaymentCustomerParm record);

    int insertSelective(PrepaymentCustomerParm record);

    List<PrepaymentCustomerParm> selectByExample(PrepaymentCustomerParmExample example);

    PrepaymentCustomerParm selectByPrimaryKey(Long customerTypeCode);

    int updateByExampleSelective(@Param("record") PrepaymentCustomerParm record, @Param("example") PrepaymentCustomerParmExample example);

    int updateByExample(@Param("record") PrepaymentCustomerParm record, @Param("example") PrepaymentCustomerParmExample example);

    int updateByPrimaryKeySelective(PrepaymentCustomerParm record);

    int updateByPrimaryKey(PrepaymentCustomerParm record);
}