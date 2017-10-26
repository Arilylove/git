package com.laison.mapper.sysuser;

import com.laison.entity.sysrole.SysRole;
import com.laison.entity.sysuser.SysUser;
import com.laison.entity.sysuser.SysUserExample;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface SysUserMapper {
    int countByExample(SysUserExample example);

    int deleteByExample(SysUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    List<SysUser> selectByExample(SysUserExample example);

    SysUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysUser record, @Param("example") SysUserExample example);

    int updateByExample(@Param("record") SysUser record, @Param("example") SysUserExample example);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);
    List<String> queryAllMenuId(long userId);
  	List<String> queryAllPerms(long userId);

  	List<SysRole> queryUserRole(Long uid);
  	int resetPassword(Map map);

	void changeState(HashMap<String, Object> hashMap);

	List<SysUser> list();
	
	/**
	 * 
	 * @Title: countList 
	 * @Description: 查询数量  因为用插件有bug所有单独写一个
	 * @return long
	 */
	long countList();
}