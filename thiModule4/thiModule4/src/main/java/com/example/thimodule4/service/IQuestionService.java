package com.example.thimodule4.service;

import com.example.thimodule4.model.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IQuestionService {
    Page<Question> findAll(Pageable pageable, String name);
    void save(Question question);
    void delete(Long id);
    Question findById(Long id);

}
