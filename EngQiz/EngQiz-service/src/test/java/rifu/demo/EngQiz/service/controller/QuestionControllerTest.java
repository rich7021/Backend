package rifu.demo.EngQiz.service.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;
import rifu.demo.EngQiz.core.DTO.QuestionDTO;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class QuestionControllerTest {
    @Mock
    QuestionController questionController;

    @Test
    public void testGetMessage() {
        when(questionController.getQuestion()).thenReturn(generateQuestionResponseStub());
        QuestionDTO response = questionController.getQuestion();
        assertEquals("The cookie is so __________! I love it!", response.getTitle());
        assertEquals(4, response.getAnswers().stream().count());
    }

    private QuestionDTO generateQuestionResponseStub() {
        QuestionDTO response = new QuestionDTO();
        response.setTitle("The cookie is so __________! I love it!");
        response.setAnswers(Arrays.asList(
                "delicious", "spicy", "sour", "shit"
        ));
        return response;
    }
}
