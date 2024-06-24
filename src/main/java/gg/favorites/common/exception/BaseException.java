package gg.favorites.common.exception;

import gg.favorites.common.suppot.error.ErrorCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.slf4j.event.Level;

public class BaseException extends RuntimeException {
    protected final ErrorCode errorCode;

    public BaseException(ErrorCode errorCode) {
        super(errorCode.getErrorMessage());
        this.errorCode = errorCode;
    }

    public HttpStatus getHttpStatus() {
        return errorCode.getHttpStatus();
    }

    public Level getLogLevel() {
        return errorCode.getLogLevel();
    }
}
