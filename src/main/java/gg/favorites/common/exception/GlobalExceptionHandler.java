package gg.favorites.common.exception;


import gg.favorites.common.suppot.error.ErrorCode;
import gg.favorites.common.suppot.reponse.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ApiResponse<?>> handleBaseException(BaseException e) {
        Level logLevel = e.getLogLevel();
        if (logLevel.equals(Level.SEVERE)) {
            log.error("BaseException : {}", e.getMessage(), e);
        } else if (logLevel.equals(Level.WARNING)) {
            log.warn("BaseException : {}", e.getMessage(), e);
        } else {
            log.info("BaseException : {}", e.getMessage(), e);
        }
        return new ResponseEntity<>(ApiResponse.error(e.getMessage()), e.getStatus());
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<?>> handleException(Exception e) {
        log.error("Exception : {}", e.getMessage(), e);
        return new ResponseEntity<>(ApiResponse.error(ErrorCode.COMMON_SYSTEM_ERROR.getErrorMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }



//    /**
//     * http status: 400 AND result: FAIL
//     * request parameter 에러
//     *
//     * @param e
//     * @return
//     */
////    @ResponseStatus(HttpStatus.BAD_REQUEST)
////    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
////    public CommonResponse methodArgumentNotValidException(MethodArgumentNotValidException e) {
////        log.warn("[BaseException] errorMsg = {}", NestedExceptionUtils.getMostSpecificCause(e).getMessage());
////        BindingResult bindingResult = e.getBindingResult();
////        FieldError fe = bindingResult.getFieldError();
////        if (fe != null) {
////            String message = "Request Error" + " " + fe.getField() + "=" + fe.getRejectedValue() + " (" + fe.getDefaultMessage() + ")";
////            return CommonResponse.fail(message, ErrorCode.COMMON_INVALID_PARAMETER.name());
////        } else {
////            return CommonResponse.fail("요청한 값이 올바르지 않습니다.", ErrorCode.COMMON_INVALID_PARAMETER.name());
////        }
////    }
}
