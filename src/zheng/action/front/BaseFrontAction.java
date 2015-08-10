package zheng.action.front;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import zheng.base.BasePageAction;
import zheng.system.exception.FrontHelpMessageException;
import zheng.util.WebUtil;

public class BaseFrontAction extends BasePageAction {

	
	private static final long serialVersionUID = 1L;
	//PrintWriter打印输出
	private PrintWriter out;
	

	/**
	 * 跳转拦截
	 * 
	 * @param title
	 * @param msg
	 * @param url
	 * @throws FrontHelpMessageException
	 */
	public void createHelpMessage(String title, String msg, String url)
			throws FrontHelpMessageException {
		/* helpMessage.setTitle("用户不存在"); */
		helpMessage.setMsg(new String[] { "返回首页" });
		helpMessage.setUrl(new String[] { "index" });
		helpMessage.setTitle(title);
		/*
		 * helpMessage.setMsg(new String[]{msg}); helpMessage.setUrl(new
		 * String[]{url});
		 */
		throw new FrontHelpMessageException();
	}

	public PrintWriter getOut() throws Exception {
		response().setCharacterEncoding("UTF-8");
		response().setContentType("text/html; charset=UTF-8");
		out = response().getWriter();
		return out;
	}
	
	
	
	public String returnParentUrl(String function,String url) throws Exception{
		getOut().print("<script type='text/javascript'>"+function+"parent.location.href='" + request().getContextPath()
    						+ "/"+url+";</script>");
		return null;
	}
	
	
	
	public String getBasePath(){
		return WebUtil.getWebPath();
	}
	
	public String getPath() {
		int port = request().getServerPort();
		String portStr = "";
		if(port != 80){
			portStr = ":"+port; 
		}
		String path = request().getScheme() + "://" + request().getServerName()
		+ portStr + request().getContextPath()
		+ "/";
		return path;
	}
}
