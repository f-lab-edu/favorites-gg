package gg.favorites.common.exception;

import gg.favorites.common.suppot.error.ErrorCode;
import org.slf4j.event.Level;
import org.springframework.http.HttpStatus;

public abstract class BaseException extends RuntimeException {
    protected final Level level;
    protected final ErrorCode errorCode;

    // 기본 생성자
    public BaseException(ErrorCode errorCode, Level level, String message) {
        super(message != null ? message : errorCode.getErrorMessage());
        this.errorCode = errorCode;
        this.level = level;
    }

    // 메시지 없이 로그 레벨만 설정
    public BaseException(ErrorCode errorCode, Level level) {
        this(errorCode, level, errorCode.getErrorMessage());
    }

    // 로그 레벨 없이 메시지만 설정
    public BaseException(ErrorCode errorCode, String message) {
        this(errorCode, Level.WARN, message);
    }

    // 기본 에러 메시지와 로그 레벨 사용
    public BaseException(ErrorCode errorCode) {
        this(errorCode, Level.WARN, errorCode.getErrorMessage());
    }

    public HttpStatus getHttpStatus() {
        return errorCode.getHttpStatus();
    }

    public Level getLogLevel() {
        return level;
    }
}
