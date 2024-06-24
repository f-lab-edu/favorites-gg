package gg.favorites.user.exception;

import gg.favorites.common.exception.BaseException;
import gg.favorites.common.suppot.error.ErrorCode;
import org.slf4j.event.Level;

public class UserNotFoundException extends BaseException {
    private static final ErrorCode CODE = ErrorCode.USER_NOT_FOUND;

    public UserNotFoundException() {
        super(CODE);
    }

    public UserNotFoundException(Level logLevel) {
        super(CODE.setLogLevel(logLevel));
    }

    public UserNotFoundException(String errorMessage) {
        super(CODE.setErrorMessage(errorMessage));
    }

    public UserNotFoundException(Level logLevel, String errorMessage) {
        super(CODE.setLogLevel(logLevel).setErrorMessage(errorMessage));
    }
}
