package dev.forum.repository;
import dev.forum.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUserId(Integer userId);
    User findByUserLoginAndUserPassword(String userLogin, String userPassword);
    boolean existsByUserLogin(String userLogin);
    boolean existsByUserEmail(String userEmail);
}