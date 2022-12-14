package pre.project.api.domain.answer.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import pre.project.api.audit.Auditable;
import pre.project.api.domain.question.entity.Question;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Answer extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long answerId;
    @Column(nullable = false)
    private String content;

    private int recommendNum;

    @ManyToOne
    @JoinColumn(name = "QUESTION_ID")
    @JsonBackReference
    private Question question;

    public void addQuestion(Question question){
        this.question = question;
    }

    public void change(String content) {
        this.content = content;
    }
}