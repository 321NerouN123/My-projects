package dev.forum.controller;

import dev.forum.dto.PostContentDTO;
import dev.forum.model.Content;
import dev.forum.model.Post;
import dev.forum.model.Topic;
import dev.forum.service.ContentService;
import dev.forum.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Posts")
public class PostController {

    @Autowired
    private final PostService postService;
    private final ContentService contentService;

    @Autowired
    public PostController(PostService postService, ContentService contentService) {
        this.postService = postService;
        this.contentService = contentService;
    }

    //Вывод всеех постов
    @GetMapping("/all")
    public List<Post> getAllPosts(){
        return postService.getAllPosts();
    }

    //Вывод всех постов по конкретной дате
    //Передача данных(Даты) идет через параметр запроса
    @GetMapping("/allPostByDate")
    public List<Post> getAllByPostDate(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date postDate){
        return postService.getAllByPostDate(postDate);
    }

    //Вывод всех постов по конкретному id категории в порядке возрастания
    //Передача данных(id категории) идет через параметр запроса
    @GetMapping("/allPostByTopicId")
    public List<Post> getAllByTopicId(@RequestParam Topic topicId){
        return postService.getAllByTopicId(topicId);
    }

    //Вывод названия поста по его id
    //Передача данных(id поста) идет через переменную часть пути. Также используется DTO для вывода только даты созданя и названия поста
   // @GetMapping("/{postId}")
    //public PostDTO getPostById(@PathVariable Integer postId){
      //  return postService.getPostDTO(postId);
   // }

    //Выводит всю информацию о посте, по его id
    //Передача данных(id поста) идет через переменную часть пути
    @GetMapping("/{postId}")
    public Optional<Post> getPostById(@PathVariable Integer postId){
         return postService.getPostById(postId);
    }

    //Подсчет количества постов по определенной категории
    @GetMapping("/count")
    public long getCountByTopicId(@RequestParam Topic topicId) {
        return postService.countPostsByTopicId(topicId);
    }

    //Создание поста через форму. Отправка названия и текста поста, и нужной категории. Также надо добавить добавление userId уже через сессию или токены
    @PostMapping("/create")
    public ResponseEntity<Post> createPost(@RequestBody PostContentDTO postContentDTO) {
        Post createdPost = postService.createPost(postContentDTO);
        return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
    }

    //Выводит информацию о посте, сортируя строки по убыванию даты
    @GetMapping("/lastPost")
    public List<Post> findPostByTopicIdOrderByPostIdDesc(@RequestParam Topic topicId){
        return postService.findPostByTopicIdOrderByPostIdDesc(topicId);
    }

    //Возвращает кол-во комментов у топика
    @GetMapping("/comment/count")
    public Integer countCommentsByTopicId(@RequestParam Topic topicId) {
        return postService.countCommentsByTopicId(topicId);
    }

    //Возвращает кол-во комментов у одного поста
   /* @GetMapping("/commentsPost/count")
    public Integer countCommentsPostByTopicId(@RequestParam Post postId) {
        return postService.countCommentsPostByTopicId(postId);
    }
    */


    //Возвращает кол-во комментов у одного поста
    @GetMapping("/{postId}/comments/count")
    public Integer countCommentsByPostId(@PathVariable Post postId) {
        return postService.countCommentsByPostId(postId);
    }

    //Изменяет число просмотор на +1 при открытии соответствующего поста
    @PutMapping("/{postId}/incrementViews")
    public ResponseEntity<Void> incrementPostViews(@PathVariable Integer postId) {
        postService.incrementPostViews(postId);
        return ResponseEntity.ok().build();
    }

    //Возвращает все названия постов, удовлетворяющих поиску
    @GetMapping("/searchPosts")
    public ResponseEntity<List<Post>> searchPosts(@RequestParam String postName) {
        List<Post> posts = postService.findByPostNameContaining(postName);
        return ResponseEntity.ok(posts);
    }
}
