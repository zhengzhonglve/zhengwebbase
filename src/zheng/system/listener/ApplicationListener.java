package zheng.system.listener;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class ApplicationListener extends ContextLoaderListener implements
		ServletContextListener, ServletRequestListener {

	@SuppressWarnings("unused")
	private static Log log = LogFactory.getLog(ApplicationListener.class);
	private ServletContext context;
	private WebApplicationContext webApplicationContext;
	

	public void contextDestroyed(ServletContextEvent sce) {
	}

	/**
	 * 服务器启动时加载,初始化一些信息
	 */

	@SuppressWarnings("unchecked")
	public void contextInitialized(ServletContextEvent sce) {
		this.context = sce.getServletContext();
		this.webApplicationContext = WebApplicationContextUtils
				.getRequiredWebApplicationContext(context);
		Map<String, Object> feeApplicationMap = new HashMap<String, Object>();

		log.info("------------------监听器ApplicationListener开始------------------");
		log.info("------------------监听器ApplicationListener结束------------------");
		
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		String appContext = sre.getServletContext().getContextPath();
		String url = sre.getServletRequest().getScheme() + "://"
				+ sre.getServletRequest().getServerName() + ":"
				+ sre.getServletRequest().getServerPort() + appContext;
		String basePath = System.getProperty("web.root");
		// 设置webroot路径
		if (basePath == null) {
			System.setProperty("web.root", url);
		}
	}

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		String appContext = sre.getServletContext().getContextPath();
		String url = sre.getServletRequest().getScheme() + "://"
				+ sre.getServletRequest().getServerName() + ":"
				+ sre.getServletRequest().getServerPort() + appContext;
		String basePath = System.getProperty("web.root");
		// 设置webroot路径
		if (basePath == null) {
			System.setProperty("web.root", url);
		}
	}

}
