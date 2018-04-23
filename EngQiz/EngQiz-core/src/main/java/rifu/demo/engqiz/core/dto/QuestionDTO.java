package rifu.demo.engqiz.core.dto;

import org.springframework.beans.BeanUtils;
import rifu.demo.engqiz.core.entity.Question;

import java.util.List;

public class QuestionDTO {
    private Long id;
    private String title;
    private List<String> answers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    public static QuestionDTO toDTO(Question pojo) {
        QuestionDTO dto = new QuestionDTO();
        BeanUtils.copyProperties(pojo, dto);
        return dto;
    }
}
