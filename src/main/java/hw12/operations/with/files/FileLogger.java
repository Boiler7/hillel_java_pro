package hw12.operations.with.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

import static java.nio.charset.StandardCharsets.UTF_8;
import static java.util.Objects.requireNonNull;

public class FileLogger extends AbstractLogger {
    private final FileLoggerConfiguration config;
    private Path currentFile;

    public FileLogger(FileLoggerConfiguration config) {
        super(config.level());
        this.config = requireNonNull(config);
        ensureLogDirExists(config);
        this.currentFile = initCurrentFile(0);
    }

    private void ensureLogDirExists(FileLoggerConfiguration config) {
        var logDir = Paths.get(config.path());
        if (!Files.exists(logDir)) {
            try {
                Files.createDirectories(logDir);
            } catch (IOException e) {
                throw new RuntimeException("Failed to create log directory", e);
            }
        }
    }

    @Override
    protected void writeLogEntry(String logEntry) throws FileMaxSizeReachedException {
        byte[] bytes = logEntry.getBytes(UTF_8);

        try {
            if (!Files.exists(currentFile)) {
                Files.createFile(currentFile);
            }

            long currentSize = Files.size(currentFile);

            if (currentSize + bytes.length + 1 > config.maxSize()) {
                rotateLogFile();
                currentSize = Files.size(currentFile);

                if (currentSize + bytes.length + 1 > config.maxSize()) {
                    throw new FileMaxSizeReachedException("The file size is bigger");
                }
            }

            try (var output = Files.newOutputStream(currentFile, java.nio.file.StandardOpenOption.APPEND)) {
                output.write(bytes);
                output.write("\n".getBytes(UTF_8));
            }
            System.out.println(logEntry);
        } catch (IOException e) {
            throw new RuntimeException("Failed to write log entry", e);
        }
    }

    private void rotateLogFile() {
        int index = 1;
        Path newPath;

        do {
            newPath = initCurrentFile(index++);
        } while (Files.exists(newPath));

        currentFile = newPath;
        System.out.println("Rotating log file to: " + currentFile);
    }

    private Path initCurrentFile(int index) {
        var fileName = String.format("output_%s_%03d.log", LocalDate.now(), index);
        return Paths.get(config.path(), fileName);
    }
}