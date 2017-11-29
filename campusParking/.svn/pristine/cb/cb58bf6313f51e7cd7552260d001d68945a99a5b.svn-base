package com.cp.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.cp.util.StringUtil;

public class DateUtil {

private DateUtil() {}
	
	private static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
	
	private static ThreadLocal<SimpleDateFormat> sdfPool = new ThreadLocal<SimpleDateFormat>() {

		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat();
		}
		
	};
	
	public static Date parseDate(String pattern, String date) {
		if (StringUtil.isNullOrEmpty(date))
			return null;
		
		SimpleDateFormat sdf = sdfPool.get();
		
		sdf.applyPattern(pattern);
		try {
			return sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static Date parseDate(String date) {
		return parseDate(DEFAULT_DATE_FORMAT, date);
	}

	
	public static String formatDate(String pattern, Date date) {
		SimpleDateFormat sdf = sdfPool.get();
		
		sdf.applyPattern(pattern);
		return sdf.format(date);
	}
	
	public static String formatDate(Date date) {
		return formatDate(DEFAULT_DATE_FORMAT, date);
	}
}
