package rifu.demo.engqiz.service.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringRunner;
import rifu.demo.engqiz.core.dao.QuestionDAO;
import rifu.demo.engqiz.core.dto.QuestionDTO;
import rifu.demo.engqiz.core.entity.Question;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyCollection;

/**
 * @implNote In service tester, we will mock all invocation of dao function due to we assume dao will return correct
 * data. Only test the business logic inside services is the main goal.
 */
@RunWith(SpringRunner.class)
public class QuestionServiceTest {
    @SpyBean
    private QuestionService questionService;

    @MockBean
    QuestionDAO questionDAO;

    @Test
    public void testInsert() {
        String id1 = UUID.randomUUID().toString();
        String id2 = UUID.randomUUID().toString();
        List<String> q1_options = Arrays.asList("option1", "option2", "option3");
        List<String> q2_options = Arrays.asList("option1_2", "option2_2", "option3_2");
        List<String> q1_answers = Arrays.asList("option1");
        List<String> q2_answers = Arrays.asList("option1_2", "option2_2");
        Question stub1 = createQuestionStub(id1, "Q1", q1_options, q1_answers);
        Question stub2 = createQuestionStub(id2, "Q2", q2_options, q2_answers);
        List<Question> entities = Arrays.asList(stub1, stub2);
        given(questionDAO.save(anyCollection())).willReturn(entities);

        List<QuestionDTO> results = questionService.insert(entities);
        assertEquals(2, results.size());
        assert(results.stream().anyMatch(result -> result.getId().equals(id1)));
        assert(results.stream().anyMatch(result -> result.getId().equals(id2)));
    }

    @Test
    public void testListAll() {
        boolean showAnswers = true;
        List<String> q1_options = Arrays.asList("option1", "option2", "option3");
        List<String> q2_options = Arrays.asList("option1_2", "option2_2", "option3_2");
        List<String> q1_answers = Arrays.asList("option1");
        List<String> q2_answers = Arrays.asList("option1_2", "option2_2");
        Question stub1 = createQuestionStub(UUID.randomUUID().toString(), "Q1", q1_options, q1_answers);
        Question stub2 = createQuestionStub(UUID.randomUUID().toString(), "Q2", q2_options, q2_answers);

        given(questionDAO.findAll()).willReturn(Arrays.asList(stub1, stub2));

        List<QuestionDTO> dtos = questionService.listAll(showAnswers);
        assertEquals(2, dtos.size());
        assertEquals(1, dtos.get(0).getAnswers().size());
        assertEquals(2, dtos.get(1).getAnswers().size());
    }

    private Question createQuestionStub(String id, String title, List<String> options, List<String> answers) {
        Question question = new Question();
        question.setId(id);
        question.setTitle(title);
        question.setOptions(options);
        question.setAnswers(answers);
        return question;
    }

    private QuestionDTO createQuestionDTOStub(String id, String title, List<String> options) {
        QuestionDTO dto = new QuestionDTO();
        dto.setId(id);
        dto.setTitle(title);
        dto.setOptions(options);
        return dto;
    }
}
