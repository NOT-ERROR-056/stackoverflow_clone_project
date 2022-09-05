package pre.project.api.domain.answer.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class MultiAnswerResponseDto {
    private List<AnswerResponseDto> data;

    public MultiAnswerResponseDto(List<AnswerResponseDto> data) {
        this.data = data;
    }
}
