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
import com.laison.entity.customertype.CustomerType;
import com.laison.service.CustomerTypeService;

@Controller
@RequestMapping(value = "/sys/customerType")
public class CustomerTypeController {
	@Autowired
	CustomerTypeService customerTypeService;
	
	@RequestMapping("/addCustomerType")
	public @ResponseBody R addCustomerType(@Validated(value={AddGroup.class}) @RequestBody  CustomerType customerType)throws Exception{
		R r=customerTypeService.addCustomerType(customerType);
		return r;
	}
	@RequestMapping("/delCustomerType")
	public @ResponseBody R delCustomerType(@Validated(value={FindGroup.class}) @RequestBody  CustomerType customerType)throws Exception{
		R r=customerTypeService.delCustomerType(customerType);
		return r;
	}
	@RequestMapping("/findOne")
	public @ResponseBody R findCustomerType(@Validated(value={FindGroup.class}) @RequestBody  CustomerType customerType)throws Exception{
		R r=customerTypeService.findOne(customerType);
		return r;
	}
	@RequestMapping("/findAll")
	public @ResponseBody R findAll()throws Exception{
		R r=customerTypeService.findAll();
		return r;
	}
	@RequestMapping("/findUseful")
	public @ResponseBody R findUseful()throws Exception{
		R r=customerTypeService.findUseful();
		return r;
	}
}
