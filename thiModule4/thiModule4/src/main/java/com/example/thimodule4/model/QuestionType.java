package com.example.thimodule4.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class QuestionType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "questionType", cascade = CascadeType.ALL)
    Set<Question> questionset;

    public QuestionType() {
    }

    public QuestionType(Long id, String name, Set<Question> questionset) {
        this.id = id;
        this.name = name;
        this.questionset = questionset;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Question> getQuestionset() {
        return questionset;
    }

    public void setQuestionset(Set<Question> questionset) {
        this.questionset = questionset;
    }
}
