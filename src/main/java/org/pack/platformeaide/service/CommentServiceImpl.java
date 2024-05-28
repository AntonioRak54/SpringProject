package org.pack.platformeaide.service;

import org.pack.platformeaide.controller.NotificationController;
import org.pack.platformeaide.dto.CommentDTO;
import org.pack.platformeaide.model.Comment;
import org.pack.platformeaide.model.Question;
import org.pack.platformeaide.model.User;
import org.pack.platformeaide.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private NotificationController notificationController;

    @Override
    public CommentDTO addComment(CommentDTO commentDTO) {
        Comment comment = new Comment();
        comment.setContent(commentDTO.getContent());
        comment.setUser(new User());
        comment.setQuestion(new Question());
        commentRepository.save(comment);
        commentDTO.setId(comment.getId());

        notificationController.sendNotificationToAll("New comment added to question " + comment.getQuestion().getId());
        return commentDTO;
    }

    @Override
    public List<CommentDTO> getCommentsByQuestionId(Long questionId) {
        return commentRepository.findByQuestionId(questionId).stream()
                .map(comment -> {
                    CommentDTO commentDTO = new CommentDTO();
                    commentDTO.setId(comment.getId());
                    commentDTO.setContent(comment.getContent());
                    return commentDTO;
                }).collect(Collectors.toList());
    }
}
