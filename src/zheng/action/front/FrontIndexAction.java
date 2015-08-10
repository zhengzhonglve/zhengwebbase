package zheng.action.front;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import zheng.constants.MConstants;
import zheng.data.Database;
import zheng.service.UserService;



public class FrontIndexAction  extends BaseFrontAction{
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String index() throws Exception{
		System.out.println("首页查询处理");
		/*分页查询
		pageBean.setPageNum(1);
		pageBean.setPageSize(10);
		userService.queryUsersPage(pageBean);
		List<Map<String,Object>> list = pageBean.getPage();
		System.out.println(list);*/
		
		/*根据id查询
		Map<String,Object> map = new HashMap<String,Object>();
		map = userService.queryUserById(1);
		System.out.println(MConstants.web_url);*/
		return "success";
	}
}
