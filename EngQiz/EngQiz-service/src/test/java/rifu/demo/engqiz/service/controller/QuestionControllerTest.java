package rifu.demo.engqiz.service.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import rifu.demo.engqiz.core.dto.QuestionDTO;

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
    }
}
