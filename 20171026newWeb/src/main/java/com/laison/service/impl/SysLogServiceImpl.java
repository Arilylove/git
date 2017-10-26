package com.laison.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laison.entity.syslog.SysLog;
import com.laison.mapper.syslog.SysLogMapper;
import com.laison.service.SysLogService;
@Service("sysLogService")
public class SysLogServiceImpl implements SysLogService {
	@Autowired
	SysLogMapper sysLogMapper;
	
	@Override
	public void save(SysLog sysLog) {
		sysLogMapper.insertSelective(sysLog);
	}

}
