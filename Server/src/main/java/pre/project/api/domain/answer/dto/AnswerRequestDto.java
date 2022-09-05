package pre.project.api.domain.answer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pre.project.api.domain.answer.entity.Answer;
import pre.project.api.domain.question.entity.Question;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnswerRequestDto {
    private LocalDateTime regDate= LocalDateTime.now();
    private LocalDateTime editDate = LocalDateTime.now();

    private Question question;
    private String content;

    /** Dto -> Entity */
    public Answer toEntity() {
        Answer answer = Answer.builder()
                .regDate(regDate)
                .editDate(editDate)
                .question(question)
                .content(content)
                .build();
        return answer;
    }
}
