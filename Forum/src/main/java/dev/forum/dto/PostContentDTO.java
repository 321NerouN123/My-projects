package dev.forum.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostContentDTO {
    private String postName;
    private String contentText;
    private Integer topicId;
    private Integer userId;
}
