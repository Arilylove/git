package com.laison.common.listener;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import org.springframework.web.context.WebApplicationContext;



public class WebContextListener extends org.springframework.web.context.ContextLoaderListener {
	
	@Override
	public WebApplicationContext initWebApplicationContext(ServletContext servletContext) {
		WebApplicationContext initWebApplicationContext = super.initWebApplicationContext(servletContext);//先初始化容器
		//加载配置
		return initWebApplicationContext;
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		//关闭资源adas
		super.contextDestroyed( event);
	}
}
