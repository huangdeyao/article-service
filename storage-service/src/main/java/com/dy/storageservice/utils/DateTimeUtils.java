package com.dy.storageservice.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间类
 */
public class DateTimeUtils {

    private long lNow = System.currentTimeMillis();
    private Calendar cNow = Calendar.getInstance();
    private Date dNow = new Date(lNow);
    private Timestamp tNow = new Timestamp(lNow);
    private java.sql.Date today = new java.sql.Date(lNow);
    private java.sql.Time now = new java.sql.Time(lNow);

    /**
     * 默认构造方法
     */
    public DateTimeUtils() {

    }

    /**
     * 得到年
     *
     * @param c
     * @return
     */
    public static int getYear(Calendar c) {
        if (c != null) {
            return c.get(Calendar.YEAR);
        } else {
            return Calendar.getInstance().get(Calendar.YEAR);
        }
    }

    /**
     * 得到月份
     * 注意，这里的月份依然是从0开始的
     *
     * @param c
     * @return
     */
    public static int getMonth(Calendar c) {
        if (c != null) {
            return c.get(Calendar.MONTH);
        } else {
            return Calendar.getInstance().get(Calendar.MONTH);
        }
    }

    /**
     * 得到日期
     *
     * @param c
     * @return
     */
    public static int getDate(Calendar c) {
        if (c != null) {
            return c.get(Calendar.DATE);
        } else {
            return Calendar.getInstance().get(Calendar.DATE);
        }
    }

    /**
     * 得到星期
     *
     * @param c
     * @return
     */
    public static int getDay(Calendar c) {
        if (c != null) {
            return c.get(Calendar.DAY_OF_WEEK);
        } else {
            return Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
        }
    }

    /**
     * 得到小时
     *
     * @param c
     * @return
     */
    public static int getHour(Calendar c) {
        if (c != null) {
            return c.get(Calendar.HOUR);
        } else {
            return Calendar.getInstance().get(Calendar.HOUR);
        }
    }

    /**
     * 得到分钟
     *
     * @param c
     * @return
     */
    public static int getMinute(Calendar c) {
        if (c != null) {
            return c.get(Calendar.MINUTE);
        } else {
            return Calendar.getInstance().get(Calendar.MINUTE);
        }
    }

    /**
     * 得到秒
     *
     * @param c
     * @return
     */
    public static int getSecond(Calendar c) {
        if (c != null) {
            return c.get(Calendar.SECOND);
        } else {
            return Calendar.getInstance().get(Calendar.SECOND);
        }
    }

    /**
     * 得到指定或者当前时间前n天的Calendar
     *
     * @param c
     * @param n
     * @return
     */
    public static Calendar beforeNDays(Calendar c, int n) {
        //偏移量，给定n天的毫秒数
        long offset = n * 24 * 60 * 60 * 1000;
        Calendar calendar = null;
        if (c != null) {
            calendar = c;
        } else {
            calendar = Calendar.getInstance();
        }

        calendar.setTimeInMillis(calendar.getTimeInMillis() - offset);
        return calendar;
    }

    /**
     * 得到指定或者当前时间后n天的Calendar
     *
     * @param c
     * @param n
     * @return
     */
    public static Calendar afterNDays(Calendar c, int n) {
        //偏移量，给定n天的毫秒数
        long offset = n * 24 * 60 * 60 * 1000;
        Calendar calendar = null;
        if (c != null) {
            calendar = c;
        } else {
            calendar = Calendar.getInstance();
        }

        calendar.setTimeInMillis(calendar.getTimeInMillis() + offset);
        return calendar;
    }

    /**
     * 昨天
     *
     * @param c
     * @return
     */
    public static Calendar yesterday(Calendar c) {
        long offset = 1 * 24 * 60 * 60 * 1000;
        Calendar calendar = null;
        if (c != null) {
            calendar = c;
        } else {
            calendar = Calendar.getInstance();
        }

        calendar.setTimeInMillis(calendar.getTimeInMillis() - offset);
        return calendar;
    }

    /**
     * 明天
     *
     * @param c
     * @return
     */
    public static Calendar tomorrow(Calendar c) {
        long offset = 1 * 24 * 60 * 60 * 1000;
        Calendar calendar = null;
        if (c != null) {
            calendar = c;
        } else {
            calendar = Calendar.getInstance();
        }

        calendar.setTimeInMillis(calendar.getTimeInMillis() + offset);
        return calendar;
    }

    /**
     * 得到指定或者当前时间前offset毫秒的Calendar
     *
     * @param c
     * @param offset
     * @return
     */
    public static Calendar before(Calendar c, long offset) {
        Calendar calendar = null;
        if (c != null) {
            calendar = c;
        } else {
            calendar = Calendar.getInstance();
        }

        calendar.setTimeInMillis(calendar.getTimeInMillis() - offset);
        return calendar;
    }

    /**
     * 得到指定或者当前时间前offset毫秒的Calendar
     *
     * @param c
     * @param offset
     * @return
     */
    public static Calendar after(Calendar c, long offset) {
        Calendar calendar = null;
        if (c != null) {
            calendar = c;
        } else {
            calendar = Calendar.getInstance();
        }

        calendar.setTimeInMillis(calendar.getTimeInMillis() - offset);
        return calendar;
    }

    /**
     * 日期格式化
     *
     * @param c
     * @param pattern
     * @return
     */
    public static String format(Calendar c, String pattern) {
        Calendar calendar = null;
        if (c != null) {
            calendar = c;
        } else {
            calendar = Calendar.getInstance();
        }
        if (pattern == null || pattern.equals("")) {
            pattern = "yyyy年MM月dd日 HH:mm:ss";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);

        return sdf.format(calendar.getTime());
    }

    /**
     * Date类型转换到Calendar类型
     *
     * @param d
     * @return
     */
    public static Calendar Date2Calendar(Date d) {
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        return c;
    }

    /**
     * Calendar类型转换到Date类型
     *
     * @param c
     * @return
     */
    public static Date Calendar2Date(Calendar c) {
        return c.getTime();
    }

    /**
     * Date类型转换到Timestamp类型
     *
     * @param d
     * @return
     */
    public static Timestamp Date2Timestamp(Date d) {
        return new Timestamp(d.getTime());
    }

    /**
     * Calendar类型转换到Timestamp类型
     *
     * @param c
     * @return
     */
    public static Timestamp Calendar2Timestamp(Calendar c) {
        return new Timestamp(c.getTimeInMillis());
    }

    /**
     * Timestamp类型转换到Calendar类型
     *
     * @param ts
     * @return
     */
    public static Calendar Timestamp2Calendar(Timestamp ts) {
        Calendar c = Calendar.getInstance();
        c.setTime(ts);
        return c;
    }

    /**
     * 得到当前时间的字符串表示
     * 格式2010-02-02 12:12:12
     *
     * @return
     */
    public static String getTimeString() {
        return format(Calendar.getInstance(), "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 得到当前时间的字符串表示
     * 格式2010-02-02 12:12:12
     *
     * @return
     */
    public static String getDayString() {
        return format(Calendar.getInstance(), "yyyy-MM-dd");
    }
    /**
     * 得到当前时间的字符串表示
     * 格式2010-02-02 12:12:12
     *
     * @return
     */
    public static String getTimeZZZ() {
        return format(Calendar.getInstance(), "yyyyMMddhhmmssSSS");
    }

    /**
     * 时间戳   1531731792 转换 2018-07-16 17:03:12
     *
     * @param time
     * @return
     */
    public static String getTimestamp(String time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date(Long.valueOf(time)));
    }

    /**
     * 时间差 精确到天
     *
     * @param start 开始时间
     * @param end   结束时间
     * @return
     */
    public static long dayTime(Date start, Date end) {
        if (start == null || end == null) {
            return 0;
        }
        long diff = start.getTime() - end.getTime();//这样得到的差值是微秒级别
        long days = diff / (1000 * 60 * 60 * 24);
        System.out.println("" + days + "天");
        return days;
    }

    /**
     * 时间差 精确到分钟
     *
     * @param start 开始时间
     * @param end   结束时间
     * @return
     */
    public static long minusTime(Date start, Date end) {
        if (start == null || end == null) {
            return 0;
        }
        long diff = start.getTime() - end.getTime();//这样得到的差值是微秒级别
        long days = diff / (1000 * 60 * 60 * 24);

        long hours = (diff - days * (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
        long minutes = (diff - days * (1000 * 60 * 60 * 24) - hours * (1000 * 60 * 60)) / (1000 * 60);
        System.out.println("" + days + "天" + hours + "小时" + minutes + "分");
        long time = minutes + hours * 60 + days * 24 * 60;

        return time;
    }


    /**
     * 时间差 精确到秒
     *
     * @param start 开始时间
     * @param end   结束时间
     * @return
     */
    public static long secondTime(Date start, Date end) {
        if (start == null || end == null) {
            return 0;
        }
        long between = start.getTime() - end.getTime();
        long days = between / (24 * 60 * 60 * 1000);
        long hours = (between / (60 * 60 * 1000) - days * 24);
        long minutes = ((between / (60 * 1000)) - days * 24 * 60 - hours * 60);
        long second = (between / 1000 - days * 24 * 60 * 60 - hours * 60 * 60 - minutes * 60);

        long time = second + minutes * 60 + hours * 60 * 60 + days * 24 * 60 * 60;

        return time;
    }

    /**
     * 将长时间格式字符串转换为时间 yyyy-MM-dd HH:mm:ss
     *
     * @param strDate
     * @return
     */
    public static Date strToDateLong(String strDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse(strDate, pos);
        return strtodate;
    }


    /**
     * 判断当前日期是否在时间点内
     *
     * @param date         当前时间
     * @param strDateBegin 开始时间
     * @param strDateEnd   结束时间
     * @return
     */
    public boolean isInDate(Date date, String strDateBegin,
                                   String strDateEnd) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strDate = sdf.format(date);
        // 截取当前时间时分秒
        int strDateH = Integer.parseInt(strDate.substring(11, 13));
        int strDateM = Integer.parseInt(strDate.substring(14, 16));
        int strDateS = Integer.parseInt(strDate.substring(17, 19));
        // 截取开始时间时分秒
        int strDateBeginH = Integer.parseInt(strDateBegin.substring(0, 2));
        int strDateBeginM = Integer.parseInt(strDateBegin.substring(3, 5));
        int strDateBeginS = Integer.parseInt(strDateBegin.substring(6, 8));
        // 截取结束时间时分秒
        int strDateEndH = Integer.parseInt(strDateEnd.substring(0, 2));
        int strDateEndM = Integer.parseInt(strDateEnd.substring(3, 5));
        int strDateEndS = Integer.parseInt(strDateEnd.substring(6, 8));
        if ((strDateH >= strDateBeginH && strDateH <= strDateEndH)) {
            // 当前时间小时数在开始时间和结束时间小时数之间
            if (strDateH > strDateBeginH && strDateH < strDateEndH) {
                return true;
                // 当前时间小时数等于开始时间小时数，分钟数在开始和结束之间
            } else if (strDateH == strDateBeginH && strDateM >= strDateBeginM
                    && strDateM <= strDateEndM) {
                return true;
                // 当前时间小时数等于开始时间小时数，分钟数等于开始时间分钟数，秒数在开始和结束之间
            } else if (strDateH == strDateBeginH && strDateM == strDateBeginM
                    && strDateS >= strDateBeginS && strDateS <= strDateEndS) {
                return true;
            }
            // 当前时间小时数大等于开始时间小时数，等于结束时间小时数，分钟数小等于结束时间分钟数
            else if (strDateH >= strDateBeginH && strDateH == strDateEndH
                    && strDateM <= strDateEndM) {
                return true;
                // 当前时间小时数大等于开始时间小时数，等于结束时间小时数，分钟数等于结束时间分钟数，秒数小等于结束时间秒数
            } else if (strDateH >= strDateBeginH && strDateH == strDateEndH
                    && strDateM == strDateEndM && strDateS <= strDateEndS) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }


    /**
     * 判断时间是否在时间段内
     *
     * @param nowTime
     * @param beginTime
     * @param endTime
     * @return
     */
    public  static boolean belongCalendar(Date nowTime, Date beginTime, Date endTime) {
        Calendar date = Calendar.getInstance();
        date.setTime(nowTime);
        Calendar begin = Calendar.getInstance();
        begin.setTime(beginTime);
        Calendar end = Calendar.getInstance();
        end.setTime(endTime);
        if (date.after(begin) && date.before(end)) {
            return true;
        } else if (nowTime.compareTo(beginTime) == 0 || nowTime.compareTo(endTime) == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断某时间段属于上午下午还是全天
     *
     * @param start 开始时间
     * @param end   结束时间
     * @return 1 是上午  2 是下午  3 全天  0 错误
     * @throws ParseException
     */
    private static int checkForenoon(Date start, Date end) throws ParseException {
        String sday = dateFormatStr(start);
        Date middle = strFormatDate(sday + " 12:00:00"); //得到当天中午数据
        if (start.compareTo(middle) < 0 && end.compareTo(middle) == 0) { //上午 start:2017-09-07 00:00:00.0 end:2017-09-07 12:00:00.0
            return 1;
        }
        if (start.compareTo(middle) == 0 && end.compareTo(middle) > 0) { //下午 2016-08-05 12:00:00.0 end:2016-08-05 23:59:59.0
            return 2;
        }
        if (start.compareTo(middle) < 0 && end.compareTo(middle) > 0) {//全天 start:2017-09-06 00:00:00.0 end:2017-09-06 23:59:59.0
            return 3;
        }
        return 0;
    }

    /**
     * 日期格式化
     *
     * @param date return  格式化字符串如 2017-09-07
     * @param date
     */
    public static String dateFormatStr(Date date) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String time = format.format(date);
//		System.out.println("时间:" + time);
        return time;
    }

    /**
     * 字符串日期转为Date
     *
     * @param ld
     * @throws ParseException
     */
    public static Date strFormatDate(String ld) throws ParseException {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date lendDate = format.parse(ld);
//		System.out.println(lendDate);
        return lendDate;
    }

    /**
     * 时间格式化
     *
     * @param date return  格式化字符串如 2017-09-07 12:00:00
     * @param date
     */
    public static String timeFormatStr(Date date) {
        if (date == null)
            return null;
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = format.format(date);
//		System.out.println("时间:" + time);
        return time;
    }


    /**
     * 标准日期格式字符串解析成Calendar对象
     *
     * @param s
     * @return
     */
    public static Calendar pars2Calender(String s) {
        Timestamp ts = Timestamp.valueOf(s);
        return Timestamp2Calendar(ts);
    }

    //================以下是get和set方法=========================//

    public long getLNow() {
        return lNow;
    }

    public void setLNow(long now) {
        lNow = now;
    }

    public Calendar getCNow() {
        return cNow;
    }

    public void setCNow(Calendar now) {
        cNow = now;
    }

    public Date getDNow() {
        return dNow;
    }

    public void setDNow(Date now) {
        dNow = now;
    }

    public Timestamp getTNow() {
        return tNow;
    }

    public void setTNow(Timestamp now) {
        tNow = now;
    }

    public java.sql.Date getToday() {
        return today;
    }

    public void setToday(java.sql.Date today) {
        this.today = today;
    }

    public java.sql.Time getNow() {
        return now;
    }

    public void setNow(java.sql.Time now) {
        this.now = now;
    }


    /**
     * 得到几天前的时间
     * @param d
     * @param day
     * @return
     */
    public static Date getDateBefore(Date d,int day){
        Calendar now =Calendar.getInstance();
        now.setTime(d);
        now.set(Calendar.DATE,now.get(Calendar.DATE)-day);
        return now.getTime();
    }

    /**
     * 得到几天后的时间
     * @param d
     * @param day
     * @return
     */
    public static Date getDateAfter(Date d,int day){
        Calendar now =Calendar.getInstance();
        now.setTime(d);
        now.set(Calendar.DATE,now.get(Calendar.DATE)+day);
        return now.getTime();
    }

    /**
     * 通过时间秒毫秒数判断两个时间的间隔
     * @param end
     * @param start
     * @return
     */
    public static int differentDaysByMillisecond(Date start,Date end)
    {
        int days = (int) ((end.getTime() - start.getTime()) / (1000*3600*24));
        return days;
    }

    /**
     *
     * @param date
     * @param days
     * @return
     */
    public Date addDays(Date date,int days){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DAY_OF_YEAR,days);

        return c.getTime();
    }


    /**
     * @param args
     */
    public static void main(String[] args) {
        String time = getTimeString();
        System.out.println("time==>" + time);
//        2018-09-02 16:17:01

        String str = time.substring(0,4) + time.substring(5,7) + time.substring(8,10)
                + time.substring(11,13) + time.substring(14,16) + time.substring(17,19);

//        + time.substring(5,6);
//        + time.substring(9,10) + time.substring(12,13) + time.substring(15,16)+time.substring(18,19);
        System.out.println("str==>" + str);
        System.out.println("time==>" + time);
    }

}