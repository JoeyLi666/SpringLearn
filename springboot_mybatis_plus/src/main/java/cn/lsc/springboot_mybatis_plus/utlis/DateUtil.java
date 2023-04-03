package cn.lsc.springboot_mybatis_plus.utlis;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class DateUtil {
    private static final String YYYY_MM_DD_HH_MM_SS =  "yyyy-MM-dd HH:mm:ss.SSS";
    private static final ThreadLocal<SimpleDateFormat> threadLocalDateFormat = ThreadLocal.withInitial(() -> new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS, Locale.US));
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(YYYY_MM_DD_HH_MM_SS);

    /**
     * SimpleDateFormat要结合ThreadLocal使用,避免并发问题
     */
    public static String formatBySimpleDateFormat(Date date, String... pattern){
        SimpleDateFormat simpleDateFormat = threadLocalDateFormat.get();
        if (pattern.length > 0) {
            simpleDateFormat.applyPattern(pattern[0]);
        }
        return simpleDateFormat.format(date);
    }


    /**
     * java8新增的方法
     */
    public static String formatByDateTimeFormatter(Date date, String... pattern){
        LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        if (pattern.length > 0) {
            return DateTimeFormatter.ofPattern(pattern[0]).withZone(ZoneId.systemDefault()).format(localDateTime);
        }
        return dateTimeFormatter.format(localDateTime);
    }

    /**
     * 阿帕奇的方法
     */
    public static String formatApacheDateFormatUtils(Date date, String... pattern){
        if (pattern.length > 0) {
            return DateFormatUtils.format(date, pattern[0]);
        }
        return DateFormatUtils.format(date, YYYY_MM_DD_HH_MM_SS);
    }
}
