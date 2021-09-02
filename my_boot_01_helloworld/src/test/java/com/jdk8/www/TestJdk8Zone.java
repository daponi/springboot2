package com.jdk8.www;

import org.junit.jupiter.api.Test;

import java.net.Socket;
import java.sql.SQLOutput;
import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;

public class TestJdk8Zone {
    @Test
    public void testZone(){
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        System.out.println(availableZoneIds);
//        availableZoneIds.forEach(System.out::println);
        System.out.println("----------------分割线--------------");


        ZonedDateTime now = ZonedDateTime.now(Clock.systemUTC());
        ZonedDateTime now2 = ZonedDateTime.now(Clock.systemDefaultZone());
        System.out.println("系统当前时间:"+LocalDateTime.now());
        System.out.println("系统当前时间:"+now2);
        System.out.println("世界标准时间" + now);

        ZonedDateTime of = ZonedDateTime.now(ZoneId.of("America/New_York"));
        System.out.println("指定时区的时间:"+of);

        System.out.println(ZonedDateTime.now());

        System.out.println("当前纽约时间"+ZonedDateTime.now(ZoneId.of("America/New_York")));
        //withZoneSameInstant():既更改时区,也更改时间
        ZonedDateTime modifyTime = (ZonedDateTime.now(ZoneId.of("America/New_York")).withZoneSameInstant(ZoneId.of("Asia/Shanghai")));
        System.out.println("修改时区后的时间:"+modifyTime);

        //withZoneSameLocal():只更改时区,不更改时间
        ZonedDateTime modifyTime2 = (ZonedDateTime.now(ZoneId.of("America/New_York")).withZoneSameLocal(ZoneId.of("Asia/Shanghai")));
        System.out.println("修改时区后的时间:"+modifyTime2);


    }
}
