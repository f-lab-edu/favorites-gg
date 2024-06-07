package gg.favorites.user.exception;

import gg.favorites.exception.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UserException extends RuntimeException {
    private final ErrorCode errorCode;
}
