package rifu.demo.engqiz.service.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import rifu.demo.engqiz.core.dto.QuestionDTO;
import rifu.demo.engqiz.service.TestApplicationConfig;
import rifu.demo.engqiz.service.service.QuestionService;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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

    @Test
    public void testGetMessage() throws Exception {
        List<String> q1_answers = Arrays.asList("answer1", "answer2", "answer3");
        List<String> q2_answers = Arrays.asList("answer1_2", "answer2_2", "answer3_2");
        QuestionDTO stub1 = createQuestionDTOStub("Q1", q1_answers);
        QuestionDTO stub2 = createQuestionDTOStub("Q2", q2_answers);

        given(questionService.listAll()).willReturn(Arrays.asList(stub1, stub2));

        mockMvc.perform(get("/questions"))
                .andExpect(status().isOk()).andDo(print())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].title", is("Q1")))
                .andExpect(jsonPath("$[0].answers[0]", is("answer1")))
                .andExpect(jsonPath("$[0].answers[1]", is("answer2")))
                .andExpect(jsonPath("$[0].answers[2]", is("answer3")))
                .andExpect(jsonPath("$[1].title", is("Q2")));
    }

    private QuestionDTO createQuestionDTOStub(String title, List<String> answers) {
        QuestionDTO dto = new QuestionDTO();
        dto.setTitle(title);
        dto.setAnswers(answers);
        return dto;
    }
}
