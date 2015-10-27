package com.test;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateFormat {

	public static void main(String[] args) {
		/*String PATTERN="ddMMyyyy";
		SimpleDateFormat dateFormat=new SimpleDateFormat();
		dateFormat.applyPattern(PATTERN);
		System.out.println(dateFormat.format(Calendar.getInstance().getTime()));
		
*/
		
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		System.out.println(timeStamp );
		
		String dayNames[] = new DateFormatSymbols().getWeekdays();
		   Calendar date2 = Calendar.getInstance();
		      System.out.println("Today is a " 
		        + dayNames[date2.get(Calendar.DAY_OF_WEEK)]);
	}

}
