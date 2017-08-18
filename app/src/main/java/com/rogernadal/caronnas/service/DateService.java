package com.rogernadal.caronnas.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by lucas.tomasi on 18/08/17.
 */

public class DateService
{
    private static SimpleDateFormat DATETIME_FORMAT    = new SimpleDateFormat("dd/MM/y HH:mm");
    private static SimpleDateFormat DATETIME_FORMAT_US = new SimpleDateFormat("y-MM-dd HH:mm:ss");
    private static SimpleDateFormat DATE_FORMAT        = new SimpleDateFormat("dd/MM/y");
    private static SimpleDateFormat DATE_FORMAT_US     = new SimpleDateFormat("y-MM-dd");

    public static Timestamp getTimesTamp(String timestamp )
    {
        if( timestamp != null && !timestamp.trim().equalsIgnoreCase("") )
            return Timestamp.valueOf(timestamp);
        return null;
    }

    public static String getDateString(Timestamp timestamp )
    {
        if( timestamp != null )
            return DATETIME_FORMAT.format(new Date(timestamp.getTime()));
        return "";
    }

    public static boolean isAfter( String time ) throws Exception
    {
        Date d1 = new Date(System.currentTimeMillis());
        Date d2 = DATETIME_FORMAT.parse( DATE_FORMAT.format(d1) + " " + time );
        return ( d1.after(d2) );
    }

    public static  String getDateUSString(Timestamp timestamp)
    {
        if( timestamp != null)
            return DATETIME_FORMAT_US.format(new Date(timestamp.getTime()));
        return "";
    }

    public static String today()
    {
        return DATE_FORMAT_US.format( new Date(System.currentTimeMillis()) );
    }

    public static String tomorrow()
    {
        Date date = new Date(System.currentTimeMillis());
        Calendar c = Calendar.getInstance();
        c.setTime(date);

        c.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH) + 1);
        Date tomorrow = c.getTime();
        return DATE_FORMAT_US.format(tomorrow);
    }
}
