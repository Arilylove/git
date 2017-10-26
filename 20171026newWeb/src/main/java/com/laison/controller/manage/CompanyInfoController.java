package com.laison.controller.manage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.laison.common.utils.R;
import com.laison.common.validategroup.AddGroup;
import com.laison.common.validategroup.FindGroup;
import com.laison.common.validategroup.UpdateGroup;
import com.laison.entity.companyinfo.CompanyInfo;
import com.laison.entity.stationinfo.StationInfo;
import com.laison.service.CompanyInfoService;

@Controller
@RequestMapping(value = "/sys/company")
public class CompanyInfoController {
	@Autowired
	CompanyInfoService companyInfoService;
	//请求key/value响应json
	@RequestMapping("/addCompany")
	public @ResponseBody R addCompany(@Validated(value={AddGroup.class}) @RequestBody  CompanyInfo company)throws Exception{
		
		//R r=sysMenuService.addMenu(menu);
		R r=companyInfoService.addCompany(company);
		return r;
	}
	@RequestMapping("/findCompany")
	public @ResponseBody R findCompany(@RequestBody  CompanyInfo company  )throws Exception{
		
		//R r=sysMenuService.addMenu(menu);
		R r=companyInfoService.findCompany(company);
		return r;
	}
	@RequestMapping("/delCompany")
	public @ResponseBody R delCompany(@Validated(value={FindGroup.class}) @RequestBody  CompanyInfo company)throws Exception{
		
		//R r=sysMenuService.addMenu(menu);
		R r=companyInfoService.delCompany(company);
		return r;
	}
	
	@RequestMapping("/updateCompany")
	public @ResponseBody R updateCompany(@Validated(value={UpdateGroup.class}) @RequestBody  CompanyInfo company)throws Exception{
		
		//R r=sysMenuService.addMenu(menu);
		R r=companyInfoService.updateCompany(company);
		return r;
	}
	@RequestMapping("/addStation")
	public @ResponseBody R addStation(@Validated(value={AddGroup.class}) @RequestBody  StationInfo station)throws Exception{
		
		//R r=sysMenuService.addMenu(menu);
		R r=companyInfoService.addStation(station);
		return r;
	}
	
	@RequestMapping("/delStation")
	public @ResponseBody R delStation(@Validated(value={FindGroup.class}) @RequestBody  StationInfo station)throws Exception{
		
		//R r=sysMenuService.addMenu(menu);
		R r=companyInfoService.delStation(station);
		return r;
	}
	@RequestMapping("/updateStation")
	public @ResponseBody R updateStation(@Validated(value={UpdateGroup.class}) @RequestBody  StationInfo station)throws Exception{
		
		//R r=sysMenuService.addMenu(menu);
		R r=companyInfoService.updateStation(station);
		return r;
	}
}
