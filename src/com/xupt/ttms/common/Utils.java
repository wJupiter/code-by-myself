package com.xupt.ttms.common;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author WangFeng 
 * @date 2017年5月30日 下午5:35:47 
 * @version 1.0 
 */
public class Utils {
	
	// 演出的开始时间和结束时间
	public static final String[] START_TIME = {"8:00","10:30","13:00","15:30","18:00","20:30"};
	public static final String[] END_TIME = {"10:00","12:30","15:00","17:30","18:30","22:30"};
	
	private static  SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	private static int count = 0;
	
	/**
	 * @param string 
	 * @return
	 */
	public static String getFileId(String fileName) {
		
		String fileId = sdf.format(new Date()) +(count++);
		if(count >=10){
			count = 0;
		}
		int index = fileName.lastIndexOf(".");
		String extension = null;
		if(index >= 0){
			extension = fileName.substring(index);
		}
		if(extension != null){
			fileId += extension;
		}
		return fileId;
	}
	
	public static String FormatDate(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}
	
}
