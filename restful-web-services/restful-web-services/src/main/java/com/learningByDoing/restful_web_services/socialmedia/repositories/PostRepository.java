package com.learningByDoing.restful_web_services.socialmedia.repositories;

import com.learningByDoing.restful_web_services.socialmedia.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
