package com.policymanage.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateUtils{
    public static final String DATE_FORMAT_YYYY_MM_DD = "yyyy-MM-dd";

    /**
     * 获取日期的年份
     * @param date
     * @return
     */
    public static Integer getYear(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.YEAR);
    }

    /**
     * 获取日期的月份
     * @param date
     * @return
     */
    public static Integer getMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.MONTH) + 1;
    }

    /**
     * 获取日期的日数
     * @param date
     * @return
     */
    public static Integer getDay(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int day=cal.get(Calendar.DATE);//获取日
        return day;
    }

    /**
     * 格式化Date时间
     * @param date Date类型时间
     * @param timeFormat String类型格式
     * @return 格式化后的字符串
     */
    public static String parseDateToStr(Date date, String timeFormat){
        DateFormat dateFormat=new SimpleDateFormat(timeFormat);
        return dateFormat.format(date);
    }

    /**
     * 格式化String时间
     * @param date String类型时间
     * @return 格式化后的Date日期
     */
    public static Date parseStrToDate(String date) throws ParseException {
        DateFormat df1 = new  SimpleDateFormat("yyyy年MM月dd日");
        DateFormat df2 = new SimpleDateFormat("yyyyMMdd");
        DateFormat df3 = new SimpleDateFormat("yyyy.MM.dd");
        DateFormat df4 = new SimpleDateFormat("yyyy-MM-dd");
        Date dateChange;
        char i = date.charAt(4);
        if (i == '年') {
            dateChange = df1.parse(date);
            return dateChange;
        } else if (Character.isDigit(i)) {
            dateChange = df2.parse(date);
            return dateChange;
        } else if (i == '.') {
            dateChange = df3.parse(date);
            return dateChange;
        } else if (i == '-') {
            dateChange = df4.parse(date);
            return dateChange;
        }
        return null;
    }

    /**
     * 解析两个日期段之间的所有日期
     * @param beginDate 开始日期  ，至少精确到yyyy-MM-dd
     * @param endDate 结束日期  ，至少精确到yyyy-MM-dd
     * @return yyyy-MM-dd日期集合
     */
    public static List<String> getDayListOfDate(Date beginDate, Date endDate) {
        // 定义一些变量
        Calendar beginGC = null;
        Calendar endGC = null;
        List<String> list = new ArrayList<String>();
        try {
            // 设置日历
            beginGC = Calendar.getInstance();
            beginGC.setTime(beginDate);
            endGC = Calendar.getInstance();
            endGC.setTime(endDate);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            // 直到两个时间相同
            while (beginGC.getTime().compareTo(endGC.getTime()) <= 0) {
                list.add(sdf.format(beginGC.getTime()));
                // 以日为单位，增加时间
                beginGC.add(Calendar.DAY_OF_MONTH, 1);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 前端传来String类型的日期，转换为Date格式后推算出期间的所有日期并存储至List集合
     * @param beginDateStr
     * @param endDateStr
     * @return
     */
    public static List<String> getDayListOfDateStr(String beginDateStr, String endDateStr) {
        try {
            Date beginDate = DateUtils.parseStrToDate(beginDateStr);
            Date endDate = DateUtils.parseStrToDate(endDateStr);
            List<String> list = DateUtils.getDayListOfDate(beginDate, endDate);
            return list;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}