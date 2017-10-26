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
import com.laison.entity.customertype.CustomerType;
import com.laison.entity.customertype.CustomerTypeExample;
import com.laison.entity.customertype.CustomerTypeExample.Criteria;
import com.laison.entity.customertype.PrepaymentCustomerParm;
import com.laison.entity.metertype.MeterType;
import com.laison.entity.scheme.friendlyperiod.FriendlyPeriodScheme;
import com.laison.mapper.customertype.CustomerTypeMapper;
import com.laison.mapper.customertype.PrepaymentCustomerParmMapper;
import com.laison.mapper.metertype.MeterTypeMapper;
import com.laison.mapper.scheme.friendlyperiod.FriendlyPeriodSchemeMapper;
import com.laison.service.CustomerTypeService;

@Service("customerTypeService")
public class CustomerTypeServiceImpl implements CustomerTypeService {
	@Autowired
	CustomerTypeMapper customerTypeMapper;
	@Autowired
	PrepaymentCustomerParmMapper prepaymentCustomerParmMapper;
	@Autowired
	MeterTypeMapper meterTypeMapper;
	@Autowired
	FriendlyPeriodSchemeMapper friendlyPeriodSchemeMapper;
	@Value(value = "#{prop['auto.generate.customertype.code']}")
	private boolean autoGenerateCode;// 是否自动生成主键
	@Value(value = "#{prop['enable.holiday']}")
	private boolean enableholiday;// 是否开启友好时段功能
	@Override
	public R addCustomerType(CustomerType customerType) {
		if (!autoGenerateCode) {// 如果主键不是自动生成并且code前端没有给
			if (customerType.getCustomerTypeCode() == null) {
			return R.error("{customer.type.code.null}");
			}
		} else {//获取主键
			RedisLock lock = JedisUtils.getLock("laison_lock_" + Constant.CUSTOMER_TYPE_CODE_TYPE);
			try {
				if (lock.lock()) {
					customerType.setCustomerTypeCode(IdGen.generateCode(Constant.CUSTOMER_TYPE_CODE_TYPE));
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		}
		Integer payType = customerType.getPayType();
		if (payType.equals(0)) {// 如果是预付费用户
			PrepaymentCustomerParm prepaymentCustomerParm = customerType.getPrepaymentCustomerParm();
			if (prepaymentCustomerParm == null) {
				return R.error("{prepayment.customer.parm.null}");
			} else {
				/*if (prepaymentCustomerParm.getMonthLimitFlag() == null) {
					return R.error("{prepayment.customer.parm.monthLimitflag.null}");
				}*/
				// 同上的 各种判断是否为空 有默认值根据业务判断需要判断那几个字段
				// #############################
				// ##########带编写代码    也可以不写代码 放在 bean检测中##################
				if(enableholiday) {
					Long friendlyPeriodSchemeCode = prepaymentCustomerParm.getFriendlyPeriodSchemeCode();
					if(friendlyPeriodSchemeCode==null) {
						return R.error("{holiday.is.enable}");
					}
					FriendlyPeriodScheme friendPeriodScheme = friendlyPeriodSchemeMapper.selectByPrimaryKey(friendlyPeriodSchemeCode);
					if(friendPeriodScheme==null) {
						return R.error("{friendly.period.scheme.not.exist}");
					}
				}

			}
			prepaymentCustomerParm.setCustomerTypeCode(customerType.getCustomerTypeCode());// 设置主键
		}

		// 判断表记类型是否存在
		MeterType meterType = meterTypeMapper.selectByPrimaryKey(customerType.getMeterTypeCode());
		if(meterType==null) {
			return R.error("{metertype.not.exist}");
		}
		// 判断价格方案是否存在
		//#######待写##########
		customerTypeMapper.insertSelective(customerType);
		prepaymentCustomerParmMapper.insertSelective(customerType.getPrepaymentCustomerParm());
		return R.ok("{add.ok}");
	}

	@Override
	public R delCustomerType(CustomerType customerType) {
		CustomerType delCustomTupe = customerTypeMapper.selectByPrimaryKey(customerType.getCustomerTypeCode());
		if(delCustomTupe==null) {
			return R.error("{customertype.not.exist}");
		}
		//判断是否正在被使用
		customerTypeMapper.deleteByPrimaryKey(customerType.getCustomerTypeCode());
		prepaymentCustomerParmMapper.deleteByPrimaryKey(customerType.getCustomerTypeCode());
		R ok = R.ok("{del.ok}");
		return ok;
	}

	@Override
	public R findAll() {
		CustomerTypeExample example=new CustomerTypeExample();
		List<CustomerType> lists = customerTypeMapper.selectByExample(example);
		R ok = R.ok();
		ok.put("customers", lists);
		return ok;
	}

	@Override
	public R findOne(CustomerType customerType) {
		customerType= customerTypeMapper.selectByPrimaryKey(customerType.getCustomerTypeCode());
		if(customerType==null) {
			return R.error("{customertype.not.exist}");
		}
		R ok = R.ok();
		ok.put("customType", customerType);
		return ok;
	}

	@Override
	public R findUseful() {
		CustomerTypeExample example=new CustomerTypeExample();
		Criteria criteria = example.createCriteria();
		criteria.andStateNotEqualTo("0");
		List<CustomerType> lists = customerTypeMapper.selectByExample(example);
		R ok = R.ok();
		ok.put("customers", lists);
		return ok;
	}

}
