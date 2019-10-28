package com.neuedu.crm.utils;

import java.util.Calendar;
import java.util.Date;

public class DayCalculator {
	
	//计算时间d与当前时间相距天数
	public long calcDays( Date d ) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime( new Date() );
		 
		//(1000*60*60*24)这里结果为天数
		long dis = calendar.getTimeInMillis() - d.getTime();
		long days = dis / (1000*60*60*24);
		
		return days;
	}
}
