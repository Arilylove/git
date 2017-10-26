package com.laison.common.log;

import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;

import com.laison.common.annotation.ID;
import com.laison.common.annotation.SysLogAnnotation;
import com.laison.common.enumerate.LogType;
import com.laison.common.utils.DateUtils;
import com.laison.common.utils.HttpUtils;
import com.laison.common.utils.JsonUtils;
import com.laison.entity.syslog.SysLog;
import com.laison.entity.sysuser.SysUser;
import com.laison.service.SysLogService;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 
 * @ClassName: SysLogAspect
 * @Description: aop级别日记记录
 * @author lihua
 * @date 2017年10月16日 上午9:24:31
 *
 */

public class SysLogAspect {
	@Autowired
	private SysLogService sysLogService;
	SysLog sysLog = new SysLog();
	Object service = null;
	Object id = null;

	@Pointcut("@annotation(com.laison.common.annotation.SysLogAnnotation)")
	public void logPointCut() {

	}


	public void before(JoinPoint joinPoint) {
		try {
			set(joinPoint);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}


	public void after(JoinPoint joinPoint) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();

		SysLogAnnotation syslog = method.getAnnotation(SysLogAnnotation.class);
		Class<? extends Object> serviceClass = service.getClass();
		if (serviceClass == null || id == null) {// before方法出异常了
			sysLog.setNewValue("{}");// before方法出异常了 newValue直接置空
		} else {
			Method afterMethod;
			try {
				afterMethod = serviceClass.getDeclaredMethod(syslog.afterMethod(), id.getClass());
				Object newValue = afterMethod.invoke(service, id);
				sysLog.setNewValue(JsonUtils.objectToJson(newValue));
			} catch (Exception e) {
				sysLog.setNewValue(e.getMessage());// after方法出异常了

			}
		}

		// 保存系统日志
		sysLogService.save(sysLog);
	}

	public void set(JoinPoint joinPoint) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		// 用户名
		SysUser loginUser = (SysUser) SecurityUtils.getSubject().getPrincipal();
		sysLog.setUser(loginUser.getLoginName());
		// 设置时间
		sysLog.setCreateDate(DateUtils.utcDate());
		// 获取request
		HttpServletRequest request = HttpUtils.getRequest();
		// 设置IP地址
		sysLog.setIp(HttpUtils.getIpAddr(request));
		//请求的方法名
		String className = joinPoint.getTarget().getClass().getName();
		String methodName = signature.getName();
		sysLog.setMethod(className + "." + methodName + "()");
		SysLogAnnotation syslog = method.getAnnotation(SysLogAnnotation.class);
		if (syslog != null) {
			// 注解上的描述
			sysLog.setOperationType(syslog.optType());
		}
		String optType = syslog.optType();
		Class<? extends Object> targetClass = joinPoint.getTarget().getClass();
		Field field;
		try {
			field = targetClass.getDeclaredField(syslog.filedName());
			field.setAccessible(true);
			service = field.get(joinPoint.getTarget());// 用这个去执行
			Object[] args = joinPoint.getArgs();
			Class<? extends Object> arg = args[0].getClass();
			Field[] declaredFields = arg.getDeclaredFields();
			for (Field temp : declaredFields) {
				temp.setAccessible(true);
				ID idAnnotation = temp.getAnnotation(ID.class);
				if (idAnnotation != null) {// 说明是主键
					id = temp.get(args[0]);
				}
			}
			Class<? extends Object> serviceClass = service.getClass();
			if(id != null) {
				Method beforeMethod = serviceClass.getDeclaredMethod(syslog.beforeMethod(), id.getClass());
				if (optType.equals(LogType.DELETE) || optType.equals(LogType.UPDATE)) {//删除或者更新前查找old值
					
					Object oldValue = beforeMethod.invoke(service, id);
					if(oldValue!=null) {
						sysLog.setOldValue(JsonUtils.objectToJson(oldValue));
					}else {
						sysLog.setOldValue("{}");
					}
				}else {//插入前old直接置为空
					sysLog.setOldValue("{}");
				}
			}else {//插入前old直接置为空
				sysLog.setOldValue("{}");
			}
		} catch (Exception e) {// 没有获取到 service 或者没有通过service查询到值
			sysLog.setOldValue(e.getMessage());
		}

	}
}
