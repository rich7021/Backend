package rifu.demo.engqiz.service.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import rifu.demo.engqiz.core.dto.QuestionDTO;
import rifu.demo.engqiz.service.TestApplicationConfig;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * the same as SpringJUnit4ClassRunner.
 * https://docs.spring.io/spring/docs/4.3.0.RC2_to_4.3.0.RELEASE/Spring%20Framework%204.3.0.RELEASE/org/springframework/test/context/junit4/SpringRunner.html
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TestApplicationConfig.class})
public class QuestionControllerTest {
    @Autowired
    QuestionController questionController;

    @Test
    public void testGetMessage() {
        List<QuestionDTO> response = questionController.findAllQuestion();
        assertEquals("return size not matched", 2, response.size());
    }
}
