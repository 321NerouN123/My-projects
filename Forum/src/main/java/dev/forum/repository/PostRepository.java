package dev.forum.repository;
import dev.forum.model.Topic;
import dev.forum.service.*;
import dev.forum.model.Content;
import dev.forum.model.Post;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
 List<Post> findPostByTopicIdOrderByPostIdAsc(Topic topicId);

 List<Post> findByPostDate(Date postDate);
 List<Post> findByTopicId(Topic topicId);

 @Query("SELECT COUNT(p) FROM Post p WHERE p.topicId = :topicId")
 Integer countByTopicId(Topic topicId);

 //Можно будет как-то оптимизировать этот запрос, путем выборки только одной строки
 @Query("SELECT p FROM Post p WHERE p.topicId = :topicId ORDER BY p.postId DESC")
 List<Post> findPostByTopicIdOrderByPostIdDesc(Topic topicId);

 List<Post> findByPostNameContaining(String postName);

}