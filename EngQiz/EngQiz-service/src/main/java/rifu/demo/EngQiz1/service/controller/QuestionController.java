package rifu.demo.EngQiz1.service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import rifu.demo.EngQiz1.core.DTO.QuestionDTO;

@RestController
public class QuestionController {
    @GetMapping
    public QuestionDTO getQuestion() {
        return null;
    }


}
