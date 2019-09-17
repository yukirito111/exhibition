package com.boding.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class SystemDate {
    //获取系统时间
    public static Date systemDate() throws ParseException {
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8:00");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        simpleDateFormat.setTimeZone(timeZone);
        String sdate = simpleDateFormat.format(new Date());
        Date ddate = simpleDateFormat.parse(sdate);
        return ddate;
    }

}
