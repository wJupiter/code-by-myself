package com.xupt.ttms.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * @author WangFeng 
 * @date 2017年6月2日 下午9:57:08 
 * @version 1.0 
 */
public class DateConverter implements Converter<String, Date> {

	private String datePattarn;
	
	public void setDatePattarn(String datePattarn) {
		this.datePattarn = datePattarn;
	}
	
	@Override
	public Date convert(String input) {
		SimpleDateFormat sdf = new SimpleDateFormat(datePattarn);
		sdf.setLenient(false);
		try {
			return sdf.parse(input);
		} catch (ParseException e) {
			throw new IllegalArgumentException(
				"Invalid date format. Please use this pattern\"" + datePattarn + "\"");
		}
	}
}
