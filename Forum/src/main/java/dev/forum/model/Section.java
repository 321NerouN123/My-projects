package dev.forum.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "section", schema = "public", catalog = "Indie_Developer_Forum")
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "section_id", nullable = false)
    private Integer sectionId;

    @Column(name = "section_name", nullable = false, length = 100)
    private String sectionName;
}
