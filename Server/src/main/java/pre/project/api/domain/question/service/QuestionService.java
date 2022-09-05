package pre.project.api.domain.question.service;

import org.springframework.data.domain.Page;
import pre.project.api.domain.question.entity.Question;
import pre.project.api.domain.question.dto.QuestionPatchDto;
import pre.project.api.domain.question.dto.QuestionRequestDto;

public interface QuestionService {
    Question create(QuestionRequestDto questionRequestDto);

    Question read(Long id);

    Page<Question> readAll(int page, int size);

    Question update(QuestionPatchDto requestDto);

    void delete(Long id);
}
