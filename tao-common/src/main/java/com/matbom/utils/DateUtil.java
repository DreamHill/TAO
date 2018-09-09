/**
 * Copyright (2018, ) Hebei Turning CO.,LTD.
 */
package com.matbom.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间工具类，用于处理各种时间需求
 * @author guoyou{yoyoyo5006@foxmail.com}
 *
 */
public class DateUtil {
	
	public static void main(String[] args) {
		Date date = new Date(123123123123l);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sdf.format(getFirstDateOfMonth(date)));
		System.out.println(sdf.format(getLastDateOfMonth(date)));
	}
	
	/**
	 * 获取给定日期所在月份的第一天的日期
	 * @param date
	 * @return
	 */
	public static Date getFirstDateOfMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		return cal.getTime();
	}
	
	/**
	 * 获取给定日期所在月份的最后一天的日期
	 * @param date
	 * @return
	 */
	public static Date getLastDateOfMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) + 1);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.DAY_OF_MONTH, 0);
		return cal.getTime();
	}
}
