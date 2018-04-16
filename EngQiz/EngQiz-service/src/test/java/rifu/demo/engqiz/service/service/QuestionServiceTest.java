package rifu.demo.engqiz.service.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import rifu.demo.engqiz.core.dto.QuestionDTO;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class QuestionServiceTest {
    @Autowired
    QuestionService questionService;

    @Test
    public void testFindAll() {
        List<QuestionDTO> dtos = questionService.listAll();
        assertEquals(2, dtos.size());
    }
}
