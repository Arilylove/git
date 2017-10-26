package com.laison.service.impl;

import java.util.Date;
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
import com.laison.entity.companyinfo.CompanyInfo;
import com.laison.entity.companyinfo.CompanyInfoExample;
import com.laison.entity.stationinfo.StationInfo;
import com.laison.entity.stationinfo.StationInfoExample;
import com.laison.entity.stationinfo.StationInfoExample.Criteria;
import com.laison.entity.stationinfo.StationInfoKey;
import com.laison.entity.sysuser.SysUserExample;
import com.laison.mapper.companyinfo.CompanyInfoMapper;
import com.laison.mapper.stationinfo.StationInfoMapper;
import com.laison.mapper.sysuser.SysUserMapper;
import com.laison.service.CompanyInfoService;

@Service("sompanyInfoService")
public class CompanyInfoServiceImpl implements CompanyInfoService {
	@Autowired
	CompanyInfoMapper companyInfoMapper;
	@Autowired
	StationInfoMapper stationInfoMapper;
	@Autowired
	SysUserMapper sysUserMapper;
	@Value(value = "#{prop['auto.generate.company.code']}")
	private boolean autoGenerateCompanyCode;// 是否自动生成主键
	@Value(value = "#{prop['auto.generate.station.code']}")
	private boolean autoGenerateStationCode;// 是否自动生成主键
	@Override
	public R addCompany(CompanyInfo company) {
		if (!autoGenerateCompanyCode ) {// 如果主键不是自动生成并且code前端没有给
			if(company.getCompanyCode() == null) {
				return R.error("{companycode.null}");
			}
		} else {
			RedisLock lock = JedisUtils.getLock("laison_lock_" + Constant.COMPANY_CODE_TYPE);
			try {
				if (lock.lock()) {
					company.setCompanyCode(IdGen.generateCode(Constant.COMPANY_CODE_TYPE));
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		}
		company.setCreateDate(DateUtils.utcDate());
		companyInfoMapper.insertSelective(company);
		return R.ok("{add.ok}");
	}

	@Override
	public R addStation(StationInfo stationInfo) {
		if (!autoGenerateStationCode ) {// 如果主键不是自动生成并且code前端没有给
			if(stationInfo.getStationCode() == null) {
				R.error("{stationCode.null}");				
			}
		} else {
			CompanyInfo parentCompany = companyInfoMapper.selectByPrimaryKey(stationInfo.getCompanyCode());
			if(parentCompany==null) {
				return R.error("{company.not.exist}");
			}
			
			RedisLock lock = JedisUtils.getLock("laison_lock_" + Constant.STATION_CODE_TYPE);
			try {
				if (lock.lock()) {
					stationInfo.setStationCode(IdGen.generateCode(Constant.STATION_CODE_TYPE));
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		}
		stationInfo.setCreateDate(DateUtils.utcDate());
		stationInfoMapper.insertSelective(stationInfo);
		return R.ok("{add.ok}");
	}

	@Override
	public R delCompany(CompanyInfo company) {
		CompanyInfo companyFind = companyInfoMapper.selectByPrimaryKey(company.getCompanyCode());
		if(companyFind==null) {
			return R.error("{company.not.exit}");
		}else {
			StationInfoExample example= new StationInfoExample();
			Criteria createCriteria = example.createCriteria();
			createCriteria.andCompanyCodeEqualTo(company.getCompanyCode());
			int count = stationInfoMapper.countByExample(example);
			if(count>0) {
				return R.error("{company.is.useing}");
			}
			SysUserExample userExample=new SysUserExample();
			com.laison.entity.sysuser.SysUserExample.Criteria userCriteria = userExample.createCriteria();
			userCriteria.andCompanyCodeEqualTo(company.getCompanyCode());
			int countForuser = sysUserMapper.countByExample(userExample);
			if(countForuser>0) {
				return R.error("{company.is.useing}");
			}
			companyInfoMapper.deleteByPrimaryKey(company.getCompanyCode());
		}
		return R.ok("{del.ok}");
	}

	@Override
	public R delStation(StationInfo station) {
		StationInfoKey key =new StationInfoKey();
		key.setCompanyCode(station.getCompanyCode());
		key.setStationCode(station.getStationCode());
		StationInfo oldStation = stationInfoMapper.selectByPrimaryKey(key);
		if(oldStation==null) {
			return R.error("{station.not.exit}");
		}
		SysUserExample userExample=new SysUserExample();
		com.laison.entity.sysuser.SysUserExample.Criteria createCriteria = userExample.createCriteria();
		createCriteria.andStationCodeEqualTo(station.getStationCode());
		int count = sysUserMapper.countByExample(userExample);
		if(count>0) {
			return R.error("{station.is.useing}");
		}
		
		stationInfoMapper.deleteByPrimaryKey(key);
		return R.ok("{del.ok}");
	}

	@Override
	public R updateCompany(CompanyInfo company) {
		CompanyInfo companyFind = companyInfoMapper.selectByPrimaryKey(company.getCompanyCode());
		if(companyFind==null) {
			return R.error("{company.not.exit}");
		}else {
			companyInfoMapper.updateByPrimaryKeySelective(company);
		}
		return R.ok("{update.ok}");
	}

	@Override
	public R updateStation(StationInfo station) {
		StationInfoKey key =new StationInfoKey();
		key.setCompanyCode(station.getCompanyCode());
		key.setStationCode(station.getStationCode());
		StationInfo oldStation = stationInfoMapper.selectByPrimaryKey(key);
		if(oldStation==null) {
			return R.error("{station.not.exit}");
		}
		stationInfoMapper.updateByPrimaryKeySelective(station);
		return R.ok("{update.ok}");
	}

	@Override
	public R findCompany(CompanyInfo company) {
		CompanyInfoExample example=new CompanyInfoExample();
		com.laison.entity.companyinfo.CompanyInfoExample.Criteria createCriteria = example.createCriteria();
		if(company!=null) {
			if(company.getCompanyCode()!=null) {
				createCriteria.andCompanyCodeEqualTo(company.getCompanyCode());
			}// 如果还有其他条件可以继续添加
		}
		List<CompanyInfo> companys = companyInfoMapper.selectByExample(example);
		R ok = R.ok();
		ok.put("companys", companys);
		return ok;
	}
	
}
