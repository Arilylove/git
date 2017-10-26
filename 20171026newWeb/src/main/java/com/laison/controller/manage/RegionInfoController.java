package com.laison.controller.manage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.laison.common.utils.PropertiesUtils;
import com.laison.common.utils.R;
import com.laison.common.validategroup.AddGroup;
import com.laison.common.validategroup.FindGroup;
import com.laison.common.validategroup.UpdateGroup;
import com.laison.entity.regioninfo.RegionInfo;
import com.laison.service.RegionInfoService;

@Controller
@RequestMapping(value = "/sys/region")
public class RegionInfoController {
	@Autowired
	RegionInfoService regionInfoService;
	@RequestMapping("/findRegion")
	public @ResponseBody R findRegion(@RequestParam(defaultValue="0") Long regionCode )throws Exception{
		RegionInfo Region=regionInfoService.find(regionCode);
		R ok = R.ok();
		ok.put("Region", Region);
		return ok;
	}
	
	@RequestMapping("/addRegion")
	public @ResponseBody R add(@Validated(value={AddGroup.class}) @RequestBody RegionInfo regionInfo)throws Exception{
		R r=regionInfoService.add(regionInfo);
		
		return r;
	}
	@RequestMapping("/delRegion")
	public @ResponseBody R del(@Validated(value={FindGroup.class}) @RequestBody RegionInfo regionInfo)throws Exception{
		R r=regionInfoService.delRegion(regionInfo.getRegionCode());
		return r;
	}
	
	@RequestMapping("/updateRegion")
	public @ResponseBody R update(@Validated(value={UpdateGroup.class}) @RequestBody RegionInfo regionInfo)throws Exception{
		R r=regionInfoService.updateRegion(regionInfo);
		return r;
	}
}
