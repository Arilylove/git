package com.laison.mapper.coderecord;

import com.laison.entity.coderecord.CodeRecord;
import com.laison.entity.coderecord.CodeRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CodeRecordMapper {
    int countByExample(CodeRecordExample example);

    int deleteByExample(CodeRecordExample example);

    int deleteByPrimaryKey(String id);

    int insert(CodeRecord record);

    int insertSelective(CodeRecord record);

    List<CodeRecord> selectByExample(CodeRecordExample example);

    CodeRecord selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CodeRecord record, @Param("example") CodeRecordExample example);

    int updateByExample(@Param("record") CodeRecord record, @Param("example") CodeRecordExample example);

    int updateByPrimaryKeySelective(CodeRecord record);

    int updateByPrimaryKey(CodeRecord record);

	
}