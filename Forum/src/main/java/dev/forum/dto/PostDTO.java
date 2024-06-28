package dev.forum.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PostDTO {
    private String postName;

    private Date postDate;


    //Конструктор для вывода названия поста
    public PostDTO(String postName) {
        this.postName = postName;

    }

    //Конструктор для вывода названия и даты поста
    public PostDTO(String postName, Date postDate) {
        this.postName = postName;
        this.postDate = postDate;
    }


}
