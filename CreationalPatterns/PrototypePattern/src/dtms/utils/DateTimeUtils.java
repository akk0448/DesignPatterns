package dtms.utils;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DateTimeUtils {

    public static String millisToDateTime(Long millis) {
        if (millis == null) {
            return "N/A";
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss:SSSS");
        return Instant.ofEpochMilli(millis)
                .atZone(ZoneId.systemDefault())
                .format(formatter);
    }
}