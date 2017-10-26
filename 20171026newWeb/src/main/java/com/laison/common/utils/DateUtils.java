/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.laison.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;

import com.laison.common.enumerate.Constant;

/**
 * 
* @ClassName: DateUtils 
* @Description: TODO
* @author lihua
* @date 2017年9月25日 上午9:57:43 
*
 */
public class DateUtils extends org.apache.commons.lang3.time.DateUtils {
	
	private static String[] parsePatterns = {
		"yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM", 
		"yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM",
		"yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM"};

	/**
	 * 得到当前日期字符串 格式（yyyyMMdd）
	 */
	public static String getDate() {
		return getDate("yyyyMMdd");
	}
	
	/**
	 * 得到当前日期字符串 格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
	 */
	public static String getDate(String pattern) {
		return DateFormatUtils.format(new Date(), pattern,Constant.TZ);
	}
	
	/**
	 * 得到日期字符串 默认格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
	 */
	public static String formatDate(Date date, Object... pattern) {
		String formatDate = null;
		if (pattern != null && pattern.length > 0) {
			formatDate = DateFormatUtils.format(date, pattern[0].toString(),Constant.TZ);
		} else {
			formatDate = DateFormatUtils.format(date, "yyyy-MM-dd",Constant.TZ);
		}
		return formatDate;
	}
	/**
	 * 求2个时间的分钟差
	 * @param date1
	 * @param date2
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static int miniteDiff(Date date1, Date date2) {
		return date1.getMinutes()-date2.getMinutes();
	}
	/**
	 * 得到日期时间字符串，转换格式（yyyy-MM-dd HH:mm:ss）
	 */
	public static String formatDateTime(Date date) {
		return formatDate(date, "yyyy-MM-dd HH:mm:ss",Constant.TZ);
	}

	/**
	 * 得到当前时间字符串 格式（HH:mm:ss）
	 */
	public static String getTime() {
		return formatDate(new Date(), "HH:mm:ss",Constant.TZ);
	}

	/**
	 * 得到当前日期和时间字符串 格式（yyyy-MM-dd HH:mm:ss）
	 */
	public static String getDateTime() {
		return formatDate(new Date(), "yyyy-MM-dd HH:mm:ss",Constant.TZ);
	}

	/**
	 * 得到当前年份字符串 格式（yyyy）
	 */
	public static String getYear() {
		return formatDate(new Date(), "yyyy",Constant.TZ);
	}

	/**
	 * 得到当前月份字符串 格式（MM）
	 */
	public static String getMonth() {
		return formatDate(new Date(), "MM",Constant.TZ);
	}

	/**
	 * 得到当天字符串 格式（dd）
	 */
	public static String getDay() {
		return formatDate(new Date(), "dd",Constant.TZ);
	}

	/**
	 * 得到当前星期字符串 格式（E）星期几
	 */
	public static String getWeek() {
		return formatDate(new Date(), "E",Constant.TZ);
	}
	
	/**
	 * 日期型字符串转化为日期 格式
	 * { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", 
	 *   "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm",
	 *   "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm" }
	 */
	public static Date parseDate(Object str) {
		if (str == null){
			return null;
		}
		try {
			return parseDate(str.toString(), parsePatterns);
		} catch (ParseException e) {
			return null;
		}
	}
	/**
	 * 
	* @Title: utcDate 
	* @Description: 获取当地当前时间
	* @param @return   
	* @return Date
	 */
	public static Date utcDate() {
		String date = getDate("yyyy-MM-dd HH:mm:ss");
		return parseDate(date);
	}
	/**
	 * 
	* @Title: defaultDate 
	* @Description: 获取默认时间 2000-1-1 0:0:0
	* @param @return   
	* @return Date
	 */
	public static Date defaultDate() {
		Calendar instance = Calendar.getInstance();
		instance.set(2000, 0, 1,0,0,0);
		Date date = instance.getTime();
		return date;
	}
	
	/**
	 * 
	* @Title: defaultDate 
	* @Description: 判断是不是默认时间
	* @param @param date
	* @param @return   
	* @return boolean
	 */
	public static boolean equalsDefaultDate(Date date) {
		Date defauleDate = defaultDate();
		return date.equals(defauleDate);
	}
	
	/**
	 * 
	* @Title: afterDefaultDate 
	* @Description: 判断时间是不是大于默认时间
	* @param @param date
	* @param @return   
	* @return boolean
	 */
	public static boolean afterDefaultDate(Date date) {
		Date defauleDate = defaultDate();
		return date.after(defauleDate);
	}
	/**
	 * 
	* @Title: beforeThisDay 
	* @Description: 判断日期是否<=当前日期
	* @param @param date
	* @param @return   
	* @return boolean
	 */
	public static boolean beforeThisDay(Date date) {
		Date currentDate = utcDate();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		long dateLong = Long.parseLong(sdf.format(date));
		long currentDateLong = Long.parseLong(sdf.format(currentDate));
		return currentDateLong>=dateLong;
	}
	/**
	 * 获取过去的天数
	 * @param date
	 * @return
	 */
	public static long pastDays(Date date) {
		long t = new Date().getTime()-date.getTime();
		return t/(24*60*60*1000);
	}

	/**
	 * 获取过去的小时
	 * @param date
	 * @return
	 */
	public static long pastHour(Date date) {
		long t = new Date().getTime()-date.getTime();
		return t/(60*60*1000);
	}
	
	/**
	 * 获取过去的分钟
	 * @param date
	 * @return
	 */
	public static long pastMinutes(Date date) {
		long t = new Date().getTime()-date.getTime();
		return t/(60*1000);
	}
	
	/**
	 * 转换为时间（天,时:分:秒.毫秒）
	 * @param timeMillis
	 * @return
	 */
    public static String formatDateTime(long timeMillis){
		long day = timeMillis/(24*60*60*1000);
		long hour = (timeMillis/(60*60*1000)-day*24);
		long min = ((timeMillis/(60*1000))-day*24*60-hour*60);
		long s = (timeMillis/1000-day*24*60*60-hour*60*60-min*60);
		long sss = (timeMillis-day*24*60*60*1000-hour*60*60*1000-min*60*1000-s*1000);
		return (day>0?day+",":"")+hour+":"+min+":"+s+"."+sss;
    }
	
	/**
	 * 获取两个日期之间的天数
	 * 
	 * @param before
	 * @param after
	 * @return
	 */
	public static double getDistanceOfTwoDate(Date before, Date after) {
		long beforeTime = before.getTime();
		long afterTime = after.getTime();
		return (afterTime - beforeTime) / (1000 * 60 * 60 * 24);
	}
	
	/**
	 * @param args
	 * @throws ParseException
	 */
	public static void main(String[] args) throws ParseException {
		  String date = getDate();
		  System.out.println(date);
		  String day = getDay();
		  System.out.println(day);
		  Date parseDate = parseDate("2017-08-08 11:11");
		  Date parseDate2 = parseDate("2017-08-08 11:12");
		 int miniteDiff = miniteDiff(parseDate, parseDate2);
		 System.out.println(miniteDiff);
		 
		 byte[] bytes = "sdfsdf".getBytes();
		  
	}
	
	
}
