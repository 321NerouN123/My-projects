package dev.forum.repository;

import dev.forum.model.Comment;
import dev.forum.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
    List<Comment> findByPostId(Post postId);

    @Query("SELECT COUNT(c) FROM Comment c WHERE c.postId = :postId")
    Integer countByPost(Post postId);


}
