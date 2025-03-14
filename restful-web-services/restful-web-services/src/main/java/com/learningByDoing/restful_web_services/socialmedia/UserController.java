package com.learningByDoing.restful_web_services.socialmedia;

import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;



@RestController
public class UserController {

    private UserStaticDaoService service;

    public UserController(UserStaticDaoService service){
        this.service = service;
    }

    @GetMapping("/users")
        public List<User> getAllUsers(){
            return service.findAll();
    }


    @GetMapping("/users/{id}")
    public EntityModel<User> getUser(@PathVariable int id){
        User user = service.findById(id);

        if(user==null)
            throw new UserNotFoundException("id:"+id);

        EntityModel<User> entityModel = EntityModel.of(user); //hateoas: wrapping user to Entity model
        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).getAllUsers()); //hateoas: Creating the link of another resource
        entityModel.add(link.withRel("all-users")); //hateoas: Adding the link to the EntityModel with specific name and return

        return entityModel;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        User savedUSer = service.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(savedUSer.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id){
        service.deleteById(id);
    }

}
