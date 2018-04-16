package rifu.demo.engqiz.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import rifu.demo.engqiz.core.dto.QuestionDTO;
import rifu.demo.engqiz.service.service.QuestionService;

import java.util.List;

@RestController(value = "questions")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping
    public List<QuestionDTO> findAllQuestion() {
        return questionService.listAll();
    }


}
