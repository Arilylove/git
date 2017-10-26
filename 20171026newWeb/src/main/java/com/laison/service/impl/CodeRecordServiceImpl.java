package com.laison.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laison.common.enumerate.Constant;
import com.laison.common.utils.DateUtils;
import com.laison.common.utils.IdGen;
import com.laison.common.utils.JedisUtils;
import com.laison.entity.coderecord.CodeRecord;
import com.laison.entity.coderecord.CodeRecordExample;
import com.laison.entity.coderecord.CodeRecordExample.Criteria;
import com.laison.mapper.coderecord.CodeRecordMapper;
import com.laison.service.CodeRecordService;

@Service("codeRecordService")
public class CodeRecordServiceImpl implements CodeRecordService {
	@Autowired
	CodeRecordMapper codeRecordMapper;
	private  int startNo = 10000001;// codeNo从10000001开始记录
	private String cacheName = "laison_code_cache";

	@Override
	public long getCode(int codeType) {
		String codeCurrentNo = null;
		String codePrefix = generateCodePrefix(codeType);
		codeCurrentNo = JedisUtils.getFromMapCache(cacheName, codePrefix);// 先从 redis获取
		if (codeCurrentNo == null) {// 缓存中没有 从数据库获取
			CodeRecordExample example = new CodeRecordExample();
			Criteria createCriteria = example.createCriteria();
			createCriteria.andCodePrefixEqualTo(Integer.parseInt((codePrefix)));// 添加查询条件
			List<CodeRecord> codeRecords = codeRecordMapper.selectByExample(example);
			if (codeRecords != null && codeRecords.size() > 0) {// 如果查到
				CodeRecord codeRecord = codeRecords.get(0);
				codeCurrentNo = codeRecord.getCurrentNo() + "";
				JedisUtils.setToMapCache(cacheName, codePrefix, codeCurrentNo);// 放到缓存先

			} else {// 数据库中也没有 创建一个
				CodeRecord codeRecord = new CodeRecord();
				codeRecord.setId(IdGen.uuid());
				codeRecord.setCodePrefix(Integer.parseInt(codePrefix));
				codeRecord.setCurrentNo(startNo);
				codeRecordMapper.insert(codeRecord);// 插入到数据库
				codeCurrentNo = codeRecord.getCurrentNo() + "";
				JedisUtils.setToMapCache(cacheName, codePrefix, codeCurrentNo);// 放到缓存先
			}
		}
		
		return Long.parseLong(codePrefix + codeCurrentNo);

	}
	@Override
	public void updateCode(int codeType) {
		int codeCurrentNo ;
		String codePrefix = generateCodePrefix(codeType);
		String codePreNo = JedisUtils.getFromMapCache(cacheName, codePrefix);// 先从 redis获取
		if(codePreNo==null) {
			codePreNo="10000000";
		}
		codeCurrentNo=Integer.parseInt(codePreNo)+1;//前面值+1
		//先更新数据库
		CodeRecord record =new CodeRecord();
		record.setCurrentNo(codeCurrentNo);//要更新的字段
		CodeRecordExample example=new CodeRecordExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andCodePrefixEqualTo(Integer.parseInt(codePrefix));//查询条件
		int countByExample = codeRecordMapper.countByExample(example);
		if(countByExample==0) {
			record.setId(IdGen.uuid());
			record.setCodePrefix(Integer.parseInt(codePrefix));
			codeRecordMapper.insertSelective(record);
		}else {
			codeRecordMapper.updateByExampleSelective(record, example);
		}
		
		//更新redis
		JedisUtils.setToMapCache(cacheName, codePrefix, codeCurrentNo+"");// 放到缓存
		
	}
	private String generateCodePrefix(int codeType) {
		String date = DateUtils.getDate("yyyyMM");
		return date + Constant.SYSTEM_NUMBER + codeType;
	}

	
}
