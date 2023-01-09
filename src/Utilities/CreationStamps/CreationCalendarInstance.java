// this class' static method is used in class "CreationInstanceDetails"
// a date object is created in both "getBirthTime()" and getBirthDate()" methods
// using this class' static method "getCalendarDate()"

package Utilities.CreationStamps;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class CreationCalendarInstance {
    public static Calendar getCalendarDate(LocalDateTime creationInstance){
        // these used for calendar constructor
        int year = creationInstance.getYear();
        // month needs to be subtracted by 1
        int month = creationInstance.getMonthValue()-1;
        int dayOfMonth = creationInstance.getDayOfMonth();
        int hourOfDay = creationInstance.getHour();
        int minute = creationInstance.getMinute();
        int second = creationInstance.getSecond();

        // create a calendar instance
        Calendar calendar = new GregorianCalendar(year, month, dayOfMonth, hourOfDay, minute, second);
        return calendar;
    }
}
