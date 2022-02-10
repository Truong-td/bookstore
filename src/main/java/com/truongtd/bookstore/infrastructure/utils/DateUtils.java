package com.truongtd.bookstore.infrastructure.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

public class DateUtils {

    public final static String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    /**
     * convert from String to Date
     * @param dateInString
     * @return date
     */
    public static Date convertStringToDate(String dateInString) {
        SimpleDateFormat formatter = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
        try {
            Date date = formatter.parse(dateInString);
            return date;
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * compare between to date
     * @param start
     * @param end
     * @param day
     * @return boolean
     */
    public static boolean compareDate(Date start, Date end, int day) {
        long diff = end.getTime() - start.getTime();
        return diff <= day * 24 * 60 * 60 * 1000;
    }

    /**
     * get start date
     * @param date
     * @return
     */
    public static Date getStartOfDay(Date date) {
        LocalDateTime localDateTime = dateToLocalDateTime(date);
        LocalDateTime startOfDay = localDateTime.with(LocalTime.MIN);
        return localDateTimeToDate(startOfDay);
    }

    /**
     * get end date
     * @param date
     * @return
     */
    public static Date getEndOfDay(Date date) {
        LocalDateTime localDateTime = dateToLocalDateTime(date);
        LocalDateTime endOfDay = localDateTime.with(LocalTime.MAX);
        return localDateTimeToDate(endOfDay);
    }

    /**
     * convert datetime from local to time zone
     * @param date
     * @return
     */
    private static LocalDateTime dateToLocalDateTime(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    /**
     * get date time local
     * @param localDateTime
     * @return
     */
    private static Date localDateTimeToDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }
}
