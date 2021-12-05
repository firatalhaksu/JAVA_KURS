package com.bilgeadam.dates;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public class MyCustomDate {
    private static final SimpleDateFormat FORMAT = new SimpleDateFormat("dd.MM.yyyy - EEEE,MMMM,yy - HH:mm:ss:SSS zzzz",
                                                                        new Locale("tr","TR"));

    public Date getCurrentDate(){
        return new Date();
    }

    public String getCurrentDateInfo(Integer zone){
        FORMAT.setTimeZone(TimeZone.getTimeZone("GMT+8"));          //istenilen saat dilimini ayarlama (-23:59 / +23:59)
        return FORMAT.format(new Date());
    }

    public Date calculateDate (String input) throws ParseException {
        return FORMAT.parse(input);

    }

    public boolean isLeapYear(){
        GregorianCalendar calendar = new GregorianCalendar(2015,12,23,15,48,17);
        calendar.setTimeZone(TimeZone.getTimeZone("GMT+23:30"));
        return calendar.isLeapYear(2050);
    }


}
