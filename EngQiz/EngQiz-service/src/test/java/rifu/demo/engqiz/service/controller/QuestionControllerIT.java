package rifu.demo.engqiz.service.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import rifu.demo.engqiz.core.dto.QuestionDTO;
import rifu.demo.engqiz.service.ITApplicationConfig;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @implNote Integration Test Example File
 * This is an integration test example. The @WebAppConfiguration will load all application needs beans and
 * configurations based on what we set in @ContextConfiguration. Then, we get context via autowire
 * WebApplicationContext and make it build into mockMvc in the setUp method. Consequently, when we use mockMvc
 * .perform(), it will follow the context to go through all the application procedure.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {ITApplicationConfig.class})
@WebAppConfiguration
public class QuestionControllerIT {
    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    private String rootUrl = "/questions";

    private ObjectMapper mapper = new ObjectMapper();


    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testInsert() throws Exception {
        List<String> createQ1Answers = Arrays.asList("answer1", "answer2", "answer3");
        List<String> createQ2Answers = Arrays.asList("answer1_2", "answer2_2", "answer3_2");
        QuestionDTO createQ1 = createQuestionDTOStub(null, "Q1", createQ1Answers);
        QuestionDTO createQ2 = createQuestionDTOStub(null, "Q2", createQ2Answers);
        List<QuestionDTO> requests = Arrays.asList(createQ1, createQ2);

        mockMvc.perform((post(rootUrl).contentType(MediaType.APPLICATION_JSON).content(mapper.writeValueAsString(requests))))
                .andDo(print())
                .andExpect(status().isNoContent());

        MvcResult result = mockMvc.perform(get(rootUrl))
                .andExpect(jsonPath("$.*", hasSize(4)))
                .andReturn();
    }

    @Test
    public void testFindAllQuestion() throws Exception {
        MvcResult result = mockMvc.perform(get(rootUrl))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.*", hasSize(2)))
                .andReturn();
    }

    private QuestionDTO createQuestionDTOStub(Long id, String title, List<String> answers) {
        QuestionDTO dto = new QuestionDTO();
        dto.setId(id);
        dto.setTitle(title);
        dto.setAnswers(answers);
        return dto;
    }
}
