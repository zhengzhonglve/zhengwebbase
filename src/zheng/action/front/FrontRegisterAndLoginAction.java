package zheng.action.front;

import java.io.IOException;

import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import zheng.entity.User;
import zheng.util.JSONUtils;

/**
 * 登陆注册等
 * 
 * @author
 * 
 */
public class FrontRegisterAndLoginAction extends BaseFrontAction {
	public static Log log = LogFactory.getLog(FrontRegisterAndLoginAction.class);
	private static final long serialVersionUID = 1L;
	
	public String loginInit(){
		return "success";
	}
	
	public String login(){
		JSONObject obj = new JSONObject();
		//先虚拟登陆
		String username = paramMap.get("username");
		if("superzheng".equals(username)){
			User user = new User();
			user.setId(1);
			user.setUserName(username);
			session().setAttribute("user", user);
			obj.put("code", "1");
			obj.put("msg", "");
		}else{
			obj.put("code", "-1");
			obj.put("msg", "登陆失败");
		}
		try {
			JSONUtils.printObject(obj);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/* 退出登陆 */
	public void logout() throws Exception{
		request().getSession().removeAttribute("user");
		request().getSession().invalidate();
		getOut().print("<script>parent.location.href='login.do';</script>");
	}
}
