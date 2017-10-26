package com.laison.mapper.sysuser;

import com.laison.entity.sysuser.UserView;
import com.laison.entity.sysuser.UserViewExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserViewMapper {
    int countByExample(UserViewExample example);

    int deleteByExample(UserViewExample example);

    int insert(UserView record);

    int insertSelective(UserView record);

    List<UserView> selectByExample(UserViewExample example);

    int updateByExampleSelective(@Param("record") UserView record, @Param("example") UserViewExample example);

    int updateByExample(@Param("record") UserView record, @Param("example") UserViewExample example);
}