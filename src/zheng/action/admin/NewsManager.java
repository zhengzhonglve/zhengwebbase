package zheng.action.admin;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import zheng.base.BasePageAction;

public class NewsManager extends BasePageAction {
	public static Log log = LogFactory.getLog(NewsManager.class);
	private static final long serialVersionUID = 1L;
	
	public String newsTypeManagerInit(){
		
		return SUCCESS;
	}
}
