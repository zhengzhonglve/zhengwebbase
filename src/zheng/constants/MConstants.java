package zheng.constants;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;

import zheng.file.ReadProperty;

/**
 * @author 杨程
 * @version Oct 19, 2011 1:55:18 PM
 * @declaration
 */
public class MConstants {
	
	public static String ENCRYPTION_KEY = "1234adsx";//加密key
	public static String web_url = "";//网站url
	/*seo相关参数*/
	public static String SEO_TITLE = "";
	public static String SEO_KEYWORDS = "";
	public static String SEO_DESCRIPTION = "";
	public static String SEO_OTHERTAGS = "";
	
	/*session中管理员与用户的名称*/
	public static final String ADMIN = "admin";
	public static final String USER = "user";
	
	public static final String NO_LOGIN="nologin";
	
	static{
		try {
			ReadProperty pf = new ReadProperty();
			web_url = pf.read("web_url");
			SEO_TITLE = "基础网站";
			SEO_KEYWORDS = "关键字";
			SEO_DESCRIPTION = "描述";
			SEO_OTHERTAGS = "";
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
	}
	
}