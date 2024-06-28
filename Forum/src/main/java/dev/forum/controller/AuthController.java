package dev.forum.controller;

import dev.forum.model.User;
import dev.forum.repository.UserRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/api/Entry")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        User user = userRepository.findByUserLoginAndUserPassword(loginRequest.getUserLogin(), loginRequest.getUserPassword());
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Collections.singletonMap("success", false));
        }
        // Здесь можно добавить логику для установки сессии или генерации JWT токена
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("user", user); // Добавляем данные пользователя в ответ
        return ResponseEntity.ok(response);
    }
    // Класс для запроса на вход
    @Getter
    @Setter
    public static class LoginRequest {
        private String userLogin;
        private String userPassword;
    }
}