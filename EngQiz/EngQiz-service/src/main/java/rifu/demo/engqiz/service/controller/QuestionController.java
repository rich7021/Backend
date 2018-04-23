package rifu.demo.engqiz.service.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import rifu.demo.engqiz.core.dto.QuestionDTO;
import rifu.demo.engqiz.core.entity.Question;
import rifu.demo.engqiz.service.service.QuestionService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "questions")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void insert(@RequestBody List<QuestionDTO> createQuestionList) {
        List<Question> createEntities = createQuestionList.stream().map(request -> {
            Question entity = new Question();
            BeanUtils.copyProperties(request, entity);
            return entity;
        }).collect(Collectors.toList());
        questionService.insert(createEntities);
    }

    @GetMapping
    public List<QuestionDTO> findAllQuestion() {
        return questionService.listAll();
    }
}
