package com.modernJava.newDateAndTimeAPI;

import java.time.*;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class NewDateAndTimeAPI {
    public static void main(String[] args) {
        Date date1 = new Date(117, 8, 21);
        System.out.println("date1: " + date1);

        LocalDate date2 = LocalDate.of(2017, 9, 21);
        int year1 = date2.getYear();
        Month month1 = date2.getMonth();
        int day1 = date2.getDayOfMonth();
        DayOfWeek dayOfWeek1 = date2.getDayOfWeek();
        int len1 = date2.lengthOfMonth();
        boolean leap1 = date2.isLeapYear();
        System.out.println("year1: " + year1);
        System.out.println("month1: " + month1);
        System.out.println("day1: " + day1);
        System.out.println("dayOfWeek1: " + dayOfWeek1);
        System.out.println("len1: " + len1);
        System.out.println("leap1: " + leap1);

        LocalDate today = LocalDate.now();
        System.out.println("today: " + today);

        int year2 = date2.get(ChronoField.YEAR);
        int month2 = date2.get(ChronoField.MONTH_OF_YEAR);
        int day2 = date2.get(ChronoField.DAY_OF_MONTH);
        System.out.println("year2: " + year2);
        System.out.println("month2: " + month2);
        System.out.println("day2: " + day2);

        LocalTime time1 = LocalTime.of(13, 45, 20);
        int hour1 = time1.getHour();
        int minute1 = time1.getMinute();
        int second1 = time1.getSecond();
        System.out.println("hour1: " + hour1);
        System.out.println("minute1: " + minute1);
        System.out.println("second1: " + second1);

        LocalDate date3 = LocalDate.parse("2017-09-21");
        LocalTime time2 = LocalTime.parse("13:45:20");
        System.out.println("date3: " + date3);
        System.out.println("time2: " + time2);

        LocalDateTime dt1 = LocalDateTime.of(2017, Month.SEPTEMBER, 21, 13, 45, 20);
        LocalDateTime dt2 = LocalDateTime.of(date3, time2);
        LocalDateTime dt3 = date3.atTime(13, 45, 20);
        LocalDateTime dt4 = date3.atTime(time2);
        LocalDateTime dt5 = time2.atDate(date3);
        System.out.println("dt1: " + dt1);
        System.out.println("dt2: " + dt2);
        System.out.println("dt3: " + dt3);
        System.out.println("dt4: " + dt4);
        System.out.println("dt5: " + dt5);

        LocalTime time3 = dt3.toLocalTime();
        LocalDate date4 = dt4.toLocalDate();
        System.out.println("time3: " + time3);
        System.out.println("date4: " + date4);

        Instant instant1 = Instant.ofEpochSecond(3);
        Instant instant2 = Instant.ofEpochSecond(3, 0);
        Instant instant3 = Instant.ofEpochSecond(2, 1_000_000_000);
        Instant instant4 = Instant.ofEpochSecond(4, -1_000_000_000);
        System.out.println("instant1: " + instant1);
        System.out.println("instant2: " + instant2);
        System.out.println("instant3: " + instant3);
        System.out.println("instant4: " + instant4);

        /**
         * Exception in thread "main" java.time.temporal.UnsupportedTemporalTypeException: Unsupported field: DayOfMonth
         * */
//        int day3 = Instant.now().get(ChronoField.DAY_OF_MONTH);
//        System.out.println("day3: " + day3);

        Duration d1 = Duration.between(time1, time2);
        Duration d2 = Duration.between(dt1, dt2);
        Duration d3 = Duration.between(dt1, dt2);
        System.out.println("d1: " + d1);
        System.out.println("d2: " + d2);
        System.out.println("d3: " + d3);

        Period tenDays1 = Period.between(LocalDate.of(2017, 9, 11),
                                        LocalDate.of(2017, 9, 21));
        System.out.println("tenDays1: " + tenDays1);

        Duration threeMinutes1 = Duration.ofMinutes(3);
        Duration threeMinutes2 = Duration.of(3, ChronoUnit.MINUTES);

        Period tenDays2 = Period.ofDays(10);
        Period threeWeeks = Period.ofWeeks(3);
        Period twoYearsSixMonthOneDay = Period.of(2, 6, 1);
        System.out.println("threeMinutes1: " + threeMinutes1);
        System.out.println("threeMinutes2: " + threeMinutes2);
        System.out.println("tenDays2: " + tenDays2);
        System.out.println("threeWeeks: " + threeWeeks);
        System.out.println("twoYearsSixMonthOneDay: " + twoYearsSixMonthOneDay);
    }
}
