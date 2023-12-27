package hw12.operations.with.files;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import static java.time.temporal.ChronoUnit.SECONDS;
import static java.util.Objects.requireNonNull;

public abstract class AbstractLogger implements Logger {
    private static final Map<LoggingLevel, List<LoggingLevel>> ALLOWED_LEVELS = Map.of(
            LoggingLevel.DEBUG, List.of(LoggingLevel.DEBUG, LoggingLevel.INFO),
            LoggingLevel.INFO, List.of(LoggingLevel.INFO)
    );

    protected final List<LoggingLevel> allowedLevels;

    public AbstractLogger(LoggingLevel loggingLevel) {
        this.allowedLevels = requireNonNull(ALLOWED_LEVELS.get(loggingLevel));
    }

    public void debug(String message) throws FileMaxSizeReachedException {
        log(LoggingLevel.DEBUG, message);
    }

    public void info(String message) throws FileMaxSizeReachedException {
        log(LoggingLevel.INFO, message);
    }

    protected void log(LoggingLevel level, String message) throws FileMaxSizeReachedException {
        if (allowedLevels.contains(level)) {
            for(var lvl : allowedLevels){
                writeLogEntry(String.format("[%s] [%s] %s", LocalDateTime.now().truncatedTo(SECONDS), lvl, message));
            }

        }
    }

    protected abstract void writeLogEntry(String logEntry) throws FileMaxSizeReachedException;
}