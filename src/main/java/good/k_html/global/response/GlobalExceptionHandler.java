package good.k_html.global.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    protected ResponseEntity<ApiResponse<Void>> handleCustomException(CustomException customException) {

        ErrorCode errorCode = customException.getErrorCode();

        return new ResponseEntity<>(
                new ApiResponse<>(
                        errorCode.getMessage(),
                        null),
                HttpStatus.valueOf(errorCode.getStatus()));

    }
    @Getter
    @AllArgsConstructor
    static class ErrorResponse {
        private int status;
        private String message;
    }
}