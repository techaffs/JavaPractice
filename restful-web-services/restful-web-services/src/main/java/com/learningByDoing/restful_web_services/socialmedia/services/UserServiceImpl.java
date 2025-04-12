package com.learningByDoing.restful_web_services.socialmedia.services;

import com.learningByDoing.restful_web_services.socialmedia.model.User;
import com.learningByDoing.restful_web_services.socialmedia.exception.RepositoryNotInitializedException;
import com.learningByDoing.restful_web_services.socialmedia.repositories.UserRepository;
import com.learningByDoing.restful_web_services.socialmedia.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getUsers() {
//        userRepository = null;
        if (userRepository == null)
            throw new RepositoryNotInitializedException("UserRepository is not initialized!");
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUser(Integer id) {
        if (userRepository == null)
            throw new RepositoryNotInitializedException("UserRepository is not initialized!");

        return userRepository.findById(id);
    }

}
