package pre.project.api.domain.answer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pre.project.api.domain.answer.entity.Answer;
import pre.project.api.domain.answer.repository.AnswerRepository;
import pre.project.api.domain.question.entity.Question;
import pre.project.api.domain.question.repository.*;
import pre.project.api.domain.answer.dto.AnswerRequestDto;
import pre.project.api.domain.answer.dto.AnswerResponseDto;
import pre.project.api.exception.BusinessLoginException;
import pre.project.api.exception.ExceptionCode;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AnswerServiceImpl implements AnswerService {
    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;


    /** 질문 ID 확인 및 예외처리 */
    private Question isQuestion(Long questionId) {
        Question question = questionRepository.findById(questionId).orElseThrow(() ->
                new BusinessLoginException(ExceptionCode.QUESTION_NOT_FOUND));
        return question;
    }

    /** 답변 ID 확인 및 예외처리 */
    private Answer isAnswer(Long answerId) {
        Answer answer = answerRepository.findById(answerId).orElseThrow(() ->
                new BusinessLoginException(ExceptionCode.ANSWER_NOT_FOUND));
        return answer;
    }

    /** 요청받은 질문 ID 파라미터가 답변 ID가 보유한 질문 객체의 질문 ID와 일치하는지 확인 및 예외처리 */
    private void verifyQuestionIdAndAnswerId(Long questionId, Answer answer) {
        if(questionId != answer.getQuestion().getQuestionId()){
            throw new BusinessLoginException(ExceptionCode.QUESTION_NOT_FOUND);
        }
    }



    /** CREATE */
    @Transactional
    public Answer create(Long questionId, AnswerRequestDto requestDto) {
        Question question = isQuestion(questionId);
        requestDto.setQuestion(question); // Question의 정보를 answer에 저장
        Answer answer = requestDto.toEntity();
        return answerRepository.save(answer);
    }

    /** READ */
    @Transactional(readOnly = true)
    public List<AnswerResponseDto> findAll(Long questionId) {
        Question question = isQuestion(questionId);
        List<Answer> answers = question.getAnswers();
        return answers
                .stream()
                .map(AnswerResponseDto::new)
                .sorted(Comparator.comparing(AnswerResponseDto::getAnswerId).reversed())
                .collect(Collectors.toList());
    }

    /** UPDATE */
    @Transactional
    public Answer update(Long questionId, Long answerId, AnswerRequestDto requestDto) {
        Answer answer = isAnswer(answerId);
        verifyQuestionIdAndAnswerId(questionId, answer);
        String content = requestDto.toEntity().getContent();
        answer.change(content);
        return answer;
    }



    /** DELETE */
    @Transactional
    public void delete(Long questionId, Long answerId) {
        Answer answer = isAnswer(answerId);
        verifyQuestionIdAndAnswerId(questionId, answer);
        answerRepository.delete(answer);
    }
}
