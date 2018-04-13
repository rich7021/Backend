package rifu.demo.EngQiz.service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import rifu.demo.EngQiz.service.QuestionResponse;

@RestController
public class QuestionController {
    @GetMapping
    public QuestionResponse getQuestion() {
        return null;
    }


}
