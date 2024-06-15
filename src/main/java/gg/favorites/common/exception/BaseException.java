package gg.favorites.common.exception;
import org.springframework.http.HttpStatus;
import java.util.logging.Level;

public abstract class BaseException extends RuntimeException {
    protected BaseException(String message) {
        super(message);
    }

    protected abstract HttpStatus getStatus();

    protected abstract Level getLogLevel();

}
