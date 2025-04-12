package com.learningByDoing.restful_web_services.socialmedia.services;

import com.learningByDoing.restful_web_services.socialmedia.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getUsers();
    Optional<User> getUser(Integer id);
}
