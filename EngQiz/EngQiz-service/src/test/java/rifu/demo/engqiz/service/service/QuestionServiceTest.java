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
        List<String> q1_answers = Arrays.asList("answer1", "answer2", "answer3");
        List<String> q2_answers = Arrays.asList("answer1_2", "answer2_2", "answer3_2");
        Question stub1 = createQuestionStub(id1, "Q1", q1_answers);
        Question stub2 = createQuestionStub(id2, "Q2", q2_answers);
        List<Question> entities = Arrays.asList(stub1, stub2);
        given(questionDAO.save(anyCollection())).willReturn(entities);

        List<QuestionDTO> results = questionService.insert(entities);
        assertEquals(2, results.size());
        assert (results.stream().anyMatch(result -> result.getId().equals(id1)));
        assert (results.stream().anyMatch(result -> result.getId().equals(id2)));
    }

    @Test
    public void testFindAll() {
        List<String> q1_answers = Arrays.asList("answer1", "answer2", "answer3");
        List<String> q2_answers = Arrays.asList("answer1_2", "answer2_2", "answer3_2");
        Question stub1 = createQuestionStub(UUID.randomUUID().toString(), "Q1", q1_answers);
        Question stub2 = createQuestionStub(UUID.randomUUID().toString(), "Q2", q2_answers);

        given(questionDAO.findAll()).willReturn(Arrays.asList(stub1, stub2));

        List<QuestionDTO> dtos = questionService.listAll();
        assertEquals(2, dtos.size());
    }

    private Question createQuestionStub(String id, String title, List<String> answers) {
        Question question = new Question();
        question.setId(id);
        question.setTitle(title);
        question.setAnswers(answers);
        return question;
    }

    private QuestionDTO createQuestionDTOStub(String id, String title, List<String> answers) {
        QuestionDTO dto = new QuestionDTO();
        dto.setId(id);
        dto.setTitle(title);
        dto.setAnswers(answers);
        return dto;
    }
}
