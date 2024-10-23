package com.modernJava.newDateAndTimeAPI;

import java.time.*;
import java.time.chrono.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

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

        LocalDate date5 = LocalDate.of(2017, 9, 21);
        LocalDate date6 = date5.withYear(2011);
        LocalDate date7 = date6.withDayOfMonth(25);
        LocalDate date8 = date7.with(ChronoField.MONTH_OF_YEAR, 2);
        System.out.println("date5: " + date5);
        System.out.println("date6: " + date6);
        System.out.println("date7: " + date7);
        System.out.println("date8: " + date8);

        LocalDate date9 = LocalDate.of(2017, 9, 21);
        LocalDate date10 = date9.plusWeeks(1);
        LocalDate date11 = date10.minusYears(6);
        LocalDate date12 = date11.plus(6, ChronoUnit.MONTHS);
        System.out.println("date9: " + date9);
        System.out.println("date10: " + date10);
        System.out.println("date11: " + date11);
        System.out.println("date12: " + date12);

        LocalDate date13 = LocalDate.of(2014, 3, 18);
        LocalDate date14 = date13.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
        LocalDate date15 = date14.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println("date13: " + date13);
        System.out.println("date14: " + date14);
        System.out.println("date15: " + date15);

        LocalDate date16 = LocalDate.of(2024, 10, 18);
        LocalDate date17 = date16.with(new NextWorkingDay());
        System.out.println("date16: " + date16);
        System.out.println("date17: " + date17);

        LocalDate date18 = LocalDate.of(2024, 10, 18);
        LocalDate date19 = date18.with(temporal -> {
            DayOfWeek dow = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
            int dayToAdd = 1;
            if (dow == DayOfWeek.FRIDAY) dayToAdd = 3;
            else if (dow == DayOfWeek.SATURDAY) dayToAdd = 2;
            return temporal.plus(dayToAdd, ChronoUnit.DAYS);
        });
        System.out.println("date18: " + date18);
        System.out.println("date19: " + date19);

        TemporalAdjuster nextWorkingDay = TemporalAdjusters.ofDateAdjuster(
                temporal -> {
                    DayOfWeek dow = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
                    int dayToAdd = 1;
                    if (dow == DayOfWeek.FRIDAY) dayToAdd = 3;
                    else if (dow == DayOfWeek.SATURDAY) dayToAdd = 2;
                    return temporal.plus(dayToAdd, ChronoUnit.DAYS);
        });
        LocalDate date20 = LocalDate.of(2024, 10, 18);
        LocalDate date21 = date20.with(nextWorkingDay);
        System.out.println("date20: " + date20);
        System.out.println("date21: " + date21);

        LocalDate date22 = LocalDate.of(2014, 3, 18);
        String s1 = date22.format(DateTimeFormatter.BASIC_ISO_DATE);
        String s2 = date22.format(DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println("date22: " + date22);
        System.out.println("s1: " + s1);
        System.out.println("s2: " + s2);

        LocalDate date23 = LocalDate.parse("20140318", DateTimeFormatter.BASIC_ISO_DATE);
        LocalDate date24 = LocalDate.parse("2014-03-18", DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println("date23: " + date23);
        System.out.println("date24: " + date24);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date25 = LocalDate.of(2014, 3, 18);
        String formattedDate1 = date25.format(formatter);
        LocalDate date26 = LocalDate.parse(formattedDate1, formatter);
        System.out.println("date25: " + date25);
        System.out.println("formattedDate1: " + formattedDate1);
        System.out.println("date26: " + date26);

        DateTimeFormatter italianFormatter1 = DateTimeFormatter.ofPattern("d. MMMM yyyy", Locale.ITALIAN);
        LocalDate date27 = LocalDate.of(2014, 3, 18);
        String formattedDate2 = date27.format(italianFormatter1);
        LocalDate date28 = LocalDate.parse(formattedDate2, italianFormatter1);
        System.out.println("date27: " + date27);
        System.out.println("formattedDate2: " + formattedDate2);
        System.out.println("date28: " + date28);

        DateTimeFormatter koreanFormatter = DateTimeFormatter.ofPattern("yyyy년 M월 dd일", Locale.KOREA);
        LocalDate date29 = LocalDate.of(2014, 3, 18);
        String formattedDate3 = date29.format(koreanFormatter);
        LocalDate date30 = LocalDate.parse(formattedDate3, koreanFormatter);
        System.out.println("date29: " + date29);
        System.out.println("formattedDate3: " + formattedDate3);
        System.out.println("date30: " + date30);

        DateTimeFormatter italianFormatter2 = new DateTimeFormatterBuilder()
                .appendText(ChronoField.DAY_OF_MONTH)
                .appendLiteral(". ")
                .appendText(ChronoField.MONTH_OF_YEAR)
                .appendLiteral(" ")
                .appendText(ChronoField.YEAR)
                .parseCaseInsensitive()
                .toFormatter(Locale.ITALIAN);
        LocalDate date31 = LocalDate.of(2014, 3, 18);
        String formattedDate4 = date31.format(italianFormatter2);
        LocalDate date32 = LocalDate.parse(formattedDate4, italianFormatter2);
        System.out.println("date31: " + date31);
        System.out.println("formattedDate4: " + formattedDate4);
        System.out.println("date32: " + date32);

        ZoneId romeZone = ZoneId.of("Europe/Rome");
        ZoneId zoneId = TimeZone.getDefault().toZoneId();
        System.out.println("romeZone: " + romeZone);
        System.out.println("zoneId: " + zoneId);

        LocalDate date33 = LocalDate.of(2014, Month.MARCH, 18);
        ZonedDateTime zd1 = date33.atStartOfDay(romeZone);
        LocalDateTime dateTime1 = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45);
        ZonedDateTime zd2 = dateTime1.atZone(romeZone);
        Instant instant5 = Instant.now();
        ZonedDateTime zd3 = instant5.atZone(romeZone);
        System.out.println("zd1: " + zd1);
        System.out.println("zd2: " + zd2);
        System.out.println("zd3: " + zd3);

        Instant instant6 = Instant.now();
        LocalDateTime timeFromInstant = LocalDateTime.ofInstant(instant6, romeZone);
        System.out.println("timeFromInstant: " + timeFromInstant);

        ZoneOffset newYorkOffset = ZoneOffset.of("-05:00");
        System.out.println("newYorkOffset: " + newYorkOffset);

        LocalDateTime dateTime2 = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45);
        OffsetDateTime dateTimeInNewYork = OffsetDateTime.of(dateTime2, newYorkOffset);
        System.out.println("dateTimeInNewYork: " + dateTimeInNewYork);

        LocalDate date34 = LocalDate.of(2014, Month.MARCH, 18);
        JapaneseDate japaneseDate = JapaneseDate.from(date34);
        System.out.println("japaneseDate: " + japaneseDate);

        Chronology japaneseChronology = Chronology.ofLocale(Locale.JAPAN);
        ChronoLocalDate now = japaneseChronology.dateNow();
        System.out.println("now: " + now);

        HijrahDate ramadanDate =
                HijrahDate.now().with(ChronoField.DAY_OF_MONTH, 1)
                        .with(ChronoField.MONTH_OF_YEAR, 9);
        System.out.println("Ramadan start on " +
                IsoChronology.INSTANCE.date(ramadanDate) +
                " and ends on " +
                IsoChronology.INSTANCE.date(
                        ramadanDate.with(
                                TemporalAdjusters.lastDayOfMonth())));
    }
}
