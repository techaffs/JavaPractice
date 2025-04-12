package com.learningByDoing.restful_web_services.socialmedia.repositories;

import com.learningByDoing.restful_web_services.socialmedia.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findAll();
    Optional<User> findById(Integer id);
}
