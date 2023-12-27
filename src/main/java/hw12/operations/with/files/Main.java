package hw12.operations.with.files;

public class Main {
    public static void main(String[] args) throws FileMaxSizeReachedException {
        FileLoggerConfiguration config = new FileLoggerConfiguration("logs", LoggingLevel.DEBUG, 100000);
        FileLogger logger = new FileLogger(config);
        logger.info("452");
    }
}