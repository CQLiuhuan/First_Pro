/**
 * DateUtils.java
 * 
 * Create Version: 1.0
 * Author: liuhuan
 * Create Date: Mar 26, 2016
 * 
 * Copyright (c) 2016 CMCCIOT. All Right Reserved.
 */
package com.pub.tool.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * DateUtils 日期工具类
 *
 * @author liuhuan
 */
public class DateUtils {

    /**
     * 计算两个日期相差的月数
     * 两个参数大小可以不区分
     * 
     * @return 相差的月数
     */
    public static int getMonthSpace(String date1, String date2) {
        int mouthResult = 0;
        int yearResult = 0;
        int lastReusult = 0;
        boolean mark = false;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        try {
            c1.setTime(sdf.parse(date1));
            c2.setTime(sdf.parse(date2));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (c2.get(Calendar.YEAR) > c1.get(Calendar.YEAR)) {
            mark = true;
        } else if ((c2.get(Calendar.YEAR) == c1.get(Calendar.YEAR))
                && (c2.get(Calendar.MONTH) > c1.get(Calendar.MONTH))) {
            mark = true;
        } else if ((c2.get(Calendar.YEAR) == c1.get(Calendar.YEAR))
                && (c2.get(Calendar.MONTH) > c1.get(Calendar.MONTH))
                && (c2.get(Calendar.DAY_OF_MONTH) > c1.get(Calendar.DAY_OF_MONTH))) {
            mark = true;
        }

        if (mark) {
            yearResult = c2.get(Calendar.YEAR) - c1.get(Calendar.YEAR);
            if (c2.get(Calendar.MONTH) > c1.get(Calendar.MONTH)) {
                mouthResult = c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH);
                mouthResult = mouthResult == 0 ? 0 : Math.abs(mouthResult);
                lastReusult = yearResult * 12 + mouthResult;
            } else {
                mouthResult = c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH);
                mouthResult = mouthResult == 0 ? 0 : Math.abs(mouthResult);
                lastReusult = yearResult * 12 - mouthResult;
            }
        } else {
            yearResult = c1.get(Calendar.YEAR) - c2.get(Calendar.YEAR);
            if (c1.get(Calendar.MONTH) > c2.get(Calendar.MONTH)) {
                mouthResult = c1.get(Calendar.MONTH) - c2.get(Calendar.MONTH);
                mouthResult = mouthResult == 0 ? 0 : Math.abs(mouthResult);
                lastReusult = yearResult * 12 + mouthResult;
            } else {
                mouthResult = c1.get(Calendar.MONTH) - c2.get(Calendar.MONTH);
                mouthResult = mouthResult == 0 ? 0 : Math.abs(mouthResult);
                lastReusult = yearResult * 12 - mouthResult;
            }
        }
        return lastReusult;
    }

    /**
     * 计算两个日期相差的月数
     * 两个参数大小可以不区分
     * 
     * @return 月数
     */
    public static int getMonthSpace(Date date1, Date date2) {
        int mouthResult = 0;
        int yearResult = 0;
        int lastReusult = 0;
        boolean mark = false;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String d1 = sdf.format(date1);
        String d2 = sdf.format(date2);
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        try {
            c1.setTime(sdf.parse(d1));
            c2.setTime(sdf.parse(d2));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (c2.get(Calendar.YEAR) > c1.get(Calendar.YEAR)) {
            mark = true;
        } else if ((c2.get(Calendar.YEAR) == c1.get(Calendar.YEAR))
                && (c2.get(Calendar.MONTH) > c1.get(Calendar.MONTH))) {
            mark = true;
        } else if ((c2.get(Calendar.YEAR) == c1.get(Calendar.YEAR))
                && (c2.get(Calendar.MONTH) > c1.get(Calendar.MONTH))
                && (c2.get(Calendar.DAY_OF_MONTH) > c1.get(Calendar.DAY_OF_MONTH))) {
            mark = true;
        }

        if (mark) {
            yearResult = c2.get(Calendar.YEAR) - c1.get(Calendar.YEAR);
            if (c2.get(Calendar.MONTH) > c1.get(Calendar.MONTH)) {
                mouthResult = c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH);
                mouthResult = mouthResult == 0 ? 0 : Math.abs(mouthResult);
                lastReusult = yearResult * 12 + mouthResult;
            } else {
                mouthResult = c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH);
                mouthResult = mouthResult == 0 ? 0 : Math.abs(mouthResult);
                lastReusult = yearResult * 12 - mouthResult;
            }
        } else {
            yearResult = c1.get(Calendar.YEAR) - c2.get(Calendar.YEAR);
            if (c1.get(Calendar.MONTH) > c2.get(Calendar.MONTH)) {
                mouthResult = c1.get(Calendar.MONTH) - c2.get(Calendar.MONTH);
                mouthResult = mouthResult == 0 ? 0 : Math.abs(mouthResult);
                lastReusult = yearResult * 12 + mouthResult;
            } else {
                mouthResult = c1.get(Calendar.MONTH) - c2.get(Calendar.MONTH);
                mouthResult = mouthResult == 0 ? 0 : Math.abs(mouthResult);
                lastReusult = yearResult * 12 - mouthResult;
            }
        }
        return lastReusult;
    }

    /**
     * 计算两个日期相差的天数
     * 两个参数大小可以不区分
     * 
     * @return 天数
     */
    public static int getDaySpace(String date1, String date2) {
        int result = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date d1 = sdf.parse(date1);
            Date d2 = sdf.parse(date2);
            result = (int) ((d1.getTime() / 1000l - d2.getTime() / 1000l) / 3600l / 24l);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return Math.abs(result);
    }

    /**
     * 计算两个日期相差的天数
     * 两个参数大小可以不区分
     * 
     * @return 天数
     */
    public static int getDaySpace(Date date1, Date date2) {
        int result = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date d1 = sdf.parse(sdf.format(date1));
            Date d2 = sdf.parse(sdf.format(date2));
            result = (int) ((d1.getTime() / 1000l - d2.getTime() / 1000l) / 3600l / 24l);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return Math.abs(result);
    }

    /**
     * 两个时间相差多少个小时
     * 两个参数大小可以不区分
     * 
     * @return
     */
    public static int getHoursSpace(String date1, String date2) {
        int result = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            Date d1 = sdf.parse(date1);
            Date d2 = sdf.parse(date2);
            result = (int) ((d1.getTime() / 1000l - d2.getTime() / 1000l) / 3600l);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return Math.abs(result);
    }

    /**
     * 两个时间相差多少个小时
     * 两个参数大小可以不区分
     * 
     * @return 小时数
     */
    public static int getHoursSpace(Date date1, Date date2) {
        int result = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            Date d1 = sdf.parse(sdf.format(date1));
            Date d2 = sdf.parse(sdf.format(date2));
            result = (int) ((d1.getTime() / 1000l - d2.getTime() / 1000l) / 3600l);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return Math.abs(result);
    }

    /**
     * 获取日期之间相差的哪些天数
     * 
     * @param date1
     *            开始时间
     * @param date2
     *            结束时间
     * @return 天数 list [2016-2-1,2016-2-2]
     */
    public static List<String> getDaySpaceList(String date1, String date2) {
        GregorianCalendar gc = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<String> list = new ArrayList<String>();
        try {
            String tempDate = "";
            String startDate = sdf.format(sdf.parse(date1));
            String endDate = sdf.format(sdf.parse(date2));
            Date d1 = sdf.parse(date1);
            list.add(startDate);
            while (!startDate.equals(endDate)) {
                gc.setTime(d1);
                gc.add(5, 1);
                d1 = gc.getTime();
                tempDate = sdf.format(d1);
                startDate = tempDate;
                list.add(tempDate);
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 获取日期之间相差的哪些月数
     * 
     * @param date1
     *            开始时间
     * @param date2
     *            结束时间
     * @return 天数
     */
    public static List<String> getMouthSpaceList(String date1, String date2) {
        GregorianCalendar gc = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        List<String> list = new ArrayList<String>();
        try {
            String tempDate = "";
            String startDate = sdf.format(sdf.parse(date1));
            String endDate = sdf.format(sdf.parse(date2));
            Date d1 = sdf.parse(date1);
            list.add(startDate);
            while (!startDate.equals(endDate)) {
                gc.setTime(d1);
                gc.add(2, 1);
                d1 = gc.getTime();
                tempDate = sdf.format(d1);
                startDate = tempDate;
                list.add(tempDate);
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 计算两个日期相差的年数
     * 
     * @param date1
     *            开始时间
     * @param date2
     *            结束时间
     * @return 天数
     */
    public static List<String> getYearSpaceList(String date1, String date2) {
        GregorianCalendar gc = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        List<String> list = new ArrayList<String>();
        try {
            String tempDate = "";
            String startDate = sdf.format(sdf.parse(date1));
            String endDate = sdf.format(sdf.parse(date2));
            Date d1 = sdf.parse(date1);
            list.add(startDate);
            while (!startDate.equals(endDate)) {
                gc.setTime(d1);
                gc.add(1, 1);
                d1 = gc.getTime();
                tempDate = sdf.format(d1);
                startDate = tempDate;
                list.add(tempDate);
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return list;
    }

}
