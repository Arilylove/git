package com.laison.mapper.customertype;

import com.laison.entity.customertype.CustomerType;
import com.laison.entity.customertype.CustomerTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomerTypeMapper {
    int countByExample(CustomerTypeExample example);

    int deleteByExample(CustomerTypeExample example);

    int deleteByPrimaryKey(Long customerTypeCode);

    int insert(CustomerType record);

    int insertSelective(CustomerType record);

    List<CustomerType> selectByExample(CustomerTypeExample example);

    CustomerType selectByPrimaryKey(Long customerTypeCode);

    int updateByExampleSelective(@Param("record") CustomerType record, @Param("example") CustomerTypeExample example);

    int updateByExample(@Param("record") CustomerType record, @Param("example") CustomerTypeExample example);

    int updateByPrimaryKeySelective(CustomerType record);

    int updateByPrimaryKey(CustomerType record);
}