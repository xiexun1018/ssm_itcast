package cn.itcast.ssm.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author:xiexun
 * @date:2018/11/13
 * @time:14:55
 */
public class DateUtil {

    public static String dateToString(Date date, String pattern){
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String format = sdf.format(date);
        return format;
    }

    public static Date stringToDate(String str,String pattern) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date parse = sdf.parse(str);
        return parse;
    }
}
