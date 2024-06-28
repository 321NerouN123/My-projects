package dev.forum.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "post", schema = "public", catalog = "Indie_Developer_Forum")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id", nullable = false)
    private Integer postId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User userId;

    @ManyToOne
    @JoinColumn(name = "topic_id", nullable = false)
    private Topic topicId;

    @Column(name = "post_name", nullable = false, length = 255)
    private String postName;

    @Column(name = "post_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date postDate;

    @Column(name = "post_views", nullable = false)
    private Integer postViews;
}
