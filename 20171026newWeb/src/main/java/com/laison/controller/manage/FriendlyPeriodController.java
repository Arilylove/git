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
import com.laison.entity.scheme.friendlyperiod.FriendlyPeriodScheme;
import com.laison.service.FriendlyPeriodService;

@Controller
@RequestMapping(value = "/sys/friendlyPeriod")
public class FriendlyPeriodController {
	@Autowired
	FriendlyPeriodService friendlyPeriodService;
	@RequestMapping("/add")
	public @ResponseBody R add(@Validated(value={AddGroup.class}) @RequestBody  FriendlyPeriodScheme friendlyPeriodScheme)throws Exception{
		R r=friendlyPeriodService.add(friendlyPeriodScheme);
		return r;
	}
	@RequestMapping("/del")
	public @ResponseBody R del(@Validated(value={FindGroup.class}) @RequestBody  FriendlyPeriodScheme friendlyPeriodScheme)throws Exception{
		R r=friendlyPeriodService.del(friendlyPeriodScheme);
		return r;
	}
	@RequestMapping("/findOne")
	public @ResponseBody R findOne(@Validated(value={FindGroup.class}) @RequestBody  FriendlyPeriodScheme friendlyPeriodScheme)throws Exception{
		R r=friendlyPeriodService.findOne(friendlyPeriodScheme);
		return r;
	}
	@RequestMapping("/findAll")
	public @ResponseBody R findAll(@Validated(value={AddGroup.class}) @RequestBody  FriendlyPeriodScheme friendlyPeriodScheme)throws Exception{
		R r=friendlyPeriodService.findAll(friendlyPeriodScheme);
		return r;
	}
}
