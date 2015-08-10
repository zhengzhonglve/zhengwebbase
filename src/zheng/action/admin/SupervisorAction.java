package zheng.action.admin;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import zheng.base.BasePageAction;
import zheng.constants.MConstants;
import zheng.entity.Admin;
public class SupervisorAction extends BasePageAction {

	public static Log log = LogFactory.getLog(SupervisorAction.class);
	private static final long serialVersionUID = 1L;

	public String login() throws Exception{
		return SUCCESS;
	}
	
	public String adminLoginOut() throws Exception {
		session().removeAttribute(MConstants.ADMIN);
		return SUCCESS;
	}
	
	public String supervisorlogin(){
		Admin admin = new Admin();
		admin.setUserName("zheng");
		session().setAttribute(MConstants.ADMIN, admin);
		return SUCCESS;
	}
	

}
