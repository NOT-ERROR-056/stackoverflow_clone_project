package pre.project.api.advice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pre.project.api.exception.BusinessLoginException;
import pre.project.api.exception.response.ErrorResponse;

// 예외 처리 공통화
// 각각의 Controller 클래스에서 예외를 처리하던 방식을 공통화 한 것
@RestControllerAdvice
@Slf4j
public class GlobalExceptionAdvice {

    @ExceptionHandler
    public ResponseEntity businessLogicException(BusinessLoginException e) {

        // final 을 선언하는 이유 알아보기
        final ErrorResponse response = ErrorResponse.of(e.getExceptionCode());

        return new ResponseEntity<>(response, HttpStatus.valueOf(e.getExceptionCode().getStatus()));
    }
}
