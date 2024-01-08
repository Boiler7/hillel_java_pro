package hw12.operations.with.files;

import java.io.IOException;

public interface Logger {
    public void info(String message) throws FileMaxSizeReachedException, IOException;
    public void debug(String message) throws FileMaxSizeReachedException, IOException;
}
