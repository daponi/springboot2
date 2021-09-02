package com.jdk8.www;


import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestJdk8Template {


    @Test
    public void testJDK8(){
        LocalDate now = LocalDate.now();
        System.out.println(now);

        LocalDate of = LocalDate.of(2021, 9, 1);
        System.out.println(of);
        System.out.println(of.getYear());
        System.out.println(of.getMonth()+"----"+of.getMonthValue());

        LocalDate with = now.withYear(2020);
        System.out.println("now："+now +"\nwith:"+with);
        DateTimeFormatter isoDateTime = DateTimeFormatter.ISO_DATE_TIME;
        LocalDateTime now1 = LocalDateTime.now();
        String format = now1.format(isoDateTime);
        System.out.println("format:"+format);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy年-MM月-dd日 HH时-mm分-ss秒");
        String format1 = now1.format(dateTimeFormatter);
        System.out.println(format1);

        LocalDateTime parse = LocalDateTime.parse(format1, dateTimeFormatter);
        System.out.println(parse);

        Instant now2 = Instant.now();
        System.out.println("Instant:"+now);

        long epochSecond = now2.getEpochSecond();
        System.out.println("秒："+epochSecond);

        int nano = now2.getNano();
        System.out.println("纳秒："+nano);

        long l = now2.toEpochMilli();
        System.out.println("毫秒:"+l);

    }

}
