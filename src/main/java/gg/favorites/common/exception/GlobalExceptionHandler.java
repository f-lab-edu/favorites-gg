package gg.favorites.common.exception;


import gg.favorites.common.suppot.reponse.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.event.Level;
import org.springframework.core.NestedExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import static gg.favorites.common.suppot.error.ErrorCode.COMMON_INVALID_PARAMETER;
import static gg.favorites.common.suppot.error.ErrorCode.COMMON_SYSTEM_ERROR;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ApiResponse<?>> handleBaseException(BaseException e) {
        Level logLevel = e.getLogLevel();
        if (e.getLogLevel().equals(Level.ERROR)) {
            log.error("BaseException : {}", e.getMessage(), e);
        } else if (logLevel.equals(Level.WARN)) {
            log.warn("BaseException : {}", e.getMessage(), e);
        } else {
            log.info("BaseException : {}", e.getMessage(), e);
        }
        return new ResponseEntity<>(ApiResponse.error(e.getMessage()), e.getHttpStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<?>> handleException(Exception e) {
        log.error("Exception : {}", e.getMessage(), e);
        return new ResponseEntity<>(ApiResponse.error(COMMON_SYSTEM_ERROR.getErrorMessage()), COMMON_SYSTEM_ERROR.getHttpStatus());
    }

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity<ApiResponse<?>> methodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.warn("ValidException : {}", NestedExceptionUtils.getMostSpecificCause(e).getMessage());
        BindingResult bindingResult = e.getBindingResult();
        FieldError fe = bindingResult.getFieldError();
        if (fe != null) {
            String message = String.format("Request Error %s=%s (%s)", fe.getField(), fe.getRejectedValue(), fe.getDefaultMessage());
            return new ResponseEntity<>(ApiResponse.error(message), HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(ApiResponse.error(COMMON_INVALID_PARAMETER.getErrorMessage()), COMMON_INVALID_PARAMETER.getHttpStatus());
        }
    }
}
