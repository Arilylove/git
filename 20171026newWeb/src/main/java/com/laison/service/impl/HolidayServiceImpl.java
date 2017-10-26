package com.laison.service.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laison.common.cache.lock.RedisLock;
import com.laison.common.enumerate.Constant;
import com.laison.common.utils.DateUtils;
import com.laison.common.utils.IdGen;
import com.laison.common.utils.JedisUtils;
import com.laison.common.utils.R;
import com.laison.entity.scheme.friendlyperiod.FriendlyPeriodSchemeExample;
import com.laison.entity.scheme.holiday.HolidayScheme;
import com.laison.entity.scheme.holiday.HolidaySchemeExample;
import com.laison.entity.scheme.holiday.detail.HolidayDetail;
import com.laison.entity.scheme.holiday.detail.HolidayDetailExample;
import com.laison.entity.scheme.holiday.detail.HolidayDetailExample.Criteria;
import com.laison.entity.scheme.holiday.detail.HolidayDetailKey;
import com.laison.mapper.scheme.friendlyperiod.FriendlyPeriodSchemeMapper;
import com.laison.mapper.scheme.holiday.HolidaySchemeMapper;
import com.laison.mapper.scheme.holiday.detail.HolidayDetailMapper;
import com.laison.service.HolidayService;
@Service("holidayService")
public class HolidayServiceImpl implements HolidayService {
	@Autowired
	HolidaySchemeMapper holidaySchemeMapper;
	@Autowired
	HolidayDetailMapper holidayDetailMapper;
	@Autowired
	FriendlyPeriodSchemeMapper friendlyPeriodSchemeMapper;
	/* (non-Javadoc)
	 * @see com.laison.service.HolidayService#add(com.laison.entity.scheme.holiday.HolidayScheme)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public R add(HolidayScheme holidayScheme) {
		RedisLock lock = JedisUtils.getLock("laison_lock_" + Constant.HOLIDAY_SCHEME_CODE_TYPE);
		try {
			if (lock.lock()) {
				holidayScheme.setHolidaySchemeCode(IdGen.generateCode(Constant.HOLIDAY_SCHEME_CODE_TYPE));
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
		List<HolidayDetail> holidayDetails = holidayScheme.getHolidayDetails();
		LinkedHashSet<Integer> yearSet = new LinkedHashSet<Integer>();
		int year = Integer.parseInt(DateUtils.getYear());//当前年份
		for (int i = 0; i < 10; i++) {// 产生近十年年份放入yearSet
			yearSet.add(year+i);
		}
		if(holidayDetails==null) {
			
			holidayDetails = new ArrayList<HolidayDetail>();
			for (Integer tempYear : yearSet) {//10年每天都不是節假日
				HolidayDetail holidayDetail = new HolidayDetail();
				holidayDetail.setYearOfDate(tempYear);
				holidayDetail.setHolidaySchemeCode(holidayScheme.getHolidaySchemeCode());;
				holidayDetails.add(holidayDetail);
			}
		}else {
			for (HolidayDetail tempHolidayDetail : holidayDetails) {
				if(!yearSet.contains(tempHolidayDetail.getYearOfDate())) {//如果不是近10年的数据报错
					return R.error("{holiday.detail.year.error}");
				}else {
					tempHolidayDetail.setHolidaySchemeCode(holidayScheme.getHolidaySchemeCode());
					yearSet.remove(tempHolidayDetail.getYearOfDate());//已经有了，删除该年
				}
			}
			for (Integer tempYear : yearSet) {// 补齐剩余的年份
				HolidayDetail holidayDetail = new HolidayDetail();
				holidayDetail.setYearOfDate(tempYear);
				holidayDetail.setHolidaySchemeCode(holidayScheme.getHolidaySchemeCode());;
				holidayDetails.add(holidayDetail);
			}
		}
		holidayScheme.setHolidayDetails(holidayDetails);
		holidaySchemeMapper.insertSelective(holidayScheme);
		for (HolidayDetail tempHolidayDetail : holidayDetails) {
			holidayDetailMapper.insertSelective(tempHolidayDetail);
		}
		R ok = R.ok("add.ok");
		ok.put("holidayScheme", holidayScheme);
		return ok;
	}
	@SuppressWarnings("unchecked")
	@Override
	public R findOne(HolidayScheme holidayScheme) {
		holidayScheme=holidaySchemeMapper.selectByPrimaryKey(holidayScheme.getHolidaySchemeCode());
		if(holidayScheme==null) {
			return R.error("{holiday.scheme.not.exist}"); 
		}
		R ok = R.ok();
		ok.put("holidayScheme", holidayScheme);
		return ok;
	}
	@Override
	public R updateOne(HolidayScheme holidayScheme) {
		List<HolidayDetail> holidayDetails = holidayScheme.getHolidayDetails();
		if(holidayDetails!=null) {
			LinkedHashSet<Integer> yearSet = new LinkedHashSet<Integer>();
			int year = Integer.parseInt(DateUtils.getYear());//当前年份
			for (int i = 0; i < 10; i++) {// 产生近十年年份放入yearSet
				yearSet.add(year+i);
			}
			for (HolidayDetail tempHolidayDetail : holidayDetails) {
				if(!yearSet.contains(tempHolidayDetail.getYearOfDate())) {//如果不是近10年的数据报错
					return R.error("{holiday.detail.year.error}");
				}else {
					tempHolidayDetail.setHolidaySchemeCode(holidayScheme.getHolidaySchemeCode());
				}
			}
			
			//再添加details
			for (HolidayDetail tempHolidayDetail : holidayDetails) {
				HolidayDetailKey key=new HolidayDetailKey();
				key.setHolidaySchemeCode(tempHolidayDetail.getHolidaySchemeCode());
				key.setYearOfDate(tempHolidayDetail.getYearOfDate());
				HolidayDetail oldHolidayDetail = holidayDetailMapper.selectByPrimaryKey(key);
				if(oldHolidayDetail!=null) {
					tempHolidayDetail.setHolidayVersion(oldHolidayDetail.getHolidayVersion()+1);
					
					holidayDetailMapper.updateByPrimaryKeySelective(tempHolidayDetail);
				}else {
					holidayDetailMapper.insertSelective(tempHolidayDetail);
				}
				
			}
			
		}
		//修改其他部分
		holidaySchemeMapper.updateByPrimaryKeySelective(holidayScheme);
		R ok = R.ok("{update.ok}");
		holidayScheme=holidaySchemeMapper.selectByPrimaryKey(holidayScheme.getHolidaySchemeCode());
		ok.put("holidayScheme", holidayScheme);
		return ok;
	}
	@Override
	public R del(HolidayScheme holidayScheme) {
		//查看是否被使用
		FriendlyPeriodSchemeExample example=new FriendlyPeriodSchemeExample();
		com.laison.entity.scheme.friendlyperiod.FriendlyPeriodSchemeExample.Criteria createCriteria = example.createCriteria();
		createCriteria.andHolidaySchemeCodeEqualTo(holidayScheme.getHolidaySchemeCode());
		int count = friendlyPeriodSchemeMapper.countByExample(example);
		if(count>0) {
			return R.error("{holiday.scheme.is.useing}");
		}
		//删除方案
		holidaySchemeMapper.deleteByPrimaryKey(holidayScheme.getHolidaySchemeCode());
		//删除detail
		HolidayDetailExample detailExample=new HolidayDetailExample();
		Criteria detailCriteria = detailExample.createCriteria();
		detailCriteria.andHolidaySchemeCodeEqualTo(holidayScheme.getHolidaySchemeCode());
		holidayDetailMapper.deleteByExample(detailExample);
		return R.ok("{del.ok}");
	}
	@Override
	public R findAll() {
		HolidaySchemeExample example=new HolidaySchemeExample();
		List<HolidayScheme> holidaySchemes = holidaySchemeMapper.selectByExample(example);
		R ok = R.ok();
		ok.put("holidaySchemes", holidaySchemes);
		return ok;
	}
}
