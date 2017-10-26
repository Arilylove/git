package com.laison.common.shiro.session;
import java.util.Collection;

import org.apache.shiro.session.Session;

/**
 * 
* @ClassName: SessionDAO 
* @Description: 直接扩展org.apache.shiro.session.mgt.eis.SessionDAO接口  没有添加额外方法，方便以后扩展
* @author lihua
* @date 2017年9月15日 上午10:45:58 
*
 */
public interface SessionDAO extends org.apache.shiro.session.mgt.eis.SessionDAO {

	/**
	 * 获取活动会话
	 * @param includeLeave 是否包括离线（最后访问时间大于3分钟为离线会话）
	 * @return
	 */
	//public Collection<Session> getActiveSessions(boolean includeLeave);
	
	/**
	 * 获取活动会话
	 * @param includeLeave 是否包括离线（最后访问时间大于3分钟为离线会话）
	 * @param principal 根据登录者对象获取活动会话
	 * @param filterSession 不为空，则过滤掉（不包含）这个会话。
	 * @return
	 */
	//public Collection<Session> getActiveSessions(boolean includeLeave, Object principal, Session filterSession);
	
}
