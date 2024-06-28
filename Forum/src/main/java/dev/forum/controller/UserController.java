package dev.forum.controller;

import dev.forum.dto.UserDTO;
import dev.forum.model.User;
import dev.forum.repository.UserRepository;
import dev.forum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Entry")
public class UserController {
    // Пока между контроллером и репозиториям нет сервиса
    private final UserRepository userRepository;
    private final UserService userService;
    @Autowired
    public UserController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }
    //Вывод всех пользователей
    @GetMapping("/all")
    @ResponseBody
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{userId}")
    public User findByUserId(@PathVariable Integer userId) {
        return userService.findByUserId(userId);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        if (!userService.isLoginAvailable(user.getUserLogin()) ||
                !userService.isEmailAvailable(user.getUserEmail())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Логин или почта уже заняты");
        }
        userService.createUser(user);
        return ResponseEntity.ok("Пользователь успешно создан");
    }

    // Проверка уникальности логина
    @GetMapping("/checkLogin")
    public ResponseEntity<Boolean> checkLogin(@RequestParam String userLogin) {
        boolean isLoginAvailable = userService.isLoginAvailable(userLogin);
        return ResponseEntity.ok(isLoginAvailable);
    }

    @GetMapping("/checkEmail")
    public ResponseEntity<Boolean> checkEmail (@RequestParam String userEmail){
        boolean isEmailAvailable = userService.isEmailAvailable(userEmail);
        return ResponseEntity.ok(isEmailAvailable);
    }
}

