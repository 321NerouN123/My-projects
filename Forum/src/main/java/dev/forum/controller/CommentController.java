package dev.forum.controller;

import dev.forum.dto.CommentDTO;
import dev.forum.model.Comment;
import dev.forum.model.Post;
import dev.forum.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Posts")
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService){
        this.commentService = commentService;
    }

    //Получение всех комментов, которые ссылаются на один пост
    @GetMapping("/comment/{postId}")
    public List<Comment> findByPostId(@PathVariable Post postId){
        return commentService.findByPostId(postId);
    }

    @PostMapping("/comment/create")
    public ResponseEntity<Comment> createComment(@RequestBody CommentDTO commentDTO){
        Comment createdComment = commentService.createComment(commentDTO);
        return new ResponseEntity<>(createdComment, HttpStatus.CREATED);
    }


}
