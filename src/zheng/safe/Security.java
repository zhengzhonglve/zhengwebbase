package zheng.safe;

import java.util.Date;
import org.apache.commons.lang.StringUtils;

import zheng.constants.MConstants;
import zheng.util.DateUtils;
import zheng.util.NumberUtil;

public class Security {

	/**
	 * 给id加密
	 * @param id
	 * @param action
	 * @return
	 */
	public static String addSign(long id, String action) {
		String des=Encrypt.encrypt3DES(id+","+action+","+DateUtils.dateToString(new Date()), 
				MConstants.ENCRYPTION_KEY);
		String md5=Encrypt.MD5(des+MConstants.ENCRYPTION_KEY);
		String sign=des+md5.substring(0, 8);
		return sign;
	}
	
	/**
	 * 解密
	 * @param sign
	 * @param action
	 * @param validLength  （有效时间s）
	 * @return
	 */
	public static long checkSign(String sign, String action,int validLength) {
		if(StringUtils.isBlank(sign) || sign.length() < 8) {
			return -1;
		}
		
		String des = sign.substring(0, sign.length()-8);
		String key = sign.substring(sign.length()-8);
		String md5 = Encrypt.MD5(des + MConstants.ENCRYPTION_KEY);
		
		if(!key.equals(md5.substring(0, 8))) {
			return -1;
		}
		
		String[] decryArray = Encrypt.decrypt3DES(des, MConstants.ENCRYPTION_KEY).split(",");
		
		if(decryArray.length != 3) {
			return -1;
		}
		
		if(!decryArray[1].equals(action)) {
			return -1;
		}
		
		Date validTime = DateUtils.strToDate(decryArray[2]);
		
		if(validTime == null) {
			return -1;
		}
		
		if(!DateUtils.inValidTime(validTime, validLength)) {
			return -1;
		}
		
		if(!NumberUtil.isNumericInt(decryArray[0])) {
			return -1;
		}
		return Long.parseLong(decryArray[0]);
	}
	
	
	/**
	 * 加密字符串
	 */
	public static String encryptSign(String pwd) {
		String des=Encrypt.encrypt3DES(pwd+","+DateUtils.dateToString(new Date()),MConstants.ENCRYPTION_KEY);
		String md5=Encrypt.MD5(des+MConstants.ENCRYPTION_KEY);
		String sign=des+md5.substring(0, 8);
		return sign;
	}
	/**
	 * 解密字符串
	 * @param sign
	 * @return
	 */
	public static String decryptSign(String sign) {
		if(StringUtils.isBlank(sign) || sign.length() < 8) {
			return null;
		}
		String des = sign.substring(0, sign.length()-8);
		String key = sign.substring(sign.length()-8);
		String md5 = Encrypt.MD5(des + MConstants.ENCRYPTION_KEY);
		if(!key.equals(md5.substring(0, 8))) {
			return null;
		}
		String[] decryArray = Encrypt.decrypt3DES(des, MConstants.ENCRYPTION_KEY).split(",");
		
		if(decryArray.length != 2) {
			return null;
		}
		return decryArray[0];
	}
	
	public static void main(String args[]){
		String str = "mmmaaa";
		String entstr = encryptSign(str);
		System.out.println(encryptSign(str));
		System.out.println(decryptSign(entstr));
	}
	
}
