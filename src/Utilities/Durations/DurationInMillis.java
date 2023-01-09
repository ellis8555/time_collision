package Utilities.Durations;

import Utilities.CreationStamps.CreationCalendarInstance;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;

public class DurationInMillis {
    public long getDurationInMillis(LocalDateTime ldt){
        Instant instant = CreationCalendarInstance.getCalendarDate(ldt).toInstant();
        Instant currentInstant = Instant.now();
        return Duration.between(instant, currentInstant).toMillis();
    }
}
