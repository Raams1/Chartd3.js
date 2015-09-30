package com.cassandra.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class util {

	public static List<String> getDaysBetweenDates(String start_date, String end_date) throws ParseException
	{
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		Date startdate = format.parse(start_date);
		Date enddate = format.parse(end_date);
	    List<String> dates = new ArrayList<String>();
	    Calendar calendar = new GregorianCalendar();
	    calendar.setTime(startdate);

	    while (calendar.getTime().before(enddate) || calendar.getTime().equals(enddate))
	    {
	        Date result = calendar.getTime();
	        dates.add(format.format(result));
	        calendar.add(Calendar.DATE, 1);
	    }
	    return dates;
	}
	
	public static int safeLongToInt(long l) {
		
		    if (l < Integer.MIN_VALUE || l > Integer.MAX_VALUE) {
		        throw new IllegalArgumentException
		            (l + " cannot be cast to int without changing its value.");
		    }

	    return (int) l;
	}
	
}
