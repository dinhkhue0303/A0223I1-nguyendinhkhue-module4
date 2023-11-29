package com.example.thimodule4.repository;

import com.example.thimodule4.model.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IQuestionRepository extends JpaRepository<Question,Long> {
    Page<Question> findQuestionByTitleContaining(Pageable pageable, String name);

}
