package dev.forum.service;

import dev.forum.model.Content;
import dev.forum.model.Post;
import dev.forum.repository.ContentRepository;
import dev.forum.repository.PostRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class ContentService {

    private final ContentRepository contentRepository;

    @Autowired
    ContentService (ContentRepository contentRepository){
        this.contentRepository = contentRepository;
    }

    public Content findByPostId(Post postId){
        return contentRepository.findByPostId(postId);
    }
}
