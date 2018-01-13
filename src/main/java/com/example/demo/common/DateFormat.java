package com.example.demo.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat {
    /**
     * 时间字符串转换为时间戳
     * @param date yyyy-MM-dd hh:mm:ss
     * @return
     */
    public static long getTimestampWithDate(String time) {
        SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = format.parse(time);
            return date.getTime();
        }catch (ParseException pe) {
            return 0;
        }
    }

    /**
     * 时间戳转换为时间
     * @param timestamp
     * @return
     */
    public static Date getDateWithTimestamp(long timestamp) {
        SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Long time=new Long(timestamp);
        String d = format.format(time);
        try {
            Date date = format.parse(d);
            return date;
        }catch (ParseException pe) {
            return null;
        }
    }
}
