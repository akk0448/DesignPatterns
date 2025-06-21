package ls.logger;

import static ls.utils.DateTimeUtils.getCurrentTimestamp;

public class Logger {

    private static final Logger INSTANCE = new Logger();

    private Logger() {
    }

    public static Logger getInstance() {
        return INSTANCE;
    }

    public void trace(String message) {
        log(LogLevel.TRACE, message);
    }

    public void info(String message) {
        log(LogLevel.INFO, message);
    }

    public void error(String message) {
        log(LogLevel.ERROR, message);
    }

    public void debug(String message) {
        log(LogLevel.DEBUG, message);
    }

    public void warn(String message) {
        log(LogLevel.WARN, message);
    }

    private void log(LogLevel level, String message) {
        String timestamp = getCurrentTimestamp();
        System.out.printf("[%s] [%s]: %s%n", timestamp, level.name(), message);
    }
}