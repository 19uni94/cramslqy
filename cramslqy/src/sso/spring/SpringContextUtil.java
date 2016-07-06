package sso.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 類說明:spring 應用 單例
 * @author Ken
 * @version 創建時間2016-01-25
 */
public class SpringContextUtil {
	private static ApplicationContext context;
	public static ApplicationContext getApplicationContext() {
		if (context == null) {
			//通配符
			context = new ClassPathXmlApplicationContext("classpath:/config/spring/*Context.xml");
		}
		return context;
	}

	public static void setApplicationContext(ApplicationContext outcontext) {
		context = outcontext;
	}

}
