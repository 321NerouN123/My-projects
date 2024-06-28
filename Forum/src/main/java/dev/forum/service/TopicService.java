package dev.forum.service;

import dev.forum.model.Topic;
import dev.forum.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
    private final TopicRepository topicRepository;

    @Autowired
    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    public Topic findByTopicId(Integer topicId){
        return topicRepository.findByTopicId(topicId);
    }
}
