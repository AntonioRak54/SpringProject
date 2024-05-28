package org.pack.platformeaide.service;

import org.pack.platformeaide.dto.CommentDTO;

import java.util.List;

public interface CommentService {
    CommentDTO addComment(CommentDTO commentDTO);
    List<CommentDTO> getCommentsByQuestionId(Long questionId);
}