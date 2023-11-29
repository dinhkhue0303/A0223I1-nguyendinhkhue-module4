package com.example.thimodule4.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private String answer;
    @ManyToOne
    @JoinColumn(name = "question_type_id", referencedColumnName = "id")
    private QuestionType questionType;
    private LocalDate dateCreate;
    private boolean status;

    public Question() {
    }

    public Question(Long id, String title, String content, String answer, QuestionType questionType, LocalDate dateCreate, boolean status) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.answer = answer;
        this.questionType = questionType;
        this.dateCreate = dateCreate;
        this.status = status;
    }

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }

    public LocalDate getDateCreate() {
        return dateCreate;
    }
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public void setDateCreate(LocalDate dateCreate) {
        this.dateCreate = dateCreate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
