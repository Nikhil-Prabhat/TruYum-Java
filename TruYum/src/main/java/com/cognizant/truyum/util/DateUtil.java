package com.cognizant.truyum.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static Date convertToDate(String date) {
		Date date1 = null;
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

		try {
			date1 = formatter.parse(date);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return date1;

	}

}
