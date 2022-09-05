package pre.project.api.exception.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 유효성 검증 실패 에러시 제공
 */
@Getter
@AllArgsConstructor
public class MyFieldError {
    private String field;
    private Object rejectedValue;
    private String reason;


    public static List<MyFieldError> of(BindingResult bindingResult) {
        final List<org.springframework.validation.FieldError> fieldErrors =
                bindingResult.getFieldErrors();

        return fieldErrors.stream()
                .map(error -> new MyFieldError(
                        error.getField(),
                        error.getRejectedValue() == null ?
                                "" : error.getRejectedValue().toString(),
                        error.getDefaultMessage()))
                                .collect(Collectors.toList());
    }
}
