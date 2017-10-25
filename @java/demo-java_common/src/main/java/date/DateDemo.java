package date;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.commons.lang.time.FastDateFormat;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author liuxiang on 2017/9/7.
 */
public class DateDemo {

    static void dateConvert() throws ParseException {
        Date date;
        String dateStr;

        /****[* - date]*********************/
        // string -> date
        date = new SimpleDateFormat("yyyy-MM-dd").parse("2017-09-07");
        System.out.println(FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss").format(date));

        // time -> date
        date = new Date(System.currentTimeMillis() - (1000 * 60 * 60 * 1));// 上一小时time
        System.out.println(FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss").format(date));

        /****[* - String]*********************/
        // date -> string
        dateStr = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss").format(new Date());
        System.out.println(dateStr);

        // time -> String
        dateStr = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis());
        System.out.println(dateStr);

        /****[* - Timestamp]*********************/
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp);// 2017-09-07 18:46:19.601

        LocalDateTime localDateTime = new Timestamp(System.currentTimeMillis()).toLocalDateTime();
    }

    static void calendarDemo() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + 2 + 1);// 2+1天后的0点0分0秒
        System.out.println(FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss").format(calendar));// 2017-09-7 00:00:00 -> 2017-09-10 00:00:00

        calendar = Calendar.getInstance();
        calendar.set(2018, 2, 15, 8, 31, 5);
        System.out.println(FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss").format(calendar));// 2018-03-15 08:31:05

        calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        System.out.println(FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss").format(calendar));// 2018-03-15 08:31:05

        calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 0);
        System.out.println(FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss").format(calendar));// 2018-03-15 08:31:05
    }

    /**
     * value为正则往后,为负则往前
     * field取1加1年,取2加半年,取3加一季度,取4加一周,取5加一天
     */
    static void gregorianCalendar() {
        GregorianCalendar gc = new GregorianCalendar() {{
            setTime(new Date());
            add(5, 1);// 加1天
        }};
        System.out.println(DateFormatUtils.format(gc.getTime(), "yyyy-MM-dd HH:mm:ss"));
    }

    static void dateUtil() throws ParseException {
//        public class DateFormatUtils {
//            public static final FastDateFormat ISO_DATETIME_FORMAT = FastDateFormat.getInstance("yyyy-MM-dd'T'HH:mm:ss");
//            public static final FastDateFormat ISO_DATETIME_TIME_ZONE_FORMAT = FastDateFormat.getInstance("yyyy-MM-dd'T'HH:mm:ssZZ");
//            public static final FastDateFormat ISO_DATE_FORMAT = FastDateFormat.getInstance("yyyy-MM-dd");
//            public static final FastDateFormat ISO_DATE_TIME_ZONE_FORMAT = FastDateFormat.getInstance("yyyy-MM-ddZZ");
//            public static final FastDateFormat ISO_TIME_FORMAT = FastDateFormat.getInstance("'T'HH:mm:ss");
//            public static final FastDateFormat ISO_TIME_TIME_ZONE_FORMAT = FastDateFormat.getInstance("'T'HH:mm:ssZZ");
//            public static final FastDateFormat ISO_TIME_NO_T_FORMAT = FastDateFormat.getInstance("HH:mm:ss");
//            public static final FastDateFormat ISO_TIME_NO_T_TIME_ZONE_FORMAT = FastDateFormat.getInstance("HH:mm:ssZZ");

        // * - String
        System.out.println(DateFormatUtils.ISO_DATE_FORMAT.format(new Date()));// 2017-09-07
        System.out.println(DateFormatUtils.ISO_DATETIME_FORMAT.format(System.currentTimeMillis()));// 2017-09-07T19:17:13
        System.out.println(DateFormatUtils.ISO_TIME_NO_T_FORMAT.format(Calendar.getInstance())); // 19:17:13
        System.out.println(DateFormatUtils.format(new Date(), "yyyy-MM-dd"));
        System.out.println(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));

        // * - Date
        Date date = DateUtils.parseDate("2017-09-07", new String[]{"yyyy-MM-dd"});
        System.out.println(FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss").format(date));// 2017-09-07 00:00:00

    }

    public static void main(String[] args) throws Exception {
//        dateConvert();// 时间形式转换
//        calendarDemo();// 日历demo
        gregorianCalendar();
//        dateUtil();
    }
}
