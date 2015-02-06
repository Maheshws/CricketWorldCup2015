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
            sourceFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            Date parsed = sourceFormat.parse(time);

            TimeZone tz = TimeZone.getTimeZone( TimeZone.getDefault().getID());
            SimpleDateFormat destFormat;
            SimpleDateFormat destFormatTemp = new SimpleDateFormat("z");
            destFormatTemp.setTimeZone(tz);
            if (destFormatTemp.format(parsed).length() > 4)
                destFormat = new SimpleDateFormat("dd-MMM hh:mm aaa");
            else
                destFormat = new SimpleDateFormat("dd-MMM hh:mm aaa, z");
            destFormat.setTimeZone(tz);

            return destFormat.format(parsed);
        } catch (ParseException e) {
            return time;
        }
    }

    public static String getFeedTime(String time) {
        try {
            SimpleDateFormat sourceFormat = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z");
            sourceFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            Date parsed = sourceFormat.parse(time);

            TimeZone tz = TimeZone.getTimeZone(TimeZone.getDefault().getID());
            SimpleDateFormat destFormat = new SimpleDateFormat("MMM dd hh:mm aaa, z");
            destFormat.setTimeZone(tz);

            return destFormat.format(parsed);
        } catch (ParseException e) {
            return time;
        }
    }

    public static boolean compareTime(String dbDate){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy HH:mm");
        Date now = new Date();
        try {
            return now.before(sdf.parse(dbDate));
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
    }

}
