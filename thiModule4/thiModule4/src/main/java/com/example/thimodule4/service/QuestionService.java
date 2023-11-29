package com.example.thimodule4.service;

import com.example.thimodule4.model.Question;
import com.example.thimodule4.repository.IQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class QuestionService implements IQuestionService{
    @Autowired
    IQuestionRepository iQuestionRepository;
    @Override
    public Page<Question> findAll(Pageable pageable, String name) {
        return iQuestionRepository.findQuestionByTitleContaining(pageable,name);
    }

    @Override
    public void save(Question question) {
        iQuestionRepository.save(question);
    }

    @Override
    public void delete(Long id) {
        iQuestionRepository.deleteById(id);
    }

    @Override
    public Question findById(Long id) {
        return iQuestionRepository.findById(id).orElse(null);
    }


}
