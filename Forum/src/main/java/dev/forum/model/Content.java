package dev.forum.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "content", schema = "public", catalog = "Indie_Developer_Forum")
public class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "content_id", nullable = false)
    private Integer contentId;

    @OneToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Post postId;


    @Column(name = "content_text", nullable = false, columnDefinition = "text")
    private String contentText;
}
