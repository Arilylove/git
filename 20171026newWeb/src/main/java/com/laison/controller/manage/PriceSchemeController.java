package com.laison.controller.manage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.laison.common.annotation.SysLogAnnotation;
import com.laison.common.enumerate.LogType;
import com.laison.common.utils.R;
import com.laison.common.validategroup.AddGroup;
import com.laison.common.validategroup.FindGroup;
import com.laison.common.validategroup.UpdateGroup;
import com.laison.entity.metertype.MeterType;
import com.laison.entity.scheme.price.PriceScheme;
import com.laison.service.PriceSchemeService;

@Controller
@RequestMapping(value = "/sys/priceScheme")
public class PriceSchemeController {
	@Autowired
	PriceSchemeService priceSchemeService;
	@RequestMapping("/add")
	public @ResponseBody R addPriceScheme(@Validated(value={AddGroup.class}) @RequestBody  PriceScheme priceScheme)throws Exception{
		return priceSchemeService.add(priceScheme);
	}
	
	@RequestMapping("/findOne")
	public @ResponseBody R findOnePriceScheme(@Validated(value={FindGroup.class}) @RequestBody  PriceScheme priceScheme)throws Exception{
		return priceSchemeService.findOne(priceScheme);
	}
	@RequestMapping("/findAll")
	public @ResponseBody R findAllPriceScheme()throws Exception{
		return priceSchemeService.findAll();
	}
	@RequestMapping("/findAllUseful")
	public @ResponseBody R findAllUsefulPriceScheme()throws Exception{
		return priceSchemeService.findAllUseful();
	}
	@RequestMapping("/update")
	@SysLogAnnotation(afterMethod = "findById", beforeMethod = "findById", filedName = "priceSchemeService", optType = LogType.UPDATE)
	public @ResponseBody R updatePriceScheme(@Validated(value={UpdateGroup.class}) @RequestBody  PriceScheme priceScheme)throws Exception{
		return priceSchemeService.update(priceScheme);
	}
}
