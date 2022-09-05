package pre.project.api.exception.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.ConstraintViolation;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
/**
제약 조건이 위배되었을 때 발생하는 예외
예를 들면, JPA entity 에 not null 을 선언했으나 null 이 들어가는 경우 발생
 */
@AllArgsConstructor
@Getter
public class MyConstraintViolationError {
    private String propertyPath;
    private Object rejectedValue;
    private String reason;

    public static List<MyConstraintViolationError> of(
            Set<ConstraintViolation<?>> constraintViolations) {
        return constraintViolations.stream()
                .map(error -> new MyConstraintViolationError(
                        error.getPropertyPath().toString(),
                        error.getInvalidValue().toString(),
                        error.getMessage()))
                .collect(Collectors.toList());
    }
}
