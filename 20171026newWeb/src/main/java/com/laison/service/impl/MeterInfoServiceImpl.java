package com.laison.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laison.common.utils.R;
import com.laison.entity.meterinfo.MeterInfo;
import com.laison.entity.meterinfo.MeterInfoExample;
import com.laison.entity.meterinfo.detail.MeterInfoDetail;
import com.laison.entity.meterinfo.detail.MeterInfoDetailKey;
import com.laison.mapper.meterinfo.MeterInfoMapper;
import com.laison.mapper.meterinfo.detail.MeterInfoDetailMapper;
import com.laison.service.MeterInfoService;

@Service("meterInfoService")
public class MeterInfoServiceImpl implements MeterInfoService {
	
	@Autowired
	MeterInfoMapper meterInfoMapper;
	
	@Autowired
	MeterInfoDetailMapper meterInfoDetailMapper;
	
	@Override
	public R addMeter(MeterInfo meterInfo) {
		//判断主键是否自动生成
		
		Long meterCode = meterInfo.getMeterCode();
		//meterInfo.setMeterCode(meterCode);
		//判断是否有客户类型代码
		Long customerTypeCode = meterInfo.getCustomerTypeCode();
		if(customerTypeCode == null) {
			return R.error("客户类型不存在");
		}
		Integer encryptWay = meterInfo.getEncryptWay();
		//硬加密
		if(encryptWay == 0) {
			meterInfo.setSoftEncryptStates("0");
		}
		//软加密
		
		//添加详细表detail
		List<MeterInfoDetail> meterDetails = meterInfo.getMeterDetail();
		for(MeterInfoDetail meterDetail:meterDetails) {
			//表号在12位或13位					
			if(meterDetail.getMeterNum().length() != 12 && meterDetail.getMeterNum().length() != 13) {
				return R.error("请输入12或13位表号");
			}
			//13位表号需要验证最后一位
			
			//批量加入(需要详细信息表)
			//meter_num_code 需要默认值
			meterDetail.setMeterCode(meterCode);
			//meter_code 值等于表信息code		
			meterInfoDetailMapper.insertSelective(meterDetail);
		}
		
		meterInfoMapper.insertSelective(meterInfo);
		return R.ok("{add.ok}");

	}

	@Override
	public R findAll() {
		MeterInfoExample example = new MeterInfoExample();
		List<MeterInfo> selectMeterInfo = meterInfoMapper.selectByExample(example);
		R ok = R.ok();
		ok.putIfAbsent("selectMeterInfo", selectMeterInfo);
		return ok;
	}

	@Override
	public R updateMeter(MeterInfo meterInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public R findMeterById(Long id) {
		List<MeterInfo> findById = (List<MeterInfo>) meterInfoMapper.selectByPrimaryKey(id);
		R ok=R.ok();
		ok.putIfAbsent("findById", findById);
		return ok;
	}

	@Override
	public R findMeterByInfo(MeterInfo meterInfo) {
		// TODO Auto-generated method stub
		return null;
	}

}
