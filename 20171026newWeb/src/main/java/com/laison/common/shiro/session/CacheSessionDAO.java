package com.laison.common.shiro.session;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;





/**
 * 系统安全认证实现类
 * @author ThinkGem
 * @version 2014-7-24
 */
public class CacheSessionDAO extends EnterpriseCacheSessionDAO implements SessionDAO {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
    public CacheSessionDAO() {
        super();
    }

	

    
	
	
}
