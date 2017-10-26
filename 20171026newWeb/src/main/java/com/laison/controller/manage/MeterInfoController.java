package com.laison.controller.manage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.laison.common.utils.R;
import com.laison.common.validategroup.AddGroup;
import com.laison.common.validategroup.FindGroup;
import com.laison.common.validategroup.UpdateGroup;
import com.laison.common.web.BaseController;
import com.laison.entity.meterinfo.MeterInfo;
import com.laison.entity.sysmenu.SysMenu;
import com.laison.service.MeterInfoService;

@Controller
@RequestMapping(value = "/sys/meterinfo")
public class MeterInfoController extends BaseController{

	@Autowired
	MeterInfoService meterInfoService;
	
	@RequestMapping("/add")
	public @ResponseBody R addMeter(@Validated(value={AddGroup.class}) @RequestBody MeterInfo meterInfo)throws Exception {
		
		return meterInfoService.addMeter(meterInfo);
		
	}
	@RequestMapping("/update")
	public @ResponseBody R update(@Validated(value={UpdateGroup.class}) @RequestBody  MeterInfo meterInfo)throws Exception{
		
		R r=meterInfoService.updateMeter(meterInfo);
		return r;
	}
	@RequestMapping("/findAll")
	public @ResponseBody R findAll()throws Exception {
		return meterInfoService.findAll();		
	}
	@RequestMapping("/findId")
	public @ResponseBody R findById(@RequestParam(required=true)Long id) throws Exception{
		R r = meterInfoService.findMeterById(id);
		return r;
	}
	@RequestMapping("/findMeter")
	public @ResponseBody R findByMeter(@Validated(value={FindGroup.class}) @RequestBody  MeterInfo meterInfo) throws Exception{
		R r = meterInfoService.findMeterByInfo(meterInfo);
		return r;
	}
	
}
