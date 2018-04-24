package rifu.demo.engqiz.core.dto;

import org.springframework.beans.BeanUtils;
import rifu.demo.engqiz.core.entity.Question;

import java.util.List;

public class QuestionDTO {
    private String id;
    private String title;
    private List<String> options;
    private List<String> answers;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    public static QuestionDTO toDTO(Question pojo, boolean showAnswers) {
        QuestionDTO dto = new QuestionDTO();
        BeanUtils.copyProperties(pojo, dto);
        if (showAnswers == false) {
            dto.setAnswers(null);
        }
        return dto;
    }
}
