package rifu.demo.engqiz.service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import rifu.demo.engqiz.core.DTO.QuestionDTO;

@RestController
public class QuestionController {
    @GetMapping
    public QuestionDTO getQuestion() {
        return null;
    }


}
