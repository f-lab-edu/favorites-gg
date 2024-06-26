package gg.favorites.domain.user;

import gg.favorites.common.exception.BaseException;
import gg.favorites.common.suppot.error.ErrorCode;
import org.slf4j.event.Level;

public class UserNotFoundException extends BaseException {

    private static final ErrorCode CODE = ErrorCode.USER_NOT_FOUND;

    public UserNotFoundException(Level logLevel, String message) {
        super(CODE, logLevel, message);
    }

    public UserNotFoundException(String message) {
        super(CODE, message);
    }

    public UserNotFoundException(Level logLevel) {
        super(CODE, logLevel);
    }

    public UserNotFoundException() {
        super(CODE);
    }
}
