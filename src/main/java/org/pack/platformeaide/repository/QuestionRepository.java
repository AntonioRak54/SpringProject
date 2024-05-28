package org.pack.platformeaide.repository;

import org.pack.platformeaide.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
