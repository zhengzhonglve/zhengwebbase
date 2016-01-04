package zheng.interceptor;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import zheng.entity.User;
import zheng.util.Convert;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * 
 * @author zheng
 *
 */
public class FrontUserSeesionInterceptor implements Interceptor {
	public static Log log = LogFactory
			.getLog(FrontUserSeesionInterceptor.class);
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private HttpSession session;

	@Override
	public void destroy() {
	}

	@Override
	public void init() {
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		request = ServletActionContext.getRequest();
		response = ServletActionContext.getResponse();
		session = request.getSession();
		String retUrl = request.getHeader("Referer");
		log.info("-------------------" + retUrl);
		log.info(request.getRequestURL());
		int index = request.getContextPath().length() + 1;
		String uri = request.getRequestURI().substring(index);
		if (isAjaxRequest()) {
			session.setAttribute("afterLoginUrl", retUrl);
			return ajaxIntercept(invocation);
		}
		return _intercept(invocation);
	}

	// 普通请求拦截 没登录返回 noLogin 登录流程继续
	@SuppressWarnings("unchecked")
	private String _intercept(ActionInvocation invocation) throws Exception {
		log.info("普通请求拦截");
		User user = (User) session.getAttribute("user");
		int index = request.getContextPath().length() + 1;
		String uri = request.getRequestURI().substring(index);
		if (null == user) {
			Map<String, String[]> parameterMap = request.getParameterMap();
			StringBuffer condition = new StringBuffer("");
			if (parameterMap != null) {
				Iterator iterator = parameterMap.keySet().iterator();
				if (iterator.hasNext()) {
					String key = (String) iterator.next();
					String[] values = (String[]) parameterMap.get(key);
					String valueStr = "";
					for (int i = 0; i < values.length; i++) {
						valueStr = (i == values.length - 1) ? valueStr
								+ values[i] : valueStr + values[i] + ",";
						if("id".equals(key)){
							valueStr = String.valueOf(Convert.strToLong(valueStr, -1));
						}
					}
					condition.append(key + "=" + valueStr + "&");
				}
			}
			String param = condition.toString();
			if (StringUtils.isNotBlank(param)) {
				param = param.substring(0, param.length() - 1);
				session.setAttribute("afterLoginUrl", uri + "?" + param);
			} else {
				session.setAttribute("afterLoginUrl", uri);
			}
			log.info("No Login");
			return "nologin";
		}
		log.info("id：" + user.getId() + " name：" + user.getUserName());
		return invocation.invoke();

	}

	// ajax请求拦截 没登录返回 NoLogin 登录流程继续
	private String ajaxIntercept(ActionInvocation invocation) throws Exception {
		log.info("ajax拦截");
		/*
		 * ConnectionManager cm = ConnectionManager.getInstance(); String cmm =
		 * cm.getMID(); boolean b =
		 * com.shove.security.License.isSystemRegister();
		 * if(!IConstants.ZCM.equals(cmm)){ return "network"; }
		 */
		User user = (User) session.getAttribute("user");
		if (null == user) {
			response.setContentType("text/html");
			response.getWriter().print("nologin");
			log.info("No Login");
			return null;
		}
		log.info("id：" + user.getId() + " name：" + user.getUserName());
		return invocation.invoke();
	}

	@SuppressWarnings("unused")
	private String getRemortIP() {
		if (request.getHeader("x-forwarded-for") == null) {
			return request.getRemoteAddr();
		}
		return request.getHeader("x-forwarded-for");
	}

	private boolean isAjaxRequest() {
		String header = request.getHeader("X-Requested-With");
		if (header != null && "XMLHttpRequest".equals(header)) {
			return true;
		}
		return false;
	}
}
