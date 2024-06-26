package gg.favorites.common.suppot.error;

import lombok.Getter;
import org.slf4j.event.Level;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {
    COMMON_SYSTEM_ERROR("일시적인 오류가 발생했습니다. 잠시 후 다시 시도해주세요.", HttpStatus.INTERNAL_SERVER_ERROR), // 장애 상황
    COMMON_INVALID_PARAMETER("요청한 값이 올바르지 않습니다.", HttpStatus.BAD_REQUEST),
    COMMON_ENTITY_NOT_FOUND("존재하지 않는 엔티티입니다.", HttpStatus.NOT_FOUND),
    COMMON_ILLEGAL_STATUS("잘못된 상태값입니다.", HttpStatus.BAD_REQUEST),
    USER_NOT_FOUND("사용자를 찾을 수 없습니다.", HttpStatus.NOT_FOUND);

    private final String errorMessage;
    private final HttpStatus httpStatus;

    ErrorCode(String errorMessage, HttpStatus httpStatus) {
        this.errorMessage = errorMessage;
        this.httpStatus = httpStatus;
    }

}
