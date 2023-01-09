// both this class' methods used in person and realms creations
// each type of object returns a formatted time and date of creation
// these methods are called in objects "getDateOfBirth()" and getTimeOfBirth()" getter methods *PersonDesign* class

package Utilities.CreationStamps;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;


public class CreationInstanceDetails {

    // format time example (12:00 am)
    public static String getBirthTime(LocalDateTime localDateTime){
        Calendar date = CreationCalendarInstance.getCalendarDate(localDateTime);
        // format time to look as (12L00 am) as example
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");
        String time = sdf.format(date.getTime());
        return time;
    }
    // format date example (November 22, 1976)
    public static String getBirthDate(LocalDateTime localDateTime){
        Calendar date = CreationCalendarInstance.getCalendarDate(localDateTime);
        // format time to look as (12L00 am) as example
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd, YYYY");
        String time = sdf.format(date.getTime());
        return time;
    }
}

