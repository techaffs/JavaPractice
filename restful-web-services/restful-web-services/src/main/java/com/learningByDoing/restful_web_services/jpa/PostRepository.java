package com.learningByDoing.restful_web_services.jpa;

import com.learningByDoing.restful_web_services.socialmedia.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
