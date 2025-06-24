package sdv.auth;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AuditLogger {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public static void log(String user, String document, String status) {
        String timestamp = FORMATTER.format(LocalDateTime.now());
        System.out.printf("[%s] User '%s' attempted to access '%s' -> %s%n", timestamp, user, document, status);
    }
}