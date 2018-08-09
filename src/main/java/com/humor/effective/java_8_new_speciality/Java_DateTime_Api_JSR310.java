package com.humor.effective.java_8_new_speciality;

import lombok.extern.slf4j.Slf4j;

import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * create by humor
 * @date 2018/8/9 下午2:18
 * @description JSR310 日期与时间规范主要API
 */
@Slf4j
public class Java_DateTime_Api_JSR310 {

    public static void main(String[] args) throws InterruptedException {

//        clock();
//        instant();
//        localDateTime();
//        zonedDateTime();
//        duration();
        other();
    }


    /**
     * 时钟，类似与钟表的概念。提供了系统时钟、固定时钟、特定时钟等
     */
    public static void clock() throws InterruptedException {

        //系统默认UTC时钟（System.currentTimeMillis()）
        Clock clock = Clock.systemUTC();
        //每次调用将返回当前瞬时时间
        log.info("millis {}",clock.millis());//1533796100224
        log.info("millis {}",clock.millis());//1533796100233

        //系统默认时区时钟
        Clock clock1 = Clock.systemDefaultZone();
        log.info("systemDefaultZone {}",clock1.millis());

        //巴黎时区
        Clock clock2 = Clock.system(ZoneId.of("Europe/Paris"));
        System.out.println(clock2.millis()); //每次调用将返回当前瞬时时间（UTC）

        //上海时区
        Clock clock3 = Clock.system(ZoneId.of("Asia/Shanghai"));
        System.out.println(clock3.millis());//每次调用将返回当前瞬时时间（UTC）

        //固定上海时区时钟
        Clock clock4 = Clock.fixed(Instant.now(), ZoneId.of("Asia/Shanghai"));
        System.out.println(clock4.millis());
        Thread.sleep(1000);
        System.out.println(clock4.millis()); //不变 即时钟时钟在那一个点不动

        Clock clock5 = Clock.offset(clock1, Duration.ofSeconds(2));//相对于系统默认时钟两秒的时钟
        System.out.println(clock5.millis());
        System.out.println(clock5.millis());
    }


    /**
     * 瞬时时间
     */
    public static void instant(){
        //等价于以前的System.currentTimeMillis()
        Instant instant = Instant.now();
        //精确到s
        log.info("{}",instant.getEpochSecond());
        //精确到ms
        log.info("{}",instant.toEpochMilli());
    }

    /**
     * 提供了对java.util.Date的替代；
     * 另外还提供了新的DateTimeFormatter用于对格式化/解析的支持
     */
    public static void localDateTime(){

        //使用默认时区时钟瞬时时间创建 Clock.systemDefaultZone()
        LocalDateTime localDateTime = LocalDateTime.now();
        log.info("{}",localDateTime);

        //自定义时区
        LocalDateTime localDateTime1 = LocalDateTime.now(ZoneId.of("Europe/Paris"));
        log.info("{}",localDateTime1);

        //年 月 日 时 分 秒 纳秒
        LocalDateTime localDateTime2 = LocalDateTime.of(2020, 06, 06, 06, 6, 6, 666666666);
        log.info("{}",localDateTime2);

        //String --> LocalDateTime
        LocalDateTime localDateTime3 = LocalDateTime.parse("2018-08-09T15:04:55.106");
        log.info("{}",localDateTime3);

        //使用DateTimeFormatter API 解析和格式化
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        //2018-8-9 15:00:00这种写法不支持，必须写成这种2018-08-09 15:00:00
        //LocalDateTime parse = LocalDateTime.parse("2018-8-9 15:00:00", dateTimeFormatter);
        LocalDateTime parse = LocalDateTime.parse("2018-08-09 15:00:00", dateTimeFormatter);
        log.info("{}",parse);

        System.out.println(localDateTime.getYear());
        System.out.println(localDateTime.getMonthValue());
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getHour());
        System.out.println(localDateTime.getMinute());
        System.out.println(localDateTime.getSecond());
        System.out.println(localDateTime.getNano());//纳秒
    }

    /**
     * 带有时区的date-time 存储纳秒、时区和时差（避免与本地date-time歧义）；
     * API和LocalDateTime类似,只是多了时差(如2013-12-20T10:35:50.711+08:00[Asia/Shanghai])
     */
    public static void zonedDateTime(){
        //即带有时区的date-time 存储纳秒、时区和时差（避免与本地date-time歧义）。
        //API和LocalDateTime类似，只是多了时差(如2013-12-20T10:35:50.711+08:00[Asia/Shanghai])
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now);

        ZonedDateTime now2= ZonedDateTime.now(ZoneId.of("Europe/Paris"));
        System.out.println(now2);

        //其他的用法也是类似的 就不介绍了
        ZonedDateTime z1 = ZonedDateTime.parse("2013-12-31T23:59:59Z[Europe/Paris]");
        System.out.println(z1);
    }

    /**
     * 表示两个瞬时时间的时间段
     */
    public static void duration(){
        Duration duration = Duration.between(Instant.ofEpochMilli(System.currentTimeMillis() - 100000000), Instant.now());

        System.out.println(duration.toDays());
        System.out.println(duration.toHours());
        System.out.println(duration.toMinutes());
        System.out.println(duration.toMillis());
        System.out.println(duration.toNanos());

        Duration duration1 = Duration.ofDays(1);
        System.out.println(duration.toDays());
    }

    /**
     * 提供了年 年月 月日 周期的api支持
     */
    public static void other(){

        Year year = Year.now();
        System.out.println(year);//2018
        YearMonth yearMonth = YearMonth.now();
        System.out.println(yearMonth);//2018-08
        MonthDay monthDay = MonthDay.now();
        System.out.println(monthDay);//--08-09

        //周期，如表示10天前  3年5个月前
        Period period1 = Period.ofDays(10);
        System.out.println(period1);
        Period period2 = Period.of(3, 5, 0);
        System.out.println(period2);

    }
}
