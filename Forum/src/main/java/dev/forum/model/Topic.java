package dev.forum.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.w3c.dom.CDATASection;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "topic", schema = "public", catalog = "Indie_Developer_Forum")
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "topic_id", nullable = false)
    private Integer topicId;

    @ManyToOne
    @JoinColumn(name = "section_id", nullable = false)
    private Section sectionId;

    @Column(name = "topic_name", nullable = false, length = 100)
    private String topicName;


}
