package pre.project.api.domain.answer.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pre.project.api.domain.answer.dto.MultiAnswerResponseDto;
import pre.project.api.domain.answer.entity.Answer;
import pre.project.api.domain.answer.service.AnswerService;
import pre.project.api.domain.answer.dto.AnswerRequestDto;
import pre.project.api.domain.answer.dto.AnswerResponseDto;
import pre.project.api.global_dto.SingleResponseDto;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/questions/{questionId}/answers")
@Slf4j
@CrossOrigin(origins = "*")
public class AnswerController {
    private final AnswerService answerService;
    @PostMapping
    public ResponseEntity create(@PathVariable("questionId") Long questionId,
                                 @RequestBody AnswerRequestDto dto) {
        Answer answer = answerService.create(questionId, dto);
        return new ResponseEntity<>(
                new SingleResponseDto(new AnswerResponseDto(answer))
                , HttpStatus.CREATED);
    }

    /** Read */
    @GetMapping
    public ResponseEntity<MultiAnswerResponseDto> read(@PathVariable("questionId") Long questionId) {
        List<AnswerResponseDto> answers = answerService.findAll(questionId);
        List<AnswerResponseDto> result = new ArrayList<>();
        for (AnswerResponseDto data : answers) {
            AnswerResponseDto response = AnswerResponseDto.builder()
                    .answerId(data.getAnswerId())
                    .content(data.getContent())
                    .recommendNum(data.getRecommendNum())
                    .regDate(data.getRegDate())
                    .editDate(data.getEditDate())
                    .questionId(data.getQuestionId())
                    .build();
            result.add(response);
        }
        return new ResponseEntity<>(
                (new MultiAnswerResponseDto(result))
                ,HttpStatus.OK);
    }

    /** Update */
    @PatchMapping("/{answerId}")
    public ResponseEntity update(@PathVariable("questionId") Long questionId,
                                 @PathVariable("answerId") Long answerId,
                                 @RequestBody AnswerRequestDto requestDto) {
        Answer answer = answerService.update(questionId, answerId, requestDto);
        return ResponseEntity.ok(new SingleResponseDto(new AnswerResponseDto(answer)));
    }

    @DeleteMapping("/{answerId}")
    public ResponseEntity delete(@PathVariable("questionId") Long questionId, @PathVariable("answerId") Long answerId) {
        answerService.delete(questionId, answerId);
        return ResponseEntity.noContent().build();
    }

}
