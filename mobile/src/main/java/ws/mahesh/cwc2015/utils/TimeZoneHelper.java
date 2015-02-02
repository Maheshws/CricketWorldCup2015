package ws.mahesh.cwc2015.utils;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by Mahesh on 1/29/2015.
 */
public class TimeZoneHelper {

    public static String getTime(String time) {
        try {
            SimpleDateFormat sourceFormat = new SimpleDateFormat("dd-MMM-yyyy HH:mm");
            sourceFormat.setTimeZone(TimeZone.getTimeZone("Pacific/Auckland"));
            Date parsed = sourceFormat.parse(time);

            TimeZone tz = TimeZone.getTimeZone(TimeZone.getDefault().getID());
            SimpleDateFormat destFormat = new SimpleDateFormat("MMM dd hh:mm aaa, z");
            destFormat.setTimeZone(tz);

            return destFormat.format(parsed);
        } catch (ParseException e) {
            return time;
        }
    }
}
