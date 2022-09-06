package pre.project.api.integration.question;

import com.google.gson.Gson;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import pre.project.api.domain.question.dto.QuestionRequestDto;
import pre.project.api.helper.QuestionStubData;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class QuestionControllerTest {
    @Autowired private Gson gson;
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("질문 글 등록")
    void post_question() throws Exception {
        //given
        QuestionRequestDto questionRequestDto =
                (QuestionRequestDto) QuestionStubData.MockQuestion.getRequestBody(HttpMethod.POST);

        String content = gson.toJson(questionRequestDto);
        //when
        ResultActions actions = mockMvc.perform(post("/questions/ask")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content));
        //then
        actions.andExpect(status().isCreated())
                .andExpect(jsonPath("$.data.title").value(questionRequestDto.getTitle()));
    }

    @Test
    @DisplayName("질문 글 조회 기능")
    void get_question() throws Exception {
        //given

        //when

        //then

    }
}