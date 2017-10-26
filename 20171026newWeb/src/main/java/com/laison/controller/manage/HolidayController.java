package com.laison.controller.manage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.laison.common.utils.R;
import com.laison.common.validategroup.AddGroup;
import com.laison.common.validategroup.FindGroup;
import com.laison.entity.scheme.holiday.HolidayScheme;
import com.laison.entity.sysmenu.SysMenu;
import com.laison.service.HolidayService;

@Controller
@RequestMapping(value = "/sys/holiday")
public class HolidayController {
	@Autowired
	HolidayService holidayService;
	@RequestMapping("/add")
	public @ResponseBody R add(@Validated(value={AddGroup.class}) @RequestBody  HolidayScheme holidayScheme)throws Exception{
		
		R r=holidayService.add(holidayScheme);
		return r;
	}
	@RequestMapping("/findOne")
	public @ResponseBody R findOne(@Validated(value={FindGroup.class}) @RequestBody  HolidayScheme holidayScheme)throws Exception{
		
		R r=holidayService.findOne(holidayScheme);
		return r;
	}
	@RequestMapping("/del")
	public @ResponseBody R del(@Validated(value={FindGroup.class}) @RequestBody  HolidayScheme holidayScheme)throws Exception{
		
		R r=holidayService.del(holidayScheme);
		return r;
	}
	@RequestMapping("/updateOne")
	public @ResponseBody R uddateOne(@Validated(value={FindGroup.class}) @RequestBody  HolidayScheme holidayScheme)throws Exception{
		
		R r=holidayService.updateOne(holidayScheme);
		return r;
	}
	@RequestMapping("/findAll")
	public @ResponseBody R findAll()throws Exception{
		R r=holidayService.findAll();
		return r;
	}
}
