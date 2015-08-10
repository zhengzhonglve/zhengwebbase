package zheng.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import zheng.constants.MConstants;


public class WebUtil {

	public static String getBasePath() {
		return getWebPath();

	}

	/**
	 * @MethodName: getWebPath
	 * @Param: WebUtil
	 * @Author: gang.lv
	 * @Date: 2013-5-12 下午10:57:47
	 * @Return:
	 * @Descb: 获取web路径
	 * @Throws:
	 */
	public static String getWebPath() {
		return MConstants.web_url;
	}
	
}
