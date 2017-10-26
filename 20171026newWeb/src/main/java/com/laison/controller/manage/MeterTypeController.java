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
import com.laison.entity.metertype.MeterType;
import com.laison.service.MeterTypeService;

@Controller
@RequestMapping(value = "/sys/meterType")
public class MeterTypeController {
	@Autowired
	MeterTypeService meterTypeService;
	@RequestMapping("/add")
	public @ResponseBody R addMeterType(@Validated(value={AddGroup.class}) @RequestBody  MeterType meterType)throws Exception{
		return meterTypeService.add(meterType);
	}
	@RequestMapping("/del")
	public @ResponseBody R delMeterType(@Validated(value={FindGroup.class}) @RequestBody  MeterType meterType)throws Exception{
		return meterTypeService.del(meterType);
	}
	@RequestMapping("/update")
	public @ResponseBody R updateMeterType(@Validated(value={UpdateGroup.class}) @RequestBody  MeterType meterType)throws Exception{
		return meterTypeService.update(meterType);
	}
	@RequestMapping("/findOne")
	public @ResponseBody R findOneMeterType(@Validated(value={FindGroup.class}) @RequestBody  MeterType meterType)throws Exception{
		return meterTypeService.findOne(meterType);
	}
	
	@RequestMapping("/findAll")
	public @ResponseBody R findAllMeterType()throws Exception{
		return meterTypeService.findAll();
	}
}
