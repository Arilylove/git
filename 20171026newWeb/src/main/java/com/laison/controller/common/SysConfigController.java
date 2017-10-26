package com.laison.controller.common;

import java.util.HashMap;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.laison.common.utils.R;
import com.laison.entity.sysuser.SysUser;

@Controller
public class SysConfigController {
	@Value(value = "#{prop['auto.generate.company.code']}")
	private boolean autoGenerateCompanyCode;// 是否自动生成公司代码
	@Value(value = "#{prop['auto.generate.station.code']}")
	private boolean autoGenerateStationCode;//是否自动生成站点代码
	@Value(value = "#{prop['auto.generate.metertype.code']}")
	private boolean autoGenerateMetertypeCode;// 是否自动生成表记类型代码
	@Value(value = "#{prop['auto.generate.region.code']}")
	private boolean autoGenerateRegionCode;// 是否自动生成区域代码
	@Value(value = "#{prop['auto.generate.friendly.period.code']}")
	private boolean autoGenerateFriendlyPeriodCode;// 是否自动生成友好时段方案代码
	@Value(value = "#{prop['auto.generate.customertype.code']}")
	private boolean autoGenerateCustomerTypeCode;// 是否自动生成客户类型代码
	@Value(value = "#{prop['auto.generate.customer.code']}")
	private boolean autoGenerateCustomerCode;// 是否自动生成客户编号代码
	@Value(value = "#{prop['enable.additional.fee']}")
	private boolean enableAdditionalFee;// 是否开启附加费功能
	@Value(value = "#{prop['enable.debt']}")
	private boolean enableDebt;// 是否开启债务功能
	@Value(value = "#{prop['enable.holiday']}")
	private boolean enableHoliday;// 是否开启节假日功能
	@Value(value = "#{prop['enable.min.consumed']}")
	private boolean enableMinConsumed;// 是否开启最小消费
	@Value(value = "#{prop['SingletonMode']}")
	private boolean singletonMode;// 是否为单阶梯模式
	@Value(value = "#{prop['VATMode']}")
	private Integer VATMode;
	@Value(value = "#{prop['measureMode']}")
	private Integer measureMode;//计量模式
	@RequestMapping("/getSysConfig")
	public @ResponseBody R getSysConfig() throws Exception {
		R ok = R.ok();
		HashMap<String, Object> sysConfig = new HashMap<>();
		sysConfig.put("autoGenerateCompanyCode", autoGenerateCompanyCode);
		sysConfig.put("autoGenerateStationCode", autoGenerateStationCode);
		sysConfig.put("autoGenerateRegionCode", autoGenerateRegionCode);
		sysConfig.put("autoGenerateFriendlyPeriodCode", autoGenerateFriendlyPeriodCode);
		sysConfig.put("autoGenerateCustomerTypeCode", autoGenerateCustomerTypeCode);
		sysConfig.put("autoGenerateCustomerCode", autoGenerateCustomerCode);
		sysConfig.put("enableAdditionalFee", enableAdditionalFee);
		sysConfig.put("enableDebt", enableDebt);
		sysConfig.put("enableHoliday", enableHoliday);
		sysConfig.put("enableMinConsumed", enableMinConsumed);
		sysConfig.put("singletonMode", singletonMode);
		sysConfig.put("VATMode", VATMode);
		sysConfig.put("measureMode", measureMode);
		ok.put("sysConfig", sysConfig);
		return ok;
	}
}
