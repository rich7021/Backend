package rifu.demo.EngQiz.service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import rifu.demo.EngQiz.service.QuestionDTO;

@RestController
public class QuestionController {
    @GetMapping
    public QuestionDTO getQuestion() {
        return null;
    }


}
