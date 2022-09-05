package pre.project.api.helper;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpMethod;
import pre.project.api.domain.question.dto.QuestionPatchDto;
import pre.project.api.domain.question.dto.QuestionRequestDto;
import pre.project.api.domain.question.dto.QuestionResponseDto;
import pre.project.api.domain.question.entity.Question;

import java.time.LocalDateTime;
import java.util.*;

public class QuestionStubData {

    private static Map<HttpMethod, Object> stubRequestBody;

    static {
        stubRequestBody = new HashMap<>();
        stubRequestBody.put(HttpMethod.POST, new QuestionRequestDto("title-test1", "content-test1"));
        stubRequestBody.put(HttpMethod.PATCH, new QuestionPatchDto(1L, "title-edit-test1", "content-edit-test1"));
    }

    /**
     * @Mehtod getRequestBody(HttpMethod method)
     * <p>
     * # Controller
     * @Method getSingleResponseBody()
     * @Method getSinglePatchResponseBody()
     * @Method getMultiResponseBody()
     * <p>
     * # Entity
     * @Method getSingleResultQuestion()
     * @Method getSingleResultQuestion(Long questionId)
     * @Method getSingleResultQuestion(Long questionId, Map < String, String > updateInfo)
     * @Method getMultiResultQuestions()
     */
    public static class MockQuestion {

        public static Object getRequestBody(HttpMethod method) {
            return stubRequestBody.get(method);
        }

        // Controller test 시 사용
        // data 로 객체를 묶어줘야함. 아직 x
        public static QuestionResponseDto getSingleResponseBody() {
            return new QuestionResponseDto(
                    1L,
                    "title-test1",
                    "content-test1",
                    0,
                    0,
                    LocalDateTime.now(),
                    LocalDateTime.now()
            );
        }

        // Controller test 시 사용
        // data 로 객체를 묶어줘야함. 아직 x
        public static QuestionResponseDto getSinglePatchResponseBody() {
            return new QuestionResponseDto(
                    1L,
                    "title-edit-test1",
                    "content-edit-test1",
                    0,
                    0,
                    LocalDateTime.now(),
                    LocalDateTime.now()
            );
        }

        // Controller test 시 사용
        // data 로 객체를 묶어줘야함. 아직 x
        public static List<QuestionResponseDto> getMultiResponseBody() {
            return List.of(
                    new QuestionResponseDto(
                            1L,
                            "title-test1",
                            "content-test1",
                            0,
                            0,
                            LocalDateTime.now(),
                            LocalDateTime.now()
                    ),
                    new QuestionResponseDto(
                            2L,
                            "title-test2",
                            "content-test2",
                            0,
                            0,
                            LocalDateTime.now(),
                            LocalDateTime.now()
                    )
            );
        }

        public static Question getSingleResultQuestion() {
            return new Question(
                    1L,
                    "title-test1",
                    "content-test1",
                    LocalDateTime.now(),
                    LocalDateTime.now(),
                    0,
                    0,
                    new ArrayList<>());
        }

        public static Question getSingleResultQuestion(Long questionId) {
            return new Question(
                    1L,
                    "title-test1",
                    "content-test1",
                    LocalDateTime.now(),
                    LocalDateTime.now(),
                    0,
                    0,
                    new ArrayList<>());
        }

        public static Question getSingleResultQuestion(Long questionId, Map<String, String> updatedInfo) {

            String title = Optional.ofNullable(updatedInfo.get("title")).orElse("title-edit-test1");
            String content = Optional.ofNullable(updatedInfo.get("content")).orElse("content-edit-test1");

            Question updateQuestion = Question.builder()
                    .questionId(questionId)
                    .title(title)
                    .content(content)
                    .recommendNum(0)
                    .viewNum(0)
                    .editDate(LocalDateTime.now())
                    .build();

            return updateQuestion;
        }

        public static Page<Question> getMultiResultQuestions() {
            Question newQuestion1 = new Question(
                    1L,
                    "title-test1",
                    "content-test1",
                    LocalDateTime.now(),
                    LocalDateTime.now(),
                    0,
                    0,
                    new ArrayList<>());
            Question newQuestion2 = new Question(
                    2L,
                    "title-test2",
                    "content-test2",
                    LocalDateTime.now(),
                    LocalDateTime.now(),
                    0,
                    0,
                    new ArrayList<>());

            return new PageImpl<>(List.of(newQuestion1, newQuestion2),
                    PageRequest.of(0, 10),
                    2);
        }

    }

}
