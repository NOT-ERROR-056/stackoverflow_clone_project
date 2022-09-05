package pre.project.api.domain.answer.service;

import pre.project.api.domain.answer.dto.AnswerRequestDto;
import pre.project.api.domain.answer.dto.AnswerResponseDto;
import pre.project.api.domain.answer.entity.Answer;

import java.util.List;

public interface AnswerService {

    Answer create(Long questionId, AnswerRequestDto dto);
    List<AnswerResponseDto> findAll(Long id);
    Answer update(Long questionId, Long answerId, AnswerRequestDto dto);
    void delete(Long questionId, Long answerId);
}
