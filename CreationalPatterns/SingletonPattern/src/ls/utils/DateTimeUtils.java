package ls.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DateTimeUtils {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss:SSSS");

    public static String getCurrentTimestamp() {
        return FORMATTER.format(LocalDateTime.now());
    }

    public static String millisToDateTime(Long millis) {
        if (millis == null) {
            return "N/A";
        }
        return Instant.ofEpochMilli(millis)
                .atZone(ZoneId.systemDefault())
                .format(FORMATTER);
    }
}