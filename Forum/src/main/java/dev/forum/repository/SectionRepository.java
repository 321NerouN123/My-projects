package dev.forum.repository;

import dev.forum.model.Content;
import dev.forum.model.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectionRepository extends JpaRepository <Section, Integer>{
}
