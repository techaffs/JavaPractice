package com.learningByDoing.restful_web_services.socialmedia.controller;

import com.learningByDoing.restful_web_services.socialmedia.UserNotFoundException;
import com.learningByDoing.restful_web_services.socialmedia.model.User;
import com.learningByDoing.restful_web_services.socialmedia.repositories.PostRepository;
import com.learningByDoing.restful_web_services.socialmedia.repositories.UserRepository;
import com.learningByDoing.restful_web_services.socialmedia.services.UserService;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@RestController
@RequestMapping(value = "/jpa")
public class UserJpaController {

    private UserService userService;
    private UserRepository userRepository;
    private PostRepository postRepository;

    public UserJpaController( UserService userService) { //PostRepository postRepository, UserRepository userRepository,
        this.userRepository = userRepository;
        this.postRepository = postRepository;
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return  userService.getUsers();
    }


    @GetMapping("/users/{id}")
    public EntityModel<User> getUser(@PathVariable int id) {
        Optional<User> user = userService.getUser(id);

        if (user.isEmpty())
            throw new UserNotFoundException("id:" + id);

        EntityModel<User> entityModel = EntityModel.of(user.get()); //hateoas: wrapping user to Entity model
        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).getAllUsers()); //hateoas: Creating the link of another resource
        entityModel.add(link.withRel("all-users")); //hateoas: Adding the link to the EntityModel with specific name and return

        return entityModel;
    }
//
//    @PostMapping("/users")
//    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
//        User savedUSer = userRepository.save(user);
//
//        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
//                .path("/{id}").buildAndExpand(savedUSer.getId())
//                .toUri();
//
//        return ResponseEntity.created(location).build();
//    }
//
//    @DeleteMapping("/users/{id}")
//    public void deleteUser(@PathVariable int id) {
//        userRepository.deleteById(id);
//    }
//
//    @GetMapping("/users/{id}/posts")
//    public List<Post> getUserPosts(@PathVariable int id) {
//        Optional<User> user = userRepository.findById(id);
//
//        if (user.isEmpty())
//            throw new UserNotFoundException("id:" + id);
//
//        return user.get().getPosts();
//    }
//
//    @PostMapping("/users/{id}/posts")
//    public ResponseEntity<Object> createUserPost(@PathVariable int id, @Valid @RequestBody Post post) {
//        Optional<User> user = userRepository.findById(id);
//
//        if (user.isEmpty())
//            throw new UserNotFoundException("id:" + id);
//
//        post.setUser(user.get());
//
//        Post savedPost = postRepository.save(post);
//
//        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
//                .path("/{id}").buildAndExpand(savedPost.getId())
//                .toUri();
//        return ResponseEntity.created(location).build();
//    }
//
//    @GetMapping("/jpa/users/{id}/posts/{postId}")
//    public EntityModel<Post> getUserPostById(@PathVariable int id, @PathVariable int postId) {
//        Optional<User> user = userRepository.findById(id);
//        Optional<Post> post = postRepository.findById(postId);
//        if (user.isEmpty())
//            throw new UserNotFoundException("id:" + id);
//        if (post.isEmpty())
//            throw new PostNotFoundException("postId:" + postId);
//
//        EntityModel<Post> entityModel = EntityModel.of(post.get()); //hateoas: wrapping user to Entity model
//        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).getUserPosts(id)); //hateoas: Creating the link of another resource
//        entityModel.add(link.withRel("all-posts")); //hateoas: Adding the link to the EntityModel with specific name and return
//
//        return entityModel;
//    }

}
