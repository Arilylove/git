package com.laison.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.laison.common.cache.lock.RedisLock;
import com.laison.common.enumerate.Constant;
import com.laison.common.utils.DateUtils;
import com.laison.common.utils.IdGen;
import com.laison.common.utils.JedisUtils;
import com.laison.common.utils.R;
import com.laison.entity.customertype.CustomerTypeExample;
import com.laison.entity.customertype.CustomerTypeExample.Criteria;
import com.laison.entity.metertype.MeterType;
import com.laison.entity.metertype.MeterTypeExample;
import com.laison.mapper.customertype.CustomerTypeMapper;
import com.laison.mapper.metertype.MeterTypeMapper;
import com.laison.service.MeterTypeService;

@Service("meterTypeService")
public class MeterTypeServiceImpl implements MeterTypeService {
	@Autowired
	MeterTypeMapper meterTypeMapper;
	@Autowired
	CustomerTypeMapper customerTypeMapper;
	@Value(value = "#{prop['auto.generate.metertype.code']}")
	private boolean autoGenerateCode;// 是否自动生成主键
	@Value(value = "#{prop['measureMode']}")
	private int measureModeInConfig;// 系统配置文件中的记录方式

	@Override
	public R add(MeterType meterType) {
		if (!autoGenerateCode ) {// 如果主键不是自动生成并且code前端没有给
			if( meterType.getMeterTypeCode() == null) {
				return R.error("{metertype.code.null}");
			}
		}else{
			RedisLock lock = JedisUtils.getLock("laison_lock_" + Constant.METER_TYPE_CODE_TYPE);
			try {
				if (lock.lock()) {
					meterType.setMeterTypeCode(IdGen.generateCode(Constant.METER_TYPE_CODE_TYPE));
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		}
		
		if(measureModeInConfig!=2) {// 表记计量模式按配置文件设置
			meterType.setMeasureMode(measureModeInConfig);
		}//表记计量模式需前端上传
		Integer	measureMode = meterType.getMeasureMode();
		if(measureMode==null) {
			return R.error("{measure.mode.null}");
		}
		
		Integer lcdType = meterType.getLcdType();
		if(lcdType==0&&measureMode==0) {
			Integer currencySymbol = meterType.getCurrencySymbol();
			if(currencySymbol==null) {
				return R.error("{currencysymbol.null}");
			}else {
				if(currencySymbol<0||currencySymbol>1) {
					return R.error("{currencysymbol.miss}");
				}
			}
		}
		meterType.setCreateDate(DateUtils.utcDate());
		meterTypeMapper.insertSelective(meterType);
		return R.ok("{add.ok}");
	}

	@Override
	public R del(MeterType meterType) {
		MeterType selectByPrimaryKey = meterTypeMapper.selectByPrimaryKey(meterType.getMeterTypeCode());
		if(selectByPrimaryKey==null) {
			return R.error("{metertype.not.exist}");
		}
		CustomerTypeExample example=new CustomerTypeExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andMeterTypeCodeEqualTo(meterType.getMeterTypeCode());
		int count = customerTypeMapper.countByExample(example);
		if(count>0) {//查看是否被用户类型在使用
			return R.error("{metertype.is.useing}");
		}
		meterTypeMapper.deleteByPrimaryKey(meterType.getMeterTypeCode());
		return R.ok("{del.ok}");
	}

	@Override
	public R update(MeterType meterType) {
		MeterType selectByPrimaryKey = meterTypeMapper.selectByPrimaryKey(meterType.getMeterTypeCode());
		if(selectByPrimaryKey==null) {
			return R.error("{metertype.not.exist}");
		}
		Integer measureMode = meterType.getMeasureMode();
		Integer lcdType = meterType.getLcdType();
		if(lcdType!=null&&measureMode!=null&&lcdType==0&&measureMode==0) {
			Integer currencySymbol = meterType.getCurrencySymbol();
			if(currencySymbol==null) {
				return R.error("{currencysymbol.null}");
			}else {
				if(currencySymbol<0||currencySymbol>1) {
					return R.error("{currencysymbol.miss}");
				}
			}
		}
		meterTypeMapper.updateByPrimaryKeySelective(meterType);
		return R.ok("{update.ok}");
	}

	@Override
	public R findOne(MeterType meterType) {
		MeterType selectByPrimaryKey = meterTypeMapper.selectByPrimaryKey(meterType.getMeterTypeCode());
		if(selectByPrimaryKey==null) {
			return R.error("{metertype.not.exist}");
		}
		R ok = R.ok();
		ok.put("meterType", selectByPrimaryKey);
		return ok;
	}

	@Override
	public R findAll() {
		MeterTypeExample example=new MeterTypeExample();
		List<MeterType> meterTypelist = meterTypeMapper.selectByExample(example);
		R ok = R.ok();
		ok.put("meterTypelist", meterTypelist);
		return ok;
	}

}
