package pre.project.api.exception.response;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import pre.project.api.exception.ExceptionCode;

import javax.validation.ConstraintViolation;
import java.util.List;
import java.util.Set;

@Getter
public class ErrorResponse {
    private int status;
    private String message;
    private List<MyFieldError> myFieldError;
    private List<MyConstraintViolationError> violationErrors;

    private ErrorResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public ErrorResponse(List<MyFieldError> myFieldError, List<MyConstraintViolationError> violationErrors) {
        this.myFieldError = myFieldError;
        this.violationErrors = violationErrors;
    }

    // 유효성 검증시 발생
    public static ErrorResponse of(BindingResult bindingResult) {
        return new ErrorResponse(MyFieldError.of(bindingResult), null);
    }

    public static ErrorResponse of(Set<ConstraintViolation<?>> constraintViolations) {
        return new ErrorResponse(null, MyConstraintViolationError.of(constraintViolations));
    }

    public static ErrorResponse of(ExceptionCode exceptionCode) {
        return new ErrorResponse(exceptionCode.getStatus(), exceptionCode.getMessage());
    }

    public static ErrorResponse of(HttpStatus httpStatus) {
        return new ErrorResponse(httpStatus.value(), httpStatus.getReasonPhrase());
    }

    public ErrorResponse of(HttpStatus httpStatus, String message) {
        return new ErrorResponse(httpStatus.value(), message);
    }
}
