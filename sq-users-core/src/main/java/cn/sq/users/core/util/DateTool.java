package cn.sq.users.core.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateTool {

    //获取分钟前/后的时间
    public static String getTime(int num) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MINUTE, num);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(cal.getTimeInMillis());
    }
}
