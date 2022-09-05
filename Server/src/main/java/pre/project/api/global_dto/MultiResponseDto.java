package pre.project.api.global_dto;

import lombok.Getter;
import org.springframework.data.domain.Page;
import pre.project.api.domain.question.dto.QuestionResponseDto;

import java.util.List;

@Getter
public class MultiResponseDto { //제네릭이 아닌 리스트 타입을 question responce Dto로 변환 todtjdwk qusghks
    private List<QuestionResponseDto> data;
    private PageInfo pageInfo;

    public MultiResponseDto(List<QuestionResponseDto> data, Page page){
        this.data = data;
        this.pageInfo = new PageInfo(page.getNumber() + 1,
                page.getSize(),page.getTotalElements(),page.getTotalPages());
    }
}