package dev.forum.dto;

import dev.forum.model.Status;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private String userLogin;
    private String userEmail;
    private String userPassword;
    private Status statusId;
}
