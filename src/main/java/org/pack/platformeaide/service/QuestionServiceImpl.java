package org.pack.platformeaide.service;


import org.pack.platformeaide.dto.QuestionDTO;
import org.pack.platformeaide.model.Question;
import org.pack.platformeaide.model.User;
import org.pack.platformeaide.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public QuestionDTO addQuestion(QuestionDTO questionDTO) {
        Question question = new Question();
        question.setTitle(questionDTO.getTitle());
        question.setContent(questionDTO.getContent());
        question.setUser(new User()); // Set the actual user here
        questionRepository.save(question);
        questionDTO.setId(question.getId());
        return questionDTO;
    }

    @Override
    public QuestionDTO getQuestionById(Long id) {
        Question question = questionRepository.findById(id).orElseThrow(() -> new RuntimeException("Question not found"));
        QuestionDTO questionDTO = new QuestionDTO();
        questionDTO.setId(question.getId());
        questionDTO.setTitle(question.getTitle());
        questionDTO.setContent(question.getContent());
        questionDTO.setLikes(question.getLikes());
        return questionDTO;
    }

    @Override
    public List<QuestionDTO> getAllQuestions() {
        return questionRepository.findAll().stream().map(question -> {
            QuestionDTO questionDTO = new QuestionDTO();
            questionDTO.setId(question.getId());
            questionDTO.setTitle(question.getTitle());
            questionDTO.setContent(question.getContent());
            questionDTO.setLikes(question.getLikes());
            return questionDTO;
        }).collect(Collectors.toList());
    }

    @Override
    public void likeQuestion(Long id) {
        Question question = questionRepository.findById(id).orElseThrow(() -> new RuntimeException("Question not found"));
        question.setLikes(question.getLikes() + 1);
        questionRepository.save(question);
    }
}