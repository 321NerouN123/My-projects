package dev.forum.service;
import dev.forum.dto.PostContentDTO;
import dev.forum.dto.PostDTO;
import dev.forum.model.Content;
import dev.forum.model.Post;
import dev.forum.model.Topic;
import dev.forum.model.User;
import dev.forum.repository.*;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private final PostRepository postRepository;

    @Autowired
    private ContentRepository contentRepository;

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    public PostService(PostRepository postRepository, ContentRepository contentRepository, TopicRepository topicRepository, UserRepository userRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.contentRepository = contentRepository;
        this.topicRepository = topicRepository;
        this.userRepository = userRepository;
        this.commentRepository = commentRepository;
    }


    public List<Post> getAllByPostDate(Date postDate){
        return postRepository.findByPostDate(postDate);
    }

    public List<Post> getAllPosts(){
        return postRepository.findAll();
    }

    public List<Post> getAllByTopicId(Topic topicId){
        return postRepository.findPostByTopicIdOrderByPostIdAsc(topicId);
    }

    public PostDTO getPostDTO(Integer postId){
        Post post = postRepository.findById(postId).orElseThrow(() -> new RuntimeException("Пост не найден"));
        return new PostDTO(post.getPostName(),post.getPostDate());
    }

    public Optional<Post> getPostById(Integer postId){
        return postRepository.findById(postId);
    }

    public long countPostsByTopicId(Topic topicId) {
        return postRepository.countByTopicId(topicId);
    }

    public Post createPost(PostContentDTO postContentDTO) {
        int i = 0;
        Topic topic = topicRepository.findById(postContentDTO.getTopicId())
                .orElseThrow(() -> new RuntimeException("Topic not found"));

        User user = userRepository.findById(postContentDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Post post = new Post();
        post.setPostName(postContentDTO.getPostName());
        post.setTopicId(topic);
        post.setPostDate(new Date()); // Устанавливаем текущую дату
        post.setPostViews(i); //Установка числа просмотров в ноль
        post.setUserId(user);

        Post savedPost = postRepository.save(post);

        Content content = new Content();
        content.setContentText(postContentDTO.getContentText());
        content.setPostId(savedPost);

        contentRepository.save(content);

        return savedPost;
    }

    public List<Post> findPostByTopicIdOrderByPostIdDesc(Topic topicId){
        return postRepository.findPostByTopicIdOrderByPostIdDesc(topicId);
    }

    public Integer countCommentsByTopicId(Topic topicId) {
        List<Post> posts = postRepository.findByTopicId(topicId);
        return posts.stream()//Создает поток
                .mapToInt(commentRepository::countByPost) //Счиатает комментарии у каждого поста
                .sum(); //Суммирует все комментарии
    }

    public Integer countCommentsPostByTopicId(Post postId){
        return commentRepository.countByPost(postId);
    }

    public Integer countCommentsByPostId(Post postId) {
        return commentRepository.countByPost(postId);
    }

    public void incrementPostViews(Integer postId) {
        Optional<Post> postOptional = postRepository.findById(postId);
        if (postOptional.isPresent()) { //Если пост найден
            Post post = postOptional.get(); //Получние поста в переменную пост
            post.setPostViews(post.getPostViews() + 1);
            postRepository.save(post);
        } else {
            throw new EntityNotFoundException("Пост не найден с id: " + postId);
        }
    }

    public List<Post> findByPostNameContaining(String postName) {
        return postRepository.findByPostNameContaining(postName);
    }

}
