/**
 * 
 */
package com.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author @������
 *
 * @{date}����ʱ�䣺2017��4��9������9:01:36
 */
public class DateUtil {

	/**
	 * ���ڽ������ı�
	 * @param d
	 * @return
	 */
	public static String fromDate(Date d){
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		String t = sd.format(d);
		return t;
	}
	/**
	 * �ַ�����ʽ��������
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
