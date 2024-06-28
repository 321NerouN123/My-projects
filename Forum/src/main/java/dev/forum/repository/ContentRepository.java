package dev.forum.repository;

import dev.forum.model.Content;
import dev.forum.model.Post;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContentRepository extends JpaRepository <Content, Integer> {
    Content findByPostId(Post postId);
}
