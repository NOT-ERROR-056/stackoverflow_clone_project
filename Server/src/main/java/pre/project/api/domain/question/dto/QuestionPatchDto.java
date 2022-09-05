package pre.project.api.domain.question.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionPatchDto {
    private Long questionId;
    private String title;
    private String content;

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }
}