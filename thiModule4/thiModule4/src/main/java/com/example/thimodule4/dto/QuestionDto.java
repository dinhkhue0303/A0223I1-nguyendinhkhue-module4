package com.example.thimodule4.dto;

import com.example.thimodule4.model.QuestionType;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

public class QuestionDto implements Validator {
    private Long id;
    private String title;
    private String content;
    private String answer;
    private QuestionType questionType;
    private LocalDate dateCreate;
    private boolean status;

    public QuestionDto() {
    }

    public QuestionDto(Long id, String title, String content, String answer, QuestionType questionType, LocalDate dateCreate, boolean status) {
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        QuestionDto questionDto = (QuestionDto) target;
        if("".equals(questionDto.getTitle())){
            errors.rejectValue("title",null,"không được để trống");
        }else if(questionDto.getTitle().length() <=5 && questionDto.getTitle().length() >= 100){
            errors.rejectValue("title",null,"title không được ít hơn 5 và nhiều hơn 100 ký tự");
        }
        if("".equals(questionDto.getContent())){
            errors.rejectValue("content",null,"không được để trống");
        }else if(questionDto.getContent().length() <= 10 && questionDto.getContent().length() >=500){
            errors.rejectValue("content",null,"content không được ít hơn 10 và nhiều hơn 500 ký tự");
        }
    }
}
