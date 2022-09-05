package pre.project.api.domain.question.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pre.project.api.domain.question.entity.Question;
import pre.project.api.domain.question.repository.*;
import pre.project.api.domain.question.dto.QuestionPatchDto;
import pre.project.api.domain.question.dto.QuestionRequestDto;
import pre.project.api.exception.BusinessLoginException;
import pre.project.api.exception.ExceptionCode;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepository questionRepository;

    public Question create(QuestionRequestDto questionRequestDto) {
        Question question = new Question();
        question.setTitle(questionRequestDto.getTitle());
        question.setContent(questionRequestDto.getContent());

        return questionRepository.save(question);
    }

    public Question read(Long id) {
        Question question = findQuestion(id);
        return question;
    }

    public Page<Question> readAll(int page, int size) {

        return questionRepository.findAll(PageRequest.of(page, size));
    }

    public Question update(QuestionPatchDto patchDto) {
        Question question = findQuestion(patchDto.getQuestionId());

        Optional.ofNullable(patchDto.getTitle())
                .ifPresent(title -> question.setTitle(title));
        Optional.ofNullable(patchDto.getContent())
                .ifPresent(content -> question.setContent(content));
        question.setEditDate(LocalDateTime.now());

        return questionRepository.save(question);
    }

    public void delete(Long id) {
        Question question = findQuestion(id);
        questionRepository.delete(question);
    }

    public Question findQuestion(Long questionId) {
        Optional<Question> optionalQuestion = questionRepository.findById(questionId);
        Question findQuestion = optionalQuestion.orElseThrow(() -> new BusinessLoginException(ExceptionCode.QUESTION_NOT_FOUND));
        return findQuestion;
    }
}