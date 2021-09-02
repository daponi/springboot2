package com.jdk8.www;

import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class TestJdk8Time {

    @Test
    void tese(){
        LocalTime now = LocalTime.now();
        LocalTime of = LocalTime.of(11, 32, 01);

        //用第二个参数减去第一个参数
        Duration between = Duration.between(now, of);
//        Duration between = Duration.between(of, now);
        System.out.println("now "+now);
        System.out.println("of: "+of);
        System.out.println("Day"+between.toDays());
        System.out.println("Hours:"+between.toHours());
        System.out.println("Minutes:" + between.toMinutes());
        System.out.println("Millis"+between.toMillis());
        System.out.println("Nanos:"+between.toNanos());

        System.out.println("------------------------分割线-----------------------");


        LocalDate localDate = LocalDate.now();
        LocalDate date = LocalDate.of(2022, 9, 1);

        System.out.println(localDate);
        System.out.println(date);
        Period period = Period.between(localDate, date);
        System.out.println("Year:" + period.getYears());
        System.out.println("Month:" + period.getMonths());
        System.out.println("Days:" + period.getDays());

        System.out.println("------------------------分割线-----------------------");


        LocalDateTime lo = LocalDateTime.now();
        TemporalAdjuster adjuster=temporal -> {
            LocalDateTime ldt = (LocalDateTime) temporal;
            return ldt.plusMonths(3).withDayOfMonth(1);
        };
        System.out.println(lo);
        System.out.println(lo.with(adjuster));
        System.out.println(lo.with(TemporalAdjusters.firstDayOfNextMonth()));


    }
}
