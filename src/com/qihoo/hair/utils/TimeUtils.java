package com.qihoo.hair.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by chengkuang on 15-1-25.
 */
public class TimeUtils {

    public static long pareseTime(int year, int month ,int day) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, day);
        return c.getTimeInMillis();
    }

    public static String getTimeDesc1(long time) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return df.format(new Date(time));
    }
}
