package dev.forum.controller;

import dev.forum.model.Content;
import dev.forum.model.Post;
import dev.forum.model.Topic;
import dev.forum.repository.ContentRepository;
import dev.forum.repository.PostRepository;
import dev.forum.repository.TopicRepository;
import dev.forum.repository.UserRepository;
import dev.forum.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Posts")
public class ContentController {

    private final ContentService contentService;

    @Autowired
    ContentController (ContentService contentService){
        this.contentService = contentService;
    }

    @GetMapping("/content/{postId}")
    public Content findByPostId(@PathVariable Post postId){
        return contentService.findByPostId(postId);
    }
}
