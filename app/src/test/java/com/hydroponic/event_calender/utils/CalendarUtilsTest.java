package com.hydroponic.event_calender.utils;

import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;

public class CalendarUtilsTest {

    private LocalDate localDate;

    public CalendarUtilsTest(){
        localDate = LocalDate.of(2021, 9, 29);
    }

    @Test
    public void testformattedDate(){
        String str = CalendarUtils.formattedDate(localDate);
        assert str.equals("29-09-2021")==true;

    }

    @Test
    public void testmonthYearFromDate(){
        String str = CalendarUtils.monthYearFromDate(localDate);
        assert str.equals("September 2021")==true;
    }

    @Test
    public void testdaysInWeekArray(){
        ArrayList<LocalDate> mydates = CalendarUtils.daysInWeekArray(localDate);

        assert mydates.size() == 7;
    }


}