package gg.favorites.common.suppot.error;

import lombok.Getter;
import org.slf4j.event.Level;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {
    COMMON_SYSTEM_ERROR("일시적인 오류가 발생했습니다. 잠시 후 다시 시도해주세요.", HttpStatus.INTERNAL_SERVER_ERROR, Level.ERROR), // 장애 상황
    COMMON_INVALID_PARAMETER("요청한 값이 올바르지 않습니다.", HttpStatus.BAD_REQUEST, Level.WARN),
    COMMON_ENTITY_NOT_FOUND("존재하지 않는 엔티티입니다.", HttpStatus.NOT_FOUND, Level.INFO),
    COMMON_ILLEGAL_STATUS("잘못된 상태값입니다.", HttpStatus.BAD_REQUEST, Level.ERROR),
    USER_NOT_FOUND("사용자를 찾을 수 없습니다.", HttpStatus.NOT_FOUND, Level.WARN); // 초기 레벨을 WARN로 설정

    private String errorMessage;
    private final HttpStatus httpStatus;
    private Level logLevel;

    ErrorCode(String errorMessage, HttpStatus httpStatus, Level logLevel) {
        this.errorMessage = errorMessage;
        this.httpStatus = httpStatus;
        this.logLevel = logLevel;
    }

    // 동적으로 에러 레벨 설정
    public ErrorCode setLogLevel(Level logLevel) {
        this.logLevel = logLevel;
        return this;
    }

    // 동적으로 에러 메시지 설정
    public ErrorCode setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
        return this;
    }
}
