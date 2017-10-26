package com.laison.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.laison.common.cache.lock.RedisLock;
import com.laison.common.enumerate.Constant;
import com.laison.common.sql.Query;
import com.laison.common.utils.IdGen;
import com.laison.common.utils.JedisUtils;
import com.laison.common.utils.R;
import com.laison.entity.scheme.additionalfee.AdditionalFeeScheme;
import com.laison.entity.scheme.additionalfee.AdditionalFeeSchemeExample;
import com.laison.entity.scheme.additionalfee.detail.AdditionalFeeDetail;
import com.laison.entity.scheme.additionalfee.detail.AdditionalFeeDetailExample;
import com.laison.entity.scheme.additionalfee.detail.AdditionalFeeDetailExample.Criteria;
import com.laison.entity.sysuser.UserView;
import com.laison.entity.scheme.additionalfee.detail.AdditionalFeeDetailKey;
import com.laison.mapper.scheme.additionalfee.AdditionalFeeSchemeMapper;
import com.laison.mapper.scheme.additionalfee.detail.AdditionalFeeDetailMapper;
import com.laison.service.AdditionalFeeSchemeService;

//添加到spring容器
@Service("additionalFeeSchemeService")
public class AdditionalFeeSchemeServiceImpl implements AdditionalFeeSchemeService {

	@Autowired
	AdditionalFeeSchemeMapper additionalFeeSchemeMapper;
	@Autowired
	AdditionalFeeDetailMapper additionalFeeDetailMapper;

	// 税率模式
	@Value(value = "#{prop['VATMode']}")
	private Integer VATMode;

	@Override
	public R addScheme(AdditionalFeeScheme additionalFeeScheme) {
		// 多线程冲突判断
		RedisLock lock = JedisUtils.getLock("laison_lock_" + Constant.ADDITONALFEE_SCHEME_CODE_TYPE);
		try {
			if (lock.lock()) {// 设置id
				additionalFeeScheme.setAdditionalFeeSchemeCode(IdGen.generateCode(Constant.PRICE_SCHEME_CODE_TYPE));
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
		R error = checkAndSetAdditionalFeeScheme(additionalFeeScheme);
		if (error != null) {
			return error;
		}
		// 保存detail
		List<AdditionalFeeDetail> additionalFeeDetails = additionalFeeScheme.getAdditionalFeeDetails();
		for (AdditionalFeeDetail additionalFeeDetail : additionalFeeDetails) {
			additionalFeeDetailMapper.insertSelective(additionalFeeDetail);
		}
		// 保存方案
		additionalFeeSchemeMapper.insertSelective(additionalFeeScheme);

		return R.ok("{add.ok}");
	}

	@Override
	public R updateScheme(AdditionalFeeScheme additionalFeeScheme) {
		
		
		AdditionalFeeScheme oldScheme = additionalFeeSchemeMapper.selectByPrimaryKey(additionalFeeScheme.getAdditionalFeeSchemeCode());
		if(oldScheme==null) {
			return R.error("{additionalFeeScheme.not.exist}");
		}
		// 保存方案
		additionalFeeSchemeMapper.updateByPrimaryKeySelective(additionalFeeScheme);
		R ok = R.ok("{update.ok}");
		
		return ok;
	}

	/**
	 * 
	 * @Title: checkAndSetAdditionalFeeScheme
	 * @Description: 检查和设置 additionalFeeDetails 清空一些不必要的参数，条件判断 VATMode == 0时，时，需要显示
	 *               VAT 参数。但是如果附加费的类型为 [还债]类型时，也隐藏VAT参数（债务无需扣税） VATMode == 1 或 == 2
	 *               时，配置附加费项目界面，隐藏VAT 参数。 d
	 * @param @param
	 *            additionalFeeScheme
	 * @return R
	 */
	private R checkAndSetAdditionalFeeScheme(AdditionalFeeScheme additionalFeeScheme) {

		List<AdditionalFeeDetail> additionalFeeDetails = additionalFeeScheme.getAdditionalFeeDetails();

		if (additionalFeeDetails != null && !additionalFeeDetails.isEmpty()) {// 如果数组不为空遍历数组
			for (int i = 0; i < additionalFeeDetails.size(); i++) {
				AdditionalFeeDetail additionalFeeDetail = additionalFeeDetails.get(i);
				additionalFeeDetail.setAdditionalFeeIndex((long) i + 1);// 设置index
				additionalFeeDetail.setAdditionalFeeSchemeCode(additionalFeeScheme.getAdditionalFeeSchemeCode());//设置code
				R error = checkAndSetAdditionalFeeDetail(additionalFeeDetail);
				if(error!=null) {
					return error;
				}
			}
		}
		return null;
	}
	/**
	 * 
	 * @Title: checkAndSetAdditionalFeeDetail 
	 * @Description:  
	 * @param additionalFeeDetail
	 * @return R
	 */
	private R checkAndSetAdditionalFeeDetail(AdditionalFeeDetail additionalFeeDetail) {
		return checkAndSetAdditionalFeeDetail(additionalFeeDetail,true);
	}
	/**
	 * 
	 * @Title: checkAndSetAdditionalFeeDetail 
	 * @Description: TODO   
	 * @param additionalFeeDetail
	 * @param isAdd 是否是添加 如果是 则需要检查feevat
	 * @return R
	 */
	private R checkAndSetAdditionalFeeDetail(AdditionalFeeDetail additionalFeeDetail,boolean isAdd) {
		Integer additionalFeeType = additionalFeeDetail.getAdditionalFeeType();
		if(isAdd) {//如果是添加 则需要检查feevat
			if (VATMode != 0||additionalFeeType.equals(Constant.DEBT_ADDITONAL_FEE_TYPE)) {
				additionalFeeDetail.setAdditionalFeeVat(null);
			}else {
				BigDecimal additionalFeeVat = additionalFeeDetail.getAdditionalFeeVat();
				if (additionalFeeVat == null) {
					return R.error("{additionalFee.vat.null}");
				}
			}
		}else{//如果是更新，可以为null使用原有值
			if (VATMode != 0||additionalFeeType.equals(Constant.DEBT_ADDITONAL_FEE_TYPE)) {
				additionalFeeDetail.setAdditionalFeeVat(null);
			}
		}
		
		
		// 不同扣费方式
		Integer additonalFeeDeductionMode = additionalFeeDetail.getAdditionalFeeDeductionMode();
		additionalFeeDetail.setPropToNull(additonalFeeDeductionMode);
		BigDecimal amount = additionalFeeDetail.getAdditionalFeeDeductionAmount();// 每次多少钱
		Integer times = additionalFeeDetail.getAdditionalFeeDeductionTimes();// 次数
		BigDecimal rate = additionalFeeDetail.getAdditionalFeeDeductionRate();// 比例
		BigDecimal unitPrice = additionalFeeDetail.getAdditionalFeeDeductionUnitPrice();// 按量扣费的单价
		switch (additonalFeeDeductionMode) {
		case 0: // 按百分比扣费
			if (rate == null) {
				return R.error("{additionalFee.rate.null}");
			}
			break;
		case 1: // 按次数扣费
			if (times == null) {
				return R.error("{additionalFee.times.null}");
			}
			if (amount == null) {
				return R.error("{additionalFee.amount.null}");
			}
			break;
		case 6: // 按上月使用量扣费
			if (unitPrice == null) {
				return R.error("{additionalFee.unitPrice.null}");
			}
			break;
		default:// 按天 、按月 、按年 、按固定金额扣费（每次都扣除）
			if (amount == null) {
				return R.error("{additionalFee.amount.null}");
			}
			break;

		}
		return null;
		
	}

	
	@Override
	public R findAll() {
		AdditionalFeeSchemeExample example = new AdditionalFeeSchemeExample();
		List<AdditionalFeeScheme> additionalFeeSchemes = additionalFeeSchemeMapper.selectByExample(example);
		R ok = R.ok();
		ok.putIfAbsent("additionalFeeSchemes", additionalFeeSchemes);
		return ok;
	}

	
	@Override
	public R delScheme(AdditionalFeeScheme additionalFeeScheme) {
		Long additionalFeeSchemeCode = additionalFeeScheme.getAdditionalFeeSchemeCode();
		int deleteCount = additionalFeeSchemeMapper.deleteByPrimaryKey(additionalFeeSchemeCode);//删除方案
		R ok = R.ok(Constant.DEL_OK);
		ok.put("deleteCount", deleteCount);
		if(deleteCount>0) {
			//删除附加费details
			AdditionalFeeDetailExample example=new AdditionalFeeDetailExample();
			Criteria criteria = example.createCriteria();
			criteria.andAdditionalFeeSchemeCodeEqualTo(additionalFeeSchemeCode);
			additionalFeeDetailMapper.deleteByExample(example);
			//根据 additionalFeeSchemeCode 删除用户对应的附加费 ###############待编码###################
		}
		return ok;
	}
	
	
	@Override
	public AdditionalFeeScheme findById(Long id) {
		return additionalFeeSchemeMapper.selectByPrimaryKey(id);
	}

	@Override
	public R updateDetail(AdditionalFeeDetail additionalFeeDetail) {
		Long index = additionalFeeDetail.getAdditionalFeeIndex();
		/*if(index==null) {
			return R.error("{additional.fee.index.null}");
		}*/
		Long additionalFeeSchemeCode = additionalFeeDetail.getAdditionalFeeSchemeCode();
		/*if(additionalFeeSchemeCode==null) {
			return R.error("{additional.fee.scheme.code.null}");
		}*/
		AdditionalFeeDetailKey key=new AdditionalFeeDetailKey();
		key.setAdditionalFeeIndex(index);
		key.setAdditionalFeeSchemeCode(additionalFeeSchemeCode);
		AdditionalFeeDetail oldDetail = additionalFeeDetailMapper.selectByPrimaryKey(key);
		if(oldDetail==null) {
			return R.error("{additional.fee.detail.not.exist}");
		}
		if(!oldDetail.getAdditionalFeeType().equals(additionalFeeDetail.getAdditionalFeeType())) {
			return R.error("{can.not.eidt,additionalFeeType}");
		}
		boolean isUsed=false;// 查找有没有被客户使用，################待编写代码###################
		
		if(isUsed) {//如果被使用了修改时，只能修改扣费金额、比例、次数；   把前端传过来的值设置到olddetail用olddetail去更新
			BigDecimal amount = additionalFeeDetail.getAdditionalFeeDeductionAmount();
			BigDecimal rate = additionalFeeDetail.getAdditionalFeeDeductionRate();
			Integer times = additionalFeeDetail.getAdditionalFeeDeductionTimes();
			if(amount!=null){//如果有修改金额
				oldDetail.setAdditionalFeeDeductionAmount(amount);
			}
			if(rate!=null) {//如果有修改比例
				oldDetail.setAdditionalFeeDeductionRate(rate);
			}
			if(times!=null) {//如果有修改次数
				oldDetail.setAdditionalFeeDeductionTimes(times);
			}
			additionalFeeDetailMapper.updateByPrimaryKeySelective(oldDetail);//保存更新
			//同时更新客户对应的detail 
			if(amount!=null||rate!=null) {//金额或者比例发生变化，需要同时更新客户对应的detail
				HashMap<String, Object> hashMap = new HashMap<String, Object>();
				hashMap.put("amount", amount);
				hashMap.put("rate", rate);
				//用hashMap去更新客户detail ################待编写代码###################
			}
		}else {//没有被使用  检查前端过来的数据直接用前端过来的更新，只更新不为null的字段
			additionalFeeDetail.setAdditionalFeeType(oldDetail.getAdditionalFeeType());//type不能修改
			
			R error = checkAndSetAdditionalFeeDetail(additionalFeeDetail,false);
			if(error!=null) {
				return error;
			}
			
			additionalFeeDetailMapper.updateByPrimaryKeySelective(additionalFeeDetail);//保存更新
		}
		
		return R.ok(Constant.UPDATE_OK);
	}

	@Override
	public R insertDetailToScheme(AdditionalFeeDetail additionalFeeDetail) {	
		Long additionalFeeSchemeCode = additionalFeeDetail.getAdditionalFeeSchemeCode();
		if(additionalFeeSchemeCode==null) {
			return R.error("{additional.fee.scheme.code.null}");
		}
		R error = checkAndSetAdditionalFeeDetail(additionalFeeDetail,false);
		if(error!=null) {
			return error;
		}
		//查出当前最大的index
		Long index=additionalFeeDetailMapper.selectSchemeLastIndex(additionalFeeSchemeCode);
		additionalFeeDetail.setAdditionalFeeIndex(index+1);
		additionalFeeDetailMapper.insertSelective(additionalFeeDetail);
		return R.ok(Constant.ADD_OK);
	}

	@Override
	public R delDetailFromScheme(AdditionalFeeDetail additionalFeeDetail) {
		Long index = additionalFeeDetail.getAdditionalFeeIndex();
		if(index==null) {
			return R.error("{additional.fee.index.null}");
		}
		Long additionalFeeSchemeCode = additionalFeeDetail.getAdditionalFeeSchemeCode();
		if(additionalFeeSchemeCode==null) {
			return R.error("{additional.fee.scheme.code.null}");
		}
		AdditionalFeeDetailKey key=new AdditionalFeeDetailKey();
		key.setAdditionalFeeIndex(index);
		key.setAdditionalFeeSchemeCode(additionalFeeSchemeCode);
		int count = additionalFeeDetailMapper.deleteByPrimaryKey(key);
		R ok = R.ok(Constant.DEL_OK);
		ok.put("deleteCount", count);
		return ok;
	}

	@Override
	public R listByPage(Query q) {
		PageHelper.startPage(q.getPage(), q.getLimit());
		AdditionalFeeSchemeExample example = new AdditionalFeeSchemeExample();
		List<AdditionalFeeScheme> list = additionalFeeSchemeMapper.selectByExample(example);
		PageInfo<AdditionalFeeScheme> pageInfo = new PageInfo<AdditionalFeeScheme>(list);
		R r = R.ok();
		r.put("pageInfo", pageInfo);
		return r;
	}

}
