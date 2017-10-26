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
import com.laison.entity.regioninfo.RegionInfo;
import com.laison.entity.regioninfo.RegionInfoExample;
import com.laison.entity.regioninfo.RegionInfoExample.Criteria;
import com.laison.mapper.regioninfo.RegionInfoMapper;
import com.laison.service.RegionInfoService;

@Service("regionInfoService")
public class RegionInfoServiceImpl implements RegionInfoService {
	@Autowired
	RegionInfoMapper regionInfoMapper;
	@Value(value = "#{prop['auto.generate.region.code']}")
	private boolean autoGenerateCode;//是否自动生成主键
	
	@Override
	public RegionInfo find(Long regionCode) {
		return regionInfoMapper.selectByPrimaryKey(regionCode);
	}

	@Override
	public R add(RegionInfo regionInfo ) {
		if(!autoGenerateCode){
			if(regionInfo.getRegionCode()==null) {//如果主键不是自动生成并且code前端没有给
				return R.error("{regionCode.null}");
			}	
			
		}else{
			RedisLock lock = JedisUtils.getLock("laison_lock_"+Constant.REGION_CODE_TYPE);
			try {
	            if(lock.lock()) {
	            	regionInfo.setRegionCode(IdGen.generateCode(Constant.REGION_CODE_TYPE));
	            }
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }finally {
	            lock.unlock();
	        }
		}
		Long parentRegionId = regionInfo.getParentRegionId();
		if(parentRegionId==null||parentRegionId==0l){
			regionInfo.setParentRegionId(0l);
			regionInfo.setRegionType(1);
			regionInfo.setPaths("0,");
		}else{
			String pPaths = regionInfoMapper.getRegionPaths(parentRegionId);
			Integer pType = regionInfoMapper.getRegionType(parentRegionId);
			regionInfo.setRegionType(pType+1);
			regionInfo.setPaths(pPaths+parentRegionId+",");
		}
		regionInfoMapper.insert(regionInfo);
		return R.ok("{add.ok}");

	}

	@Override
	public R delRegion(Long regionCode) {
		
		//查询下面是否由子节点
		RegionInfoExample example=new RegionInfoExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andParentRegionIdEqualTo(regionCode);
		int count = regionInfoMapper.countByExample(example);
		if(count>0) {
			return R.error("{target.is.used}");
		}
		//查询是不是被 公司在使用
		//查询是不是再被站点使用
		
		regionInfoMapper.deleteByPrimaryKey(regionCode);
		return R.ok("{del.ok}");
	}

	@Override
	public R updateRegion(RegionInfo regionInfo) {
		
		RegionInfo oldRegion = regionInfoMapper.selectByPrimaryKey(regionInfo.getRegionCode());
		if(oldRegion==null) {
			return R.error("{region.not.exist}");
		}
		Long parentRegionId = regionInfo.getParentRegionId();
		if(parentRegionId==null) {//如果没有移动
			RegionInfoExample example =new RegionInfoExample();
			Criteria createCriteria = example.createCriteria();
			createCriteria.andRegionCodeEqualTo(regionInfo.getRegionCode());
			regionInfo.setRegionType(null);//不许改变区域类型，区域类型由上一级区域决定
			regionInfo.setPaths(null);//不许更改paths 这个也是计算出来的
			regionInfoMapper.updateByExampleSelective(regionInfo, example );
			return R.ok("{update.ok}");
		}
		RegionInfo  parentRegion= regionInfoMapper.selectByPrimaryKey(parentRegionId);
		if(parentRegion==null) {
			return R.error("{pregion.not.exist}");
		}
		if(parentRegionId!=oldRegion.getRegionCode()) {//如果移动了设置新的paths
			regionInfo.setPaths(parentRegion.getPaths()+parentRegionId+",");//设置paths
		}
		
		if(regionInfo.getPaths()!=null&&!regionInfo.getPaths().equals(oldRegion.getPaths())) {//如果paths被改变说明被移动了，要带孩子节点一起移动，孩子节点的type属性也要变
			regionInfo.setRegionType(parentRegion.getRegionType()+1);//设置类型
			regionInfoMapper.updateByPrimaryKeySelective(regionInfo);
			List<RegionInfo> childRegions = oldRegion.getChildRegions();
			if(childRegions!=null&&childRegions.size()>0) {
				for (RegionInfo tempRegion : childRegions) {
					tempRegion.setPaths(regionInfo.getPaths()+regionInfo.getRegionCode()+",");
					updateRegion(tempRegion);
				}
			}
		}
		
		//改变了位置
		return R.ok("{update.ok}");
	}
}
