package com.ipbd.ipbdsms.utils;


import java.util.Calendar;

public class DateUtil {

    private String start = "2023-08-27 15:23:03";

    private Calendar calendar = Calendar.getInstance();

    private Calendar now = Calendar.getInstance();

    public Integer getWeek(){
        calendar.set(2023,8,27);
        return now.get(Calendar.WEEK_OF_YEAR) - calendar.get(Calendar.WEEK_OF_YEAR);
    }

    public Integer getDay(){
        calendar.set(2023,8,27);
        return now.get(Calendar.DAY_OF_YEAR) - calendar.get(Calendar.DAY_OF_YEAR);
    }
    public Integer getYear(){
        return now.get(Calendar.YEAR);
    }
    public Integer getWeekDay(){
        return now.get(Calendar.DAY_OF_WEEK);
    }

}
