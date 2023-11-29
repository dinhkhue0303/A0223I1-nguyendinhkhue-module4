package com.example.thimodule4.service;

import com.example.thimodule4.model.QuestionType;
import com.example.thimodule4.repository.IQuestionTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class QuestionTypeService implements IQuestionTypeService{
    @Autowired
    IQuestionTypeRepository iQuestionTypeRepository;
    @Override
    public List<QuestionType> findAll() {
        return iQuestionTypeRepository.findAll();
    }
}
