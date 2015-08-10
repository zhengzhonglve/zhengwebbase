package zheng.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

import zheng.constants.MConstants;
import zheng.entity.Admin;

public class SupervisorSessionInterceptor  implements Interceptor {
	public static Log log = LogFactory.getLog(SupervisorSessionInterceptor.class);
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private HttpSession session;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}
	/**
	 * 登陆拦截
	 */
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		request = ServletActionContext.getRequest();
		response = ServletActionContext.getResponse();
		session = request.getSession();
		log.info(request.getRequestURL());
		if (isAjaxRequest()) {
			return ajaxIntercept(invocation);
		}
		return _intercept(invocation);
	}
	
	private String _intercept(ActionInvocation invocation) throws Exception {
			Admin admin = (Admin) session.getAttribute(MConstants.ADMIN);
			if (null == admin) {
				log.info("No Login");
				return MConstants.NO_LOGIN;
			}
			log.info("admin id：" + admin.getId() + " name：" + admin.getUserName());
			return invocation.invoke();
	}
	
	private String ajaxIntercept(ActionInvocation invocation) throws Exception {
			Admin admin = (Admin) session.getAttribute(MConstants.ADMIN);
			if (null == admin) {
				response.setContentType("text/html");
				response.getWriter().print(MConstants.NO_LOGIN);
				log.info("No Login");
				return null;
			}
			log.info("admin id：" + admin.getId() + " name：" + admin.getUserName());
			return invocation.invoke();
	}
	
	/**
	 * 根据请求头数据判断是否是Ajax请求
	 * @return
	 */
	private boolean isAjaxRequest() {
		String header = request.getHeader("X-Requested-With");
		if (header != null && "XMLHttpRequest".equals(header)) {
			return true;
		}
		return false;
	}

}
