package pre.project.api.domain.question.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import pre.project.api.audit.Auditable;
import pre.project.api.domain.answer.entity.Answer;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Question extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    private int viewNum = 0;

    private int recommendNum = 0;

    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    @JsonManagedReference
    List<Answer> answers = new ArrayList<>();

    public void addAnswers(Answer answer) {
        this.answers.add(answer);
    }

}

