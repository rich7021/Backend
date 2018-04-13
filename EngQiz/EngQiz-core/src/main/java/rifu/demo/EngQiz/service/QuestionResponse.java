package rifu.demo.EngQiz.service;

import java.util.List;

public class QuestionResponse {
    private String title;
    private List<String> answers;

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
}
