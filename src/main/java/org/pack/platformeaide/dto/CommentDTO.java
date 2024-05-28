package org.pack.platformeaide.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CommentDTO {
    private Long id;
    private String content;
    private Long userId;
    private Long questionId;
}
