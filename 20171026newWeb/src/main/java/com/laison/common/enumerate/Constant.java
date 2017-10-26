package com.laison.common.enumerate;

import java.util.TimeZone;

import org.springframework.web.bind.MissingServletRequestParameterException;

public class Constant {
	/**
	 * 系统编号  10代表开发系统 从10开始  只能是2位数
	 */
	public static final int SYSTEM_NUMBER=10;
	/**
	 * 系统用户的codeType= 10
	 */
	public static final int SYS_USER_CODE_TYPE=10;
	/**
	 * RegionCode的类型 
	 */
	public static final int REGION_CODE_TYPE=11;
	public static final int COMPANY_CODE_TYPE=12;
	public static final int STATION_CODE_TYPE=13;
	/**
	 * 表记类型代码类型
	 */
	public static final int METER_TYPE_CODE_TYPE=14;
	/**
	 * 客户类型代码类型
	 */
	public static final int CUSTOMER_TYPE_CODE_TYPE=15;
	/**
	 * 友好时段方案代码类型
	 */
	public static final int FRIENDLY_PERIOD_SCHEME_CODE_TYPE=16;
	/**
	 * 节假日方案代码类型
	 */
	public static final int HOLIDAY_SCHEME_CODE_TYPE=17;
	public static final int PRICE_SCHEME_CODE_TYPE=18;
	public static final int ADDITONALFEE_SCHEME_CODE_TYPE=19;
	/** 超级管理员 state=2 */
	public static final int SUPER_ADMIN = 2;
	public static final String ZH_CN="zh_CN";
	public static final String EN_US="en_US";
	/**
	 * 项目所在地时区
	 */
	public static final TimeZone TZ = TimeZone.getTimeZone("America/Los_Angeles");
	/**
	 * 管理员角色   state 1
	 */
	public static final String ADMIN_ROLE="1";
	/**
	 * 操作员角色   state 2
	 */
	public static final String OPERATOR_ROLE="2";
	/**
	 * 管理员用户   state 1
	 */
	public static final int ADMIN_USER_TYPE=1;
	/**
	 * 业务员用户   state 2
	 */
	public static final int OPERATOR_USER_TYPE=2;
	
	/**
	 * 债务类型的附加费 
	 */
	public static final int DEBT_ADDITONAL_FEE_TYPE=1;
	/**
	 * user密码正则表达式
	 */
	public static final String PASSWORD_REGEXP="^([A-Z]|[a-z]|[0-9]|[`~!@#$%^&*()+=|{}':;',\\\\[\\\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“'。，、？]){5,20}$";
	/**
	 * 未知异常
	 */
	public final static String UNKNOWN_ERROR="{unknown.error}";
	/**
	 * 数据库中已存在该记录！
	 */
	public final static String DUPLICATEKEY_EXCEPTION="{DuplicateKeyException}";
	/**
	 * 没有权限，请联系管理员授权!
	 */
	public final static String AUTHORIZATION_EXCEPTION="{AuthorizationException}";
	/**
	 * 缺少参数
	 */
	public final static String MISSING_SERVLET_REQUEST_PARAMETER_EXCEPTION="{MissingServletRequestParameterException}";
	/**
	 * 请不要提交无关参数！
	 */
	public final static String HTTP_MESSAGE_NOT_READABLE_EXCEPTION="{HttpMessageNotReadableException}";
	/**
	 * 加密出错！
	 */
	public final static String ENCRYPTION_ERROR="{encryption.error}";
	/**
	 * 菜单不存在
	 */
	public final static String MENU_NOT_EXIST="{menu.not.exist}";
	/**
	 * 菜单正在使用无法删除
	 */
	public final static String MENU_CANNOT_DEL="{menu.cannot.del}";

	/**
	 * 插入成功
	 */
	public final static String ADD_OK="{add.ok}";
	/**
	 * 删除成功
	 */
	public final static String DEL_OK="{del.ok}";
	/**
	 * 更新成功
	 */
	public final static String UPDATE_OK="{update.ok}";
	public final static String DEFAULT_PASSWORD="123456";
	
	//######################Code 常量##########################
	public static final int NO_LOGIN_CODE=501;
	public static final String SUPERROLE = "超级管理员";
	/**
	 * 系统状态 ‘2’
	 */
	public static final String SYSTEM_STATE = "2";

}
