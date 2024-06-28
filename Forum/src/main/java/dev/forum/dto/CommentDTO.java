package dev.forum.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDTO {
    private Integer userId;
    private Integer postId;
    private String commentText;
}
