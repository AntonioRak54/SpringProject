package org.pack.platformeaide.service;

import org.pack.platformeaide.dto.QuestionDTO;

import java.util.List;

public interface QuestionService {
    QuestionDTO addQuestion(QuestionDTO questionDTO);
    QuestionDTO getQuestionById(Long id);
    List<QuestionDTO> getAllQuestions();
    void likeQuestion(Long id);
}
