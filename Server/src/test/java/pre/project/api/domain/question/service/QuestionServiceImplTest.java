package pre.project.api.domain.question.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpMethod;
import pre.project.api.domain.question.entity.Question;
import pre.project.api.domain.question.repository.QuestionRepository;
import pre.project.api.domain.question.dto.QuestionRequestDto;
import pre.project.api.exception.BusinessLoginException;
import pre.project.api.exception.ExceptionCode;
import pre.project.api.helper.QuestionStubData;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;

// 질문 서비스 기능 슬라이스 테스트
@ExtendWith(MockitoExtension.class)
class QuestionServiceImplTest {

    @Mock
    private QuestionRepository questionRepository;

    @InjectMocks
    private QuestionServiceImpl questionService;

    @Test
    @DisplayName("질문 글 작성 성공 테스트")
    void create() throws Exception {

        // given
        QuestionRequestDto questionRequestDto =
                (QuestionRequestDto) QuestionStubData.MockQuestion.getRequestBody(HttpMethod.POST);

        Question newQuestion = QuestionStubData.MockQuestion.getSingleResultQuestion();

        // mocking
        given(questionRepository.save(any()))
                .willReturn(newQuestion);

        // when
        Question actualQuestion = questionService.create(questionRequestDto);

        //then
        assertEquals(newQuestion.getQuestionId(), actualQuestion.getQuestionId());
        assertEquals(newQuestion.getTitle(), actualQuestion.getTitle());
        assertEquals(newQuestion.getContent(), actualQuestion.getContent());
    }

    @Test
    @DisplayName("질문 글 조회 성공 테스트")
    void read() {

        Long questionId = 1L;

        Question findQuestion = QuestionStubData.MockQuestion.getSingleResultQuestion();
        Optional<Question> optionalFindQuestion = Optional.of(findQuestion);

        given(questionRepository.findById(anyLong()))
                .willReturn(optionalFindQuestion);

        Question actualQuestion = questionService.read(questionId);

        assertEquals(findQuestion.getTitle(),actualQuestion.getTitle());

    }

    @Test
    @DisplayName("질문 글 조회 실패 테스트 - Question Not Found")
    void NotFindQuestionThrowException() throws Exception {

        Long questionId = 1L;

        Optional<Question> inValidQuestion = Optional.ofNullable(null);

        given(questionRepository.findById(anyLong()))
                .willReturn(inValidQuestion);

        String result = "";

        try {
            questionService.read(questionId);
        } catch (RuntimeException e) {
            result = e.getMessage();
        }

        assertTrue(result.equals(ExceptionCode.QUESTION_NOT_FOUND.getMessage()));
        assertThrows(BusinessLoginException.class, () -> questionService.read(questionId));
    }

//    @Test
//    @DisplayName("질문 글 전체 조회")
//    void readAll() {
//
//        Page<Question> multiResultQuestions = QuestionStubData.MockQuestion.getMultiResultQuestions();
//
//        given(questionRepository.findAll())
//                .willReturn(multiResultQuestions);
//
//        Page<Question> actualQuestions = questionService.readAll(1, 10);
//
//        assertEquals(multiResultQuestions.getTotalElements(),actualQuestions.getTotalElements());
//        assertEquals(multiResultQuestions.getContent().get(1),actualQuestions.getContent().get(1));
//
//    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}
