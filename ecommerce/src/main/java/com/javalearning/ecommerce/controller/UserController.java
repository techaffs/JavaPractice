package com.javalearning.ecommerce.controller;

import com.javalearning.ecommerce.model.User;
import com.javalearning.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService userService;


    @GetMapping("/users")
    public List<User> list(){
        return userService.listAllUser();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> get(@PathVariable Integer id){
        try {
            User user = userService.getUser(id);
            return new ResponseEntity<User>(user, HttpStatus.OK);
        }
        catch(NoSuchElementException e){
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/users")
    public void add(@RequestBody User user){
        try {
            userService.saveUser(user);
        }catch(Exception e){
            System.out.println(e.getStackTrace());
        }
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<?> update (@RequestBody User user, @PathVariable Integer id){
        try{
            User existingUser = userService.getUser(id);
            user.setId(id);
            userService.saveUser(user);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/users/{id}")
    public void delete(@PathVariable Integer id){
        userService.deleteUser(id);
    }

}
