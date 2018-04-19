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

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;

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
    public void testFindAll() {
        List<String> q1_answers = Arrays.asList("answer1", "answer2", "answer3");
        List<String> q2_answers = Arrays.asList("answer1_2", "answer2_2", "answer3_2");
        Question stub1 = createQuestionStub(1L, "Q1", q1_answers);
        Question stub2 = createQuestionStub(2L, "Q2", q2_answers);

        given(questionDAO.findAll()).willReturn(Arrays.asList(stub1, stub2));

        List<QuestionDTO> dtos = questionService.listAll();
        assertEquals(2, dtos.size());
    }

    private Question createQuestionStub(long id, String title, List<String> answers) {
        Question question = new Question();
        question.setId(id);
        question.setTitle(title);
        question.setAnswers(answers);
        return question;
    }
}
