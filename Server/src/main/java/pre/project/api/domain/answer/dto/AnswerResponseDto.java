package pre.project.api.domain.answer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pre.project.api.domain.answer.entity.Answer;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnswerResponseDto {
    private Long answerId;
    private String content;
    private int recommendNum;
    private LocalDateTime regDate;
    private LocalDateTime editDate;

    private Long questionId; // id를 반환하는 것으로 수정

    /** Entity -> Dto */
    public AnswerResponseDto(Answer answer) {
        this.answerId = answer.getAnswerId();
        this.content = answer.getContent();
        this.recommendNum = answer.getRecommendNum();
        this.regDate = answer.getRegDate();
        this.editDate = answer.getEditDate();
        this.questionId = answer.getQuestion().getQuestionId(); // id를 반환하는 것으로 수정
    }
}
