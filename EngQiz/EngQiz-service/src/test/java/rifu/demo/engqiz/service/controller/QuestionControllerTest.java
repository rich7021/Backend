package rifu.demo.engqiz.service.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import rifu.demo.engqiz.core.dto.QuestionDTO;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class QuestionControllerTest {
    @Autowired
    QuestionController questionController;

    @Test
    public void testGetMessage() {
        List<QuestionDTO> response = questionController.findAllQuestion();
        assertEquals("return size not matched", 2, response.size());

//        assertEquals("The cookie is so __________! I love it!", response.getTitle());
//        assertEquals(4, response.getAnswers().stream().count());
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
