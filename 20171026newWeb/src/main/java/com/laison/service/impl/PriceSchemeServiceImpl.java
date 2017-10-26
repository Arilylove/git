package com.laison.service.impl;

import java.util.Collection;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.laison.common.cache.lock.RedisLock;
import com.laison.common.enumerate.Constant;
import com.laison.common.utils.IdGen;
import com.laison.common.utils.JedisUtils;
import com.laison.common.utils.R;
import com.laison.entity.scheme.price.PriceScheme;
import com.laison.entity.scheme.price.PriceSchemeExample;
import com.laison.entity.scheme.price.detail.PriceSchemeDetail;
import com.laison.entity.scheme.price.detail.PriceSchemeDetailExample;
import com.laison.entity.scheme.price.detail.PriceSchemeDetailExample.Criteria;
import com.laison.entity.sysuser.SysUser;
import com.laison.mapper.scheme.price.PriceSchemeMapper;
import com.laison.mapper.scheme.price.detail.PriceSchemeDetailMapper;
import com.laison.service.PriceSchemeService;

@Service("priceSchemeService")
public class PriceSchemeServiceImpl implements PriceSchemeService {
	@Autowired
	PriceSchemeMapper priceSchemeMapper;
	@Autowired
	PriceSchemeDetailMapper priceSchemeDetailMapper;
	@Value(value = "#{prop['SingletonMode']}")
	private boolean singletonMode;// 是否为单段模式
	@Value(value = "#{prop['enable.min.consumed']}")
	private boolean enableMinConsumed;// 是否开启最低消费
	@Value(value = "#{prop['VATMode']}")
	private int vatMode;// 是否自动生成主键
	@Override
	public R findOne(PriceScheme priceScheme) {
		priceScheme = priceSchemeMapper.selectByPrimaryKey(priceScheme.getPriceSchemeCode());
		if(priceScheme==null) {
			return R.error("{price.scheme.not.exist}");
		}
		R ok = R.ok();
		ok.put("priceScheme", priceScheme);
		return ok;
	}
	@Override
	public R add(PriceScheme priceScheme) {
		RedisLock lock = JedisUtils.getLock("laison_lock_" + Constant.PRICE_SCHEME_CODE_TYPE);
		try {
			if (lock.lock()) {
				priceScheme.setPriceSchemeCode(IdGen.generateCode(Constant.PRICE_SCHEME_CODE_TYPE));
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
		R error = checkAndSetPriceScheme( priceScheme);
		if(error!=null) {
			return error;
		}
		priceSchemeMapper.insertSelective(priceScheme);
		List<PriceSchemeDetail> priceSchemeDetails = priceScheme.getPriceSchemeDetails();
		for (PriceSchemeDetail priceSchemeDetail : priceSchemeDetails) {
			priceSchemeDetailMapper.insertSelective(priceSchemeDetail);
		}
		return R.ok("{add.ok}");
	}

	@Override
	public R checkAndSetPriceScheme(PriceScheme priceScheme) {
		R error = null;
		// 是否单段模式
		List<PriceSchemeDetail> priceSchemeDetails = priceScheme.getPriceSchemeDetails();
		if(priceSchemeDetails!=null&&!priceSchemeDetails.isEmpty()) {//如果有priceSchemeDetails才去检查
			if (singletonMode) {
				error = checkAndSetSingletonDetail( priceScheme);
			}else {
				error = checkAndSetMultistageDetail( priceScheme);
			}
		}
		if (vatMode != 0) {
			priceScheme.setEnableVatFlag(true);//
			// Vat可以不传直接用数据库的默认值0.00
		} else {
			priceScheme.setEnableVatFlag(false);//
			priceScheme.setVat(null);// 用数据库了 默认的0.00
		}
		// 是否开启最低消费 else 不用写如果系统允许最低消费，由前端用户决定是否开启，相关值由前端上传为准
		if (!enableMinConsumed) {// 没启用
			priceScheme.setEnableMinConsumedFlag(false);
			priceScheme.setMouthMinConsumedAmount(null);
			priceScheme.setMouthMinConsumedQuantity(null);
		}

		return error;
	}

	/**
	 * 
	* @Title: checkAndSetSingletonDetail 
	* @Description: 检查并且设置单段模式下的priceSchemeDetails 
	* @param @param priceScheme
	* @param @return   
	* @return R
	 */
	public R checkAndSetSingletonDetail(PriceScheme priceScheme) {
		priceScheme.setSectionMode(1);//设置为单段模式
		List<PriceSchemeDetail> priceSchemeDetails = priceScheme.getPriceSchemeDetails();
		PriceSchemeDetail tempPriceSchemeDetail = null;
		for (int i = 0; i < priceSchemeDetails.size(); i++) {
			PriceSchemeDetail priceSchemeDetail = priceSchemeDetails.get(i);
			if(priceSchemeDetail.getEndValue()==null) {
				return R.error("{price.scheme.details.end.null}");
			}
			priceSchemeDetail.setPriceSchemeCode(priceScheme.getPriceSchemeCode());//设置id
			priceSchemeDetail.setStepIndex(i+1);//设置阶梯序号
			priceSchemeDetail.setStartValue(0);//每个阶梯起始值为0
			//检查阶梯值是否正确
			if(tempPriceSchemeDetail==null) {
				tempPriceSchemeDetail=priceSchemeDetail;
			}else {
				if(tempPriceSchemeDetail.getEndValue()>=priceSchemeDetail.getEndValue()) {
					return R.error("{price.scheme.details.end.order.error}");
				}
				tempPriceSchemeDetail=priceSchemeDetail;
			}
			if(i==priceSchemeDetails.size()-1) {// 最后一个阶梯
				priceSchemeDetail.setEndValue(999999999);
			}
		}
		
		return null;
		
	}
	/**
	 * 
	* @Title: checkAndSetMultistageDetail 
	* @Description: 检查并且设置多段模式下的priceSchemeDetails  
	* @param @param priceScheme
	* @param @return   
	* @return R
	 */
	public R checkAndSetMultistageDetail(PriceScheme priceScheme) {
		priceScheme.setSectionMode(0);//设置为多段模式
		List<PriceSchemeDetail> priceSchemeDetails = priceScheme.getPriceSchemeDetails();
		PriceSchemeDetail tempPriceSchemeDetail = null;
		for (int i = 0; i < priceSchemeDetails.size(); i++) {
			PriceSchemeDetail priceSchemeDetail = priceSchemeDetails.get(i);
			if(priceSchemeDetail==null||priceSchemeDetail.getStartValue()==null) {
				return R.error("{price.scheme.details.start.null}");
			}
			priceSchemeDetail.setPriceSchemeCode(priceScheme.getPriceSchemeCode());//设置id
			priceSchemeDetail.setStepIndex(i+1);//设置阶梯序号
			if(tempPriceSchemeDetail==null) {
				priceSchemeDetail.setStartValue(0);//第一个阶梯起始值为0
				tempPriceSchemeDetail=priceSchemeDetail;
			}else {
				if(priceSchemeDetail.getStartValue()<=tempPriceSchemeDetail.getStartValue()) {
					return R.error("{price.scheme.details.start.order.error}");
				}
				
				tempPriceSchemeDetail.setEndValue(priceSchemeDetail.getStartValue());//设置前一个阶梯的end值
				if(i==priceSchemeDetails.size()-1) {// 最后一个阶梯
					priceSchemeDetail.setEndValue(999999999);
					
				}
				tempPriceSchemeDetail=priceSchemeDetail;
			}
			
		}
		
		return null;
		
	}
	@Override
	public R update(PriceScheme priceScheme) {
		R error=null;
		error= canEdit(priceScheme);//检查是否可以更新
		if(error!=null) {//如果有错误直接返回
			return error;
		}
		error = checkAndSetPriceScheme(priceScheme);
		if(error!=null) {//如果有错误直接返回
			return error;
		}
		List<PriceSchemeDetail> priceSchemeDetails = priceScheme.getPriceSchemeDetails();
		if(priceSchemeDetails!=null&&!priceSchemeDetails.isEmpty()) {//如果更新了阶梯价格
			
			//删除原来的
			PriceSchemeDetailExample example=new PriceSchemeDetailExample();
			Criteria criteria = example.createCriteria();
			criteria.andPriceSchemeCodeEqualTo(priceScheme.getPriceSchemeCode());
			priceSchemeDetailMapper.deleteByExample(example);
			//保存现在的
			for (PriceSchemeDetail priceSchemeDetail : priceSchemeDetails) {
				priceSchemeDetailMapper.insertSelective(priceSchemeDetail);
			}
		}
		priceSchemeMapper.updateByPrimaryKeySelective(priceScheme);
		
		return R.ok("{update.ok}");
	}
	@Override
	public R findAll() {
		PriceSchemeExample example=new PriceSchemeExample();
		com.laison.entity.scheme.price.PriceSchemeExample.Criteria criteria = example.createCriteria();
		List<PriceScheme> priceSchemes = priceSchemeMapper.selectByExample(example);
		R ok = R.ok();
		ok.putIfAbsent("priceSchemes", priceSchemes);
		return ok;
	}
	@Override
	public R findAllUseful() {
		PriceSchemeExample example=new PriceSchemeExample();
		com.laison.entity.scheme.price.PriceSchemeExample.Criteria criteria = example.createCriteria();
		criteria.andStateNotEqualTo("0");
		List<PriceScheme> priceSchemes = priceSchemeMapper.selectByExample(example);
		R ok = R.ok();
		ok.putIfAbsent("priceSchemes", priceSchemes);
		return ok;
	}
	/**
	 * 
	* @Title: canEdit 
	* @Description: 检查是否可以编辑  不能则返回一个error
	* @param priceScheme
	* @return R error
	 */
	public R canEdit(PriceScheme priceScheme) {
		if(priceScheme.getPriceSchemeCode()==null) {
			return R.error("{price.scheme.code.null}");
		}
		PriceScheme oldPriceScheme = priceSchemeMapper.selectByPrimaryKey(priceScheme.getPriceSchemeCode());
		if(oldPriceScheme==null) {
			return R.error("{price.scheme.not.exist}");
		}
		SysUser loginUser = (SysUser) SecurityUtils.getSubject().getPrincipal();
		if(oldPriceScheme.getState().equals("2")&&!loginUser.getState().equals(2)) {//如果不是超级管理员 ，系统方案不可编辑
			return R.error("{system.scheme.cannot.edit}");
		}
		return null;
	}
	@Override
	public PriceScheme findById(Long id) {
		return priceSchemeMapper.selectByPrimaryKey(id);
	}
	
}
