package dev.forum.controller;

import dev.forum.model.Topic;
import dev.forum.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/CreatePost")
public class TopicController {
    @Autowired
    private final TopicService topicService;

    @Autowired
    public TopicController(TopicService topicService){
        this.topicService = topicService;
    }

    @GetMapping("/{topicId}")
    public Topic findByTopicId(@PathVariable Integer topicId){
        return topicService.findByTopicId(topicId);
    }
}
