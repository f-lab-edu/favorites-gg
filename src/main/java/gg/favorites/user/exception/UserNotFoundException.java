package gg.favorites.user.exception;

import gg.favorites.common.exception.BaseException;
import org.springframework.http.HttpStatus;

import java.util.logging.Level;

public class UserNotFoundException extends BaseException {

    public UserNotFoundException(String errorMessage) {
        super(errorMessage);
    }

    @Override
    protected HttpStatus getStatus() {
        return HttpStatus.NOT_FOUND;
    }

    @Override
    protected Level getLogLevel() {
        return Level.WARNING;
    }
}
