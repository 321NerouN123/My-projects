package dev.forum.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Entity
@Setter
@Getter
@Table(name = "user", schema = "public", catalog = "Indie_Developer_Forum")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "user_login", nullable = false, length = 25)
    private String userLogin;

    @Column(name = "user_password", nullable = false, length = 100)
    private String userPassword;

    @Column(name = "user_email", nullable = false, length = 30)
    private String userEmail;
    @ManyToOne
    @JoinColumn(name = "status_id", nullable = false)
    private Status statusId;
    public User() {
    }

    public User(Integer userId, String userLogin, String userPassword, String userEmail, Status statusId) {
        this.userId = userId;
        this.userLogin = userLogin;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
        this.statusId = statusId;
    }



}
