/**
 * 
 */
package com.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author @陈守义
 *
 * @{date}创建时间：2017年4月9日下午9:01:36
 */
public class DateUtil {

	/**
	 * 日期解析成文本
	 * @param d
	 * @return
	 */
	public static String fromDate(Date d){
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		String t = sd.format(d);
		return t;
	}
	/**
	 * 字符串格式化成日期
	 * @param time
	 * @return
	 */
	public static Date fromString(String time){
		Date d = null;
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		try {
			d = sd.parse(time);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return d;
	}
	
	public static int getDay(Date now,Date old){
		long nowt = now.getTime();
		long oldt = old.getTime();
		int day = 0;
		if(nowt>oldt){
			day = (int)((nowt-oldt)/(1*24*60*60*1000));
		}
		return day;
	}
}
