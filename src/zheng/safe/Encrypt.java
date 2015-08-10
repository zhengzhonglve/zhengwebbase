package zheng.safe;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
public class Encrypt {
	
	public static String MD5(String input){
		return MD5(input, Charset.defaultCharset());
	}
	
    public static String MD5(String input, String charset) {
      return MD5(input, Charset.forName(charset));
    }
	/**
	 * md5加密算法  
	 * @param input
	 * @param charset
	 * @return
	 */
    private static String MD5(String input, Charset charset){
	    MessageDigest md = null;
	    try{
	      md = MessageDigest.getInstance("MD5");
	    } catch (NoSuchAlgorithmException e) {
	      e.printStackTrace();
	    }
	    md.update(input.getBytes(charset));
	    char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
	      'a', 'b', 'c', 'd', 'e', 'f' };
	    byte[] tmp = md.digest();
	    char[] str = new char[32];
	    int k = 0;
	    for (int i = 0; i < 16; i++) {
	      byte byte0 = tmp[i];
	      str[(k++)] = hexDigits[(byte0 >>> 4 & 0xF)];
	      str[(k++)] = hexDigits[(byte0 & 0xF)];
	    }
	    String result = new String(str);
	    return result;
    }
    
    /**
     * 加密
     * @param input
     * @param key
     * @return
     */
    public static String encrypt3DES(String input, String key){
      return encrypt3DES(input, key, Charset.forName("GB2312"));
    }
    /**
     * 加密
     * @param input
     * @param key
     * @param charset
     * @return
     */
    private static String encrypt3DES(String input, String key, Charset charset){
      try{
        return byte2hex(encrypt(input.getBytes(charset.name()), key.getBytes()));
      }catch (Exception localException) {
    	  localException.printStackTrace();
    	  return "";
      }
    }
    
    /**
     * 解密
     * @param input
     * @param key
     * @return
     */
    public static String decrypt3DES(String input, String key){
      return decrypt3DES(input, key, Charset.forName("GB2312"));
    }
    /**
     * 解密
     * @param input
     * @param key
     * @param charset
     * @return
     */
    private static String decrypt3DES(String input, String key, Charset charset){
      try{
        return new String(decrypt(hex2byte(input.getBytes()), key.getBytes()), charset.name());
      }catch (Exception localException) {
    	  localException.printStackTrace();
    	  return "";
      }
    }
    
  /**
   * 加密
   * @param src
   * @param key
   * @return
   * @throws Exception
   */
  private static byte[] encrypt(byte[] src, byte[] key) throws Exception{
    SecureRandom sr = new SecureRandom();
    DESKeySpec dks = new DESKeySpec(key);
    SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
    SecretKey securekey = keyFactory.generateSecret(dks);
    Cipher cipher = Cipher.getInstance("DES");
    cipher.init(1, securekey, sr);

    return cipher.doFinal(src);
  }
  /**
   * 解密
   * @param src
   * @param key
   * @return
   * @throws Exception
   */
  private static byte[] decrypt(byte[] src, byte[] key) throws Exception{
    SecureRandom sr = new SecureRandom();
    DESKeySpec dks = new DESKeySpec(key);
    SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
    SecretKey securekey = keyFactory.generateSecret(dks);
    Cipher cipher = Cipher.getInstance("DES");
    cipher.init(2, securekey, sr);

    return cipher.doFinal(src);
  }
  /**
   * 16进制字符串转字节数组
   * @param buffer
   * @return
   */
  private static byte[] hex2byte(byte[] buffer){
    if (buffer.length % 2 != 0) {
      throw new IllegalArgumentException("长度不是偶数");
    }

    byte[] b2 = new byte[buffer.length / 2];

    for (int n = 0; n < buffer.length; n += 2) {
      String item = new String(buffer, n, 2);
      b2[(n / 2)] = ((byte)Integer.parseInt(item, 16));
    }

    return b2;
  }
  /**
   * 字节数组转16进制字符串
   * @param buffer
   * @return
   */
  private static String byte2hex(byte[] buffer){
    String hs = "";
    String stmp = "";
    for (int n = 0; n < buffer.length; n++) {
      stmp = Integer.toHexString(buffer[n] & 0xFF);
      if (stmp.length() == 1) {
        hs = hs + "0" + stmp;
      }
      else {
        hs = hs + stmp;
      }
    }
    return hs.toUpperCase();
  }
}
