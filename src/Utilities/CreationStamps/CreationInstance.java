// an instant is recorded upon creation of person and realm objects
// in person objects class PersonDesign sets it's "dateTimeOfBirth" property using this class' "setCreationInstant()"
// a persons "dateTimeOfBirth" property is then used as an argument to extract time data in other formatting

package Utilities.CreationStamps;

import java.time.*;

import static java.time.Instant.now;

public class CreationInstance {

    private Instant now;

    public CreationInstance(Instant now){
        this.now = now;
    }
    private ZoneId zoneId = ZoneId.systemDefault();
    private Clock clock = Clock.system(zoneId);
    // set instance greenwich time
    //    private Instant now = now(clock);
    // translate instant time to localTime
    private LocalDateTime localDateTime = LocalDateTime.ofInstant(now(clock), zoneId);
    // sets an instance of date and time
    public LocalDateTime setCreationInstant(){
        return localDateTime;
    }
}
