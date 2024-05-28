package org.pack.platformeaide.controller;

import org.pack.platformeaide.dto.CommentDTO;
import org.pack.platformeaide.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping
    public CommentDTO addComment(@RequestBody CommentDTO commentDTO) {
        return commentService.addComment(commentDTO);
    }

    @GetMapping("/question/{questionId}")
    public List<CommentDTO> getCommentsByQuestionId(@PathVariable Long questionId) {
        return commentService.getCommentsByQuestionId(questionId);
    }
}
