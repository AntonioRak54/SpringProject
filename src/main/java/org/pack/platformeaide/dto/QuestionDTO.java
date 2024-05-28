package org.pack.platformeaide.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class QuestionDTO {
    private Long id;
    private String title;
    private String content;
    private Long userId;
    private int likes;

}
