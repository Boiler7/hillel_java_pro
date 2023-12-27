package hw12.operations.with.files;

public record FileLoggerConfiguration(
        String path,
        LoggingLevel level,
        long maxSize) {
}
