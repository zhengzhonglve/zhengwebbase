package zheng.action.front;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import zheng.entity.User;
import zheng.service.MyHomeService;

/**
 * @ClassName: FrontMyHomeAction.java
 * @Author: gang.lv
 * @Date: 2013-3-13 下午10:21:30
 * @Copyright: 2013 www.emis.com Inc. All rights reserved.
 * @Version: V1.0.1
 * @Descrb: 我的主页控制层
 */
public class FrontMyHomeAction extends BaseFrontAction {

	public static Log log = LogFactory.getLog(FrontMyHomeAction.class);
	private static final long serialVersionUID = 1L;

	private MyHomeService myHomeService;

	public String myhomeInit(){
		
		return "success";
	}
	
	public MyHomeService getMyHomeService() {
		return myHomeService;
	}

	public void setMyHomeService(MyHomeService myHomeService) {
		this.myHomeService = myHomeService;
	}
	
	

}
