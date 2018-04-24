package rifu.demo.engqiz.service.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import rifu.demo.engqiz.core.dto.QuestionDTO;
import rifu.demo.engqiz.core.entity.Question;
import rifu.demo.engqiz.service.TestApplicationConfig;
import rifu.demo.engqiz.service.service.QuestionService;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyCollection;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @implNote We assume that all needed data should be processed nicely in service layer. Therefore, the main target
 * here is to verify test exceptions, return status and the return data format...etc. something about the
 * communication part is correct or not.
 * @WebMvcTest Important! We should be careful with this annotation. It will cause error when use it with @EntityScan
 * or @EnableJpaRepositories because of limitation of the annotation component scan scope. It causes conflicts.
 * Basically, the test can run well when it put in the same package with controller. However, our controller is in
 * different package, so we need TestApplicationConfig.class to assign the location.
 * @RunWith(SpringRunner.class) Spring Runner the same as SpringJUnit4ClassRunner.
 * https://docs.spring.io/spring/docs/4.3.0.RC2_to_4.3.0.RELEASE/Spring%20Framework%204.3.0.RELEASE/org/springframework/test/context/junit4/SpringRunner.html
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TestApplicationConfig.class})
@WebMvcTest(QuestionController.class)
public class QuestionControllerTest {

    @MockBean
    private QuestionService questionService;

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void testInsert() throws Exception {
        List<String> mockQ1Options = Arrays.asList("option1", "option2", "option3");
        List<String> mockQ2Options = Arrays.asList("option1_2", "option2_2", "option3_2");
        List<String> mockQ1Answers = Arrays.asList("option1");
        List<String> mockQ2Answers = Arrays.asList("option1_2", "option2_2");
        QuestionDTO mockQuestion1 = generateQuestionDTOStub(UUID.randomUUID().toString(), "Q1", mockQ1Options, mockQ1Answers);
        QuestionDTO mockQuestion2 = generateQuestionDTOStub(UUID.randomUUID().toString(), "Q2", mockQ2Options, mockQ2Answers);
        List<QuestionDTO> mockResponse = Arrays.asList(mockQuestion1, mockQuestion2);
        given(questionService.insert((List<Question>) anyCollection())).willReturn(mockResponse);

        List<String> createQ1Options = Arrays.asList("option1", "option2", "option3");
        List<String> createQ2Options = Arrays.asList("option1_2", "option2_2", "option3_2");
        List<String> createQ1Answers = Arrays.asList("option1");
        List<String> createQ2Answers = Arrays.asList("option1_2", "option2_2");
        QuestionDTO createQ1 = generateQuestionDTOStub(null, "Q1", createQ1Options, createQ1Answers);
        QuestionDTO createQ2 = generateQuestionDTOStub(null, "Q2", createQ2Options, createQ2Answers);
        List<QuestionDTO> requests = Arrays.asList(createQ1, createQ2);

        mockMvc.perform(post("/questions").param("withAnswers", "true").content(mapper.writeValueAsString(requests))
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void testListAll() throws Exception {
        boolean withAnswers = true;
        List<String> q1_options = Arrays.asList("option1", "option2", "option3");
        List<String> q2_options = Arrays.asList("option1_2", "option2_2", "option3_2");
        List<String> mockQ1Answers = Arrays.asList("option1");
        List<String> mockQ2Answers = Arrays.asList("option1_2", "option2_2");
        QuestionDTO stub1 = generateQuestionDTOStub(UUID.randomUUID().toString(), "Q1", q1_options, mockQ1Answers);
        QuestionDTO stub2 = generateQuestionDTOStub(UUID.randomUUID().toString(), "Q2", q2_options, mockQ2Answers);

        given(questionService.listAll(withAnswers)).willReturn(Arrays.asList(stub1, stub2));

        mockMvc.perform(get("/questions").param("withAnswers", "true"))
                .andExpect(status().isOk()).andDo(print())
                .andExpect(jsonPath("$.*", hasSize(2)))
                .andExpect(jsonPath("$[0].title", is("Q1")))
                .andExpect(jsonPath("$[0].options[0]", is("option1")))
                .andExpect(jsonPath("$[0].options[1]", is("option2")))
                .andExpect(jsonPath("$[0].options[2]", is("option3")))
                .andExpect(jsonPath("$[0].answers[0]", is("option1")))
                .andExpect(jsonPath("$[1].title", is("Q2")))
                .andExpect(jsonPath("$[1].options[0]", is("option1_2")))
                .andExpect(jsonPath("$[1].options[1]", is("option2_2")))
                .andExpect(jsonPath("$[1].options[2]", is("option3_2")))
                .andExpect(jsonPath("$[1].answers[0]", is("option1_2")))
                .andExpect(jsonPath("$[1].answers[1]", is("option2_2")));
    }

    private QuestionDTO generateQuestionDTOStub(String id, String title, List<String> options, List<String> answers) {
        QuestionDTO dto = new QuestionDTO();
        dto.setId(id);
        dto.setTitle(title);
        dto.setOptions(options);
        dto.setAnswers(answers);
        return dto;
    }
}
