package com.example.thimodule4.repository;

import com.example.thimodule4.model.QuestionType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IQuestionTypeRepository extends JpaRepository<QuestionType,Long> {
}
