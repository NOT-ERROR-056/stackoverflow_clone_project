package pre.project.api.domain.question.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pre.project.api.domain.question.entity.Question;
import pre.project.api.domain.question.service.QuestionService;
import pre.project.api.global_dto.MultiResponseDto;
import pre.project.api.domain.question.dto.QuestionPatchDto;
import pre.project.api.domain.question.dto.QuestionResponseDto;
import pre.project.api.domain.question.dto.QuestionRequestDto;
import pre.project.api.global_dto.SingleResponseDto;

import javax.validation.constraints.Positive;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/questions")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class QuestionController {
    private final QuestionService questionService;

    /**
     * 전체 게시글 조회
     */
    @GetMapping
    public ResponseEntity readQuestions(@Positive @RequestParam(required = false, defaultValue = "1") int page,
                                        @Positive @RequestParam(required = false, defaultValue = "10") int size) {
        Page<Question> pageQuestions = questionService.readAll( page - 1 ,size );
        List<Question> question = pageQuestions.getContent();
        List<QuestionResponseDto> responses = new ArrayList<>();
        for (Question data : question) {
            QuestionResponseDto response =
                    QuestionResponseDto.builder()
                            .questionId(data.getQuestionId())
                            .title(data.getTitle())
                            .content(data.getContent())
                            .recommendNum(data.getRecommendNum())
                            .regDate(data.getRegDate())
                            .editDate(data.getEditDate())
                            .viewNum(data.getViewNum())
                            .build();
            responses.add(response);
        }
        return new ResponseEntity<>(
                (new MultiResponseDto(responses,pageQuestions))
                ,HttpStatus.OK);
    }


    /**
     * 게시글 하나 조회
     */
    @GetMapping("/{question-id}")
    public ResponseEntity readQuestion(@PathVariable("question-id") Long id) {
        Question questionResult = questionService.read(id);
            QuestionResponseDto responseDto = QuestionResponseDto
                    .builder()
                    .questionId(questionResult.getQuestionId())
                    .title(questionResult.getTitle())
                    .content(questionResult.getContent())
                    .recommendNum(questionResult.getRecommendNum())
                    .regDate(questionResult.getRegDate())
                    .editDate(questionResult.getEditDate())
                    .viewNum(questionResult.getViewNum())
                    .build();
        return new ResponseEntity<>(
                (new SingleResponseDto<>(responseDto))
                ,HttpStatus.OK);
    }

    /**
     * 게시글 등록
     */
    @PostMapping("/ask")
    public ResponseEntity<QuestionResponseDto> createQuestion(@RequestBody QuestionRequestDto questionRequestDto) {
        Question questionResult = questionService.create(questionRequestDto);
        return new ResponseEntity(
                new SingleResponseDto(new QuestionResponseDto(questionResult))
                ,HttpStatus.CREATED);
    }

    /**
     * 게시글 수정
     */
    @PatchMapping("/ask/{question-id}")
    public ResponseEntity updateQuestion(@PathVariable("question-id") Long id, @RequestBody QuestionPatchDto patchDto) {
        patchDto.setQuestionId(id);
        Question questionResult = questionService.update(patchDto);
        return new ResponseEntity<>(
                new SingleResponseDto(new QuestionResponseDto(questionResult))
                ,HttpStatus.OK);
    }

    /**
     * 게시글 삭제
     */
    @DeleteMapping("/{question-id}")
    public ResponseEntity deleteQuestion(@PathVariable("question-id") Long id) {
        questionService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}