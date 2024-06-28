package dev.forum.repository;

import dev.forum.model.Content;
import dev.forum.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepository extends JpaRepository <Topic, Integer>{
    Topic findByTopicId(Integer topicId);
}
