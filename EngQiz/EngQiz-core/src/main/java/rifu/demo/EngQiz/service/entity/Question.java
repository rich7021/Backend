package rifu.demo.EngQiz.service.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "QUESTION")
public class Question {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @ElementCollection()
    @CollectionTable(
            name = "QUESTION_ANSWERS",
            joinColumns = @JoinColumn(name = "ID", referencedColumnName = "ID")
    )
    @Column(name = "ANSWER")
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
}
