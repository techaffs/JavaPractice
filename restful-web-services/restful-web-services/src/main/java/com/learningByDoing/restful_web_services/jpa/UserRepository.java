package com.learningByDoing.restful_web_services.jpa;

import com.learningByDoing.restful_web_services.socialmedia.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
