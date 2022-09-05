package pre.project.api.exception;

import lombok.Getter;

public enum ExceptionCode {
    // Question
    QUESTION_NOT_FOUND(404, "Question not found"),
    QUESTION_BAD_REQUEST(400, "Bad request to post a Question"),

    // Answer
    ANSWER_NOT_FOUND(404, "Answer not found"),
    ANSWER_BAD_REQUEST(400, "Bad request to post a Question"),

    // Server
    NOT_IMPLEMENTATION(501, "Not Implementation");

    @Getter
    private int status;

    @Getter
    private String message;

    ExceptionCode(int status, String message ){
        this.status = status;
        this.message = message;
    }
}
