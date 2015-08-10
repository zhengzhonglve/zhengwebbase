package zheng.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * 日期转换工具类
 * 
 */
public class DateUtils {
	private static final String DEFAULT_DATE_FORMATE = "yyyy-MM-dd";
	private static final String YYYYMMDD_DATE_FORMATE = "yyyyMMdd";
	private static final String YYYYMMDDHHmiss_DATE_FORMATE = "yyyyMMdd HH:mm";
	
	/**
	 * 获取系统当前时间
	 * 
	 * @return Long
	 * @author zhuangruhai
	 * @since 2007-9-27
	 */
	public static Long getCurrentTimeMillis() {
		return System.currentTimeMillis();
	}

	/**
	 * 获取系统当前日期,日期格式为yyyy-MM-dd。
	 * 
	 * @return 返回字符串型的日期 String
	 * @author zhuangruhai
	 * @since 2007-9-27
	 */
	public static String getCurrentDate() {
		SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_DATE_FORMATE);
		//sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
		return sdf.format(getDate());
	}
	

	/**
	 * 获取系统当前日期,日期格式为yyyyMMdd。
	 * 
	 * @return 返回字符串型的日期 String
	 * @author zhuangruhai
	 * @since 2007-9-27
	 */
	public static String getYYYYMMDDDate() {
		SimpleDateFormat sdf = new SimpleDateFormat(YYYYMMDD_DATE_FORMATE);
		//sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
		return sdf.format(getDate());
	}

	/**
	 * 获取系统指定格式当前日期
	 * 
	 * @param formate
	 *            日期格式(比如：yyyy-MM-dd)
	 * @return 返回字符串型的日期 String
	 * @author zhuangruhai
	 * @since 2007-9-27
	 */
	public static String getCurrentDate(String formate) {
		SimpleDateFormat sdf = new SimpleDateFormat(formate);
		//sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
		return sdf.format(getDate());
	}

	/**
	 * 获取系统当前默认日期
	 * 
	 * @return 返回日期 Date
	 * @author zhuangruhai
	 * @since 2007-9-27
	 */
	public static Date getDate() {
		return new Date();
	}

	/**
	 * 获得一天的结束时间，主要用于查询是的结束时间条件 例如：输入2007-09-27 08:09:10，输出得到 2007-09-28
	 * 00:00:00
	 * 
	 * @param date
	 *            原始日期
	 * @return Date
	 * @author Liaoke
	 * @since 2007-9-28
	 */
	public static Date getEndOfDate(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.HOUR_OF_DAY, 23); // 强行设置为23点，为下步四舍五入做准备
		Date result = org.apache.commons.lang.time.DateUtils.round(c.getTime(),
				Calendar.DATE);
		return result;
	}

	/**
	 * 当前日期向前增加days天
	 * 
	 * @param date
	 * @param days
	 * @return
	 */
	public static Date getDateDayAdd(Date date, int days) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int day = c.get(Calendar.DAY_OF_YEAR);
		c.set(Calendar.DAY_OF_YEAR, day + days);
		Date d = c.getTime();
		return d;
	}
	
	/**
	 * 当前日期向前增加months月
	 * 
	 * @param date
	 * @param days
	 * @return
	 */
	public static Date getDateMonthAdd(Date date, int months) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int month = c.get(Calendar.MONTH);
		c.set(Calendar.MONTH, month + months);
		Date d = c.getTime();
		return d;
	}
	
	/**
	 * 当前日期时间向前增加hour小时
	 * 
	 * @param date
	 * @param days
	 * @return
	 */
	public static Date getDateHourAdd(Date date, int hours) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int hour = c.get(Calendar.HOUR);
		c.set(Calendar.HOUR, hour + hours);
		Date d = c.getTime();
		return d;
	}
	
	
	/**
	 * 当前日期向前增加years年
	 * 
	 * @param date
	 * @param days
	 * @return
	 */
	public static Date getDateYearAdd(Date date, int years) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int year = c.get(Calendar.YEAR);
		c.set(Calendar.YEAR, year + years);
		Date d = c.getTime();
		return d;
	}
	
	

	public static String format(Date date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		//sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
		return sdf.format(date);
	}
	public static Date getDate(String date, String format) {
		Date d = null;
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		//sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
		try {
			d = sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return d;
	}
	
	/**
	 * 当前时间向前增加second秒
	 * 
	 * @param date
	 * @param days
	 * @return
	 */
	public static Date getDateSecondAdd(Date date, int second) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int addSecond = c.get(Calendar.SECOND);
		c.set(Calendar.SECOND, addSecond + second);
		Date d = c.getTime();
		return d;
	}
	
	public static String dateToString(Date date){
		if(null == date)
			return "";

		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
	}
	
	public static Date strToDate(String dateString){
		if(null == dateString)
			return new Date();
		
		try {
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateString);
		} catch (ParseException e) {
			return new Date();
		}
	}
	
	/**
	 * 和当前时间比较是否在给定的时长内
	 * @param validTime 给定的时间
	 * @param time 给定的时长（s）
	 * @return true 有效 false 无效
	 */
	public static boolean inValidTime(Date validTime, int time){
		long currTime = System.currentTimeMillis();
		long valid = validTime.getTime();
		
		return ((currTime - valid) < time*1000);
	}
	
	public static void main(String[] args) {
		Date d = DateUtils.getDateHourAdd(new Date(),1);
//		System.out.println(DateUtils.format(d, "yyyy-MM-dd HH:mm"));
		String ff = DateUtils.format(d, "yyyy-MM-dd HH:mm");
		String time = DateUtils.format(DateUtils.getDate("2010-12-2 15:03:44", "yy-MM-dd HH:mm:ss"), "yyMMddHHmmss");
		System.out.println(DateUtils.getDate("2010-12-2 15:03:44", "yy-MM-dd HH:mm:ss"));
		System.out.println(time);
//		String str= "adsfasd.abc";
//		boolean b = str.endsWith(".abc");
//		System.out.println(getCurrentDate("yyyyMMddHHmmss"));
		//System.out.println(getEndOfDate(getDate()));
	}
}

