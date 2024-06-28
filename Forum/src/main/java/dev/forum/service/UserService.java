package dev.forum.service;

import dev.forum.dto.UserDTO;
import dev.forum.model.Topic;
import dev.forum.model.User;
import dev.forum.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User findByUserId(Integer userId){
        return userRepository.findByUserId(userId);
    }

    public void createUser(User user) {
        userRepository.save(user);
    }

    public boolean isLoginAvailable(String userLogin) {
        return !userRepository.existsByUserLogin(userLogin);
    }

    public boolean isEmailAvailable(String userEmail) {
        return !userRepository.existsByUserEmail(userEmail);
    }
}
