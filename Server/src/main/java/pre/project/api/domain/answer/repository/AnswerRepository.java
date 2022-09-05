package pre.project.api.domain.answer.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import pre.project.api.domain.answer.entity.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Long> {

}