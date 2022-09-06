package pre.project.api.domain.question.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pre.project.api.domain.question.entity.Question;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuestionResponseDto {
    private Long questionId;
    private String title;
    private String content;
    private int recommendNum;
    private int viewNum;
    private LocalDateTime regDate;
    private LocalDateTime editDate;

    public QuestionResponseDto(Question question) {
        this.questionId = question.getQuestionId();
        this.title = question.getTitle();
        this.content = question.getContent();
        this.recommendNum = question.getRecommendNum();
        this.viewNum = question.getViewNum();
        this.regDate = question.getRegDate();
        this.editDate = question.getEditDate();
    }

}