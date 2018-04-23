package rifu.demo.engqiz.core.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "QUESTION")
public class Question {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "ID", nullable = false, updatable = false)
    private String id;

    @Column(name = "TITLE")
    private String title;

    @ElementCollection()
    @CollectionTable(
            name = "QUESTION_ANSWERS",
            joinColumns = @JoinColumn(name = "ID", referencedColumnName = "ID")
    )
    @Column(name = "ANSWER")
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

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }
}
