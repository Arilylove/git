package com.laison.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.laison.common.cache.lock.RedisLock;
import com.laison.common.enumerate.Constant;
import com.laison.common.utils.IdGen;
import com.laison.common.utils.JedisUtils;
import com.laison.common.utils.R;
import com.laison.entity.customertype.PrepaymentCustomerParmExample;
import com.laison.entity.customertype.PrepaymentCustomerParmExample.Criteria;
import com.laison.entity.scheme.friendlyperiod.FriendlyPeriodScheme;
import com.laison.entity.scheme.friendlyperiod.FriendlyPeriodSchemeExample;
import com.laison.entity.scheme.holiday.HolidayScheme;
import com.laison.mapper.customertype.PrepaymentCustomerParmMapper;
import com.laison.mapper.scheme.friendlyperiod.FriendlyPeriodSchemeMapper;
import com.laison.mapper.scheme.holiday.HolidaySchemeMapper;
import com.laison.service.FriendlyPeriodService;
@Service("friendlyPeriodService")
public class FriendlyPeriodServiceImpl implements FriendlyPeriodService {
	@Autowired
	FriendlyPeriodSchemeMapper friendlyPeriodSchemeMapper;
	@Autowired
	HolidaySchemeMapper holidaySchemeMapper;
	@Autowired
	PrepaymentCustomerParmMapper prepaymentCustomerParmMapper;
	@Value(value = "#{prop['auto.generate.friendly.period.code']}")
	private boolean autoGenerateCode;// 是否自动生成主键
	@Override
	public R add(FriendlyPeriodScheme friendlyPeriodScheme) {
		if (!autoGenerateCode) {// 如果主键不是自动生成并且code前端没有给
			if (friendlyPeriodScheme.getFriendlyPeriodSchemeCode() == null) {
			return R.error("{friendly.period.scheme.code.null}");
			}
		} else {
			RedisLock lock = JedisUtils.getLock("laison_lock_" + Constant.FRIENDLY_PERIOD_SCHEME_CODE_TYPE);
			try {
				if (lock.lock()) {
					friendlyPeriodScheme.setFriendlyPeriodSchemeCode(IdGen.generateCode(Constant.FRIENDLY_PERIOD_SCHEME_CODE_TYPE));
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		}
		if(friendlyPeriodScheme.getEnableHolidayFlag()) {//判断是否开启节假日功能
			Long holidaySchemeCode = friendlyPeriodScheme.getHolidaySchemeCode();
			if(holidaySchemeCode==null) {
				return R.error("{holiday.scheme.code.null}");
			}
			HolidayScheme holidayScheme = holidaySchemeMapper.selectByPrimaryKey(holidaySchemeCode);
			if(holidayScheme==null) {
				return R.error("{holiday.scheme.not.exist}");
			}else {
				if(!holidayScheme.getEnableHolidaySchemeFlag()) {
					return R.error("{holiday.scheme.not.enable}");
				}
			}
		}
		friendlyPeriodSchemeMapper.insertSelective(friendlyPeriodScheme);
		R ok = R.ok("{add.ok}");
		return ok;
	}

	@Override
	public R del(FriendlyPeriodScheme friendlyPeriodScheme) {
		FriendlyPeriodScheme periodScheme = friendlyPeriodSchemeMapper.selectByPrimaryKey(friendlyPeriodScheme.getFriendlyPeriodSchemeCode());
		if(periodScheme==null) {
			return R.error("{friendly.period.scheme.not.exist}");
		}
		PrepaymentCustomerParmExample example=new PrepaymentCustomerParmExample();
		Criteria criteria = example.createCriteria();
		
		criteria.andFriendlyPeriodSchemeCodeEqualTo(friendlyPeriodScheme.getFriendlyPeriodSchemeCode());
		int count = prepaymentCustomerParmMapper.countByExample(example);
		if(count>0) {
			return R.error("{friendly.period.scheme.is.useing}");
		}
		friendlyPeriodSchemeMapper.deleteByPrimaryKey(friendlyPeriodScheme.getFriendlyPeriodSchemeCode());
		R ok = R.ok("{del.ok}");
		return ok;
	}

	@Override
	public R findOne(FriendlyPeriodScheme friendlyPeriodScheme) {
		friendlyPeriodScheme = friendlyPeriodSchemeMapper.selectByPrimaryKey(friendlyPeriodScheme.getFriendlyPeriodSchemeCode());
		if(friendlyPeriodScheme==null) {
			return R.error("{friendly.period.scheme.not.exist}"); 
		}
		R ok = R.ok();
		ok.put("friendlyPeriodScheme", friendlyPeriodScheme);
		return ok;
	}

	@Override
	public R findAll(FriendlyPeriodScheme friendlyPeriodScheme) {
		FriendlyPeriodSchemeExample example=new FriendlyPeriodSchemeExample();
		List<FriendlyPeriodScheme> selectByExample = friendlyPeriodSchemeMapper.selectByExample(example);
		return null;
	}
}
