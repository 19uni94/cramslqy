package sso.spring;

import javax.servlet.ServletContextEvent;

import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * 類說明:spring監聽子類
 * @author Ken
 * @version 創建時間2016-01-25
 */
public class SpringContextLoaderListener extends ContextLoaderListener{

	public void contextInitialized(ServletContextEvent event){
		super.contextInitialized(event);
		SpringContextUtil.setApplicationContext(WebApplicationContextUtils.getWebApplicationContext(event.getServletContext()));
	}
}
