package dev.forum.service;

import dev.forum.dto.CommentDTO;
import dev.forum.model.Comment;
import dev.forum.model.Post;
import dev.forum.model.Topic;
import dev.forum.model.User;
import dev.forum.repository.CommentRepository;
import dev.forum.repository.PostRepository;
import dev.forum.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CommentService {

    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository, UserRepository userRepository, PostRepository postRepository){
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    public List<Comment> findByPostId(Post postId){
        return commentRepository.findByPostId(postId);
    }

    public Comment createComment(CommentDTO commentDTO){
        User user = userRepository.findById(commentDTO.getUserId())
            .orElseThrow(() -> new RuntimeException("User not found"));

        Post post = postRepository.findById(commentDTO.getPostId())
                .orElseThrow(() -> new RuntimeException("Post not found"));

        Comment comment = new Comment();

        comment.setUserId(user);
        comment.setPostId(post);
        comment.setCommentText(commentDTO.getCommentText());
        comment.setCommentDate(new Date());

        commentRepository.save(comment);

        return comment;
    }


}
