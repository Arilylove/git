package com.laison.controller.manage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.laison.common.annotation.SysLogAnnotation;
import com.laison.common.enumerate.LogType;
import com.laison.common.sql.Query;
import com.laison.common.utils.R;
import com.laison.common.validategroup.AddGroup;
import com.laison.common.validategroup.FindGroup;
import com.laison.common.validategroup.UpdateGroup;
import com.laison.entity.scheme.additionalfee.AdditionalFeeScheme;
import com.laison.entity.scheme.additionalfee.detail.AdditionalFeeDetail;
import com.laison.service.AdditionalFeeSchemeService;

@Controller
@RequestMapping(value = "/sys/additionalFeeScheme")
public class AdditionalFeeSchemeController {

	@Autowired
	AdditionalFeeSchemeService  additionalFeeSchemeService;
	
	@RequestMapping("/add")
	public @ResponseBody R addScheme(@Validated(value={AddGroup.class}) @RequestBody  AdditionalFeeScheme additionalFeeScheme)throws Exception{
			
			return additionalFeeSchemeService.addScheme(additionalFeeScheme);
	}
	@RequestMapping("/findAll")
	public @ResponseBody R findAll() {
		return additionalFeeSchemeService.findAll();
	}
	@RequestMapping("/listByPage")
	public @ResponseBody R listByPage(Query q) {
		return additionalFeeSchemeService.listByPage(q);
	}
	@RequestMapping("/delScheme")
	/*@RequiresPermissions("sys:additionalFeeScheme:del")*/
	@SysLogAnnotation(afterMethod = "findById", beforeMethod = "findById", filedName = "additionalFeeSchemeService", optType = LogType.DELETE)
	public @ResponseBody R delScheme(@Validated(value={FindGroup.class}) @RequestBody  AdditionalFeeScheme additionalFeeScheme)throws Exception {
		return additionalFeeSchemeService.delScheme(additionalFeeScheme);
	}
	@RequestMapping("/updateScheme")
	public @ResponseBody R updateScheme(@Validated(value={UpdateGroup.class}) @RequestBody  AdditionalFeeScheme additionalFeeScheme)throws Exception {
		return additionalFeeSchemeService.updateScheme(additionalFeeScheme);
	}
	@RequestMapping("/updateDetail")
	public @ResponseBody R updateDetail(@Validated(value={UpdateGroup.class}) @RequestBody  AdditionalFeeDetail additionalFeeDetail)throws Exception {
		return additionalFeeSchemeService.updateDetail(additionalFeeDetail);
	}
	@RequestMapping("/insertDetailToScheme")
	public @ResponseBody R insertDetailToScheme(@Validated(value={AddGroup.class}) @RequestBody  AdditionalFeeDetail additionalFeeDetail)throws Exception {
		return additionalFeeSchemeService.insertDetailToScheme(additionalFeeDetail);
	}
	@RequestMapping("/delDetailFromScheme")
	public @ResponseBody R delDetailFromScheme(@Validated(value={FindGroup.class}) @RequestBody  AdditionalFeeDetail additionalFeeDetail)throws Exception {
		return additionalFeeSchemeService.delDetailFromScheme(additionalFeeDetail);
	}
}
