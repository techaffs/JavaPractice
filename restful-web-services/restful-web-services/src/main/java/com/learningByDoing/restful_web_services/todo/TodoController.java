package com.learningByDoing.restful_web_services.todo;

import com.learningByDoing.restful_web_services.socialmedia.UserNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/basicauth")
    public String basicAuthCheck(){
        return "Success";
    }

    @GetMapping("/users/{username}/todos")
    public List<Todo> getTodos(@PathVariable String username){
        return todoService.findByUsername(username);
    }

    @GetMapping("/users/{username}/todo/{id}")
    public Todo getTodos(@PathVariable String username, @PathVariable int id){
        if(todoService.findByUsername(username).isEmpty())
            throw new UserNotFoundException("username:" + username);

        return todoService.findById(id);
    }

    @DeleteMapping("/users/{username}/todo/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable int id){
        if(todoService.findByUsername(username).isEmpty())
            throw new UserNotFoundException("username:" + username);

        todoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/users/{username}/todo/{id}")
    public Todo deleteTodo(@PathVariable String username, @PathVariable int id, @RequestBody Todo todo){
        if(todoService.findByUsername(username).isEmpty())
            throw new UserNotFoundException("username:" + username);
        todoService.updateTodo(todo);
        return todo;
    }

    @PostMapping ("/users/{username}/todo")
    public Todo saveTodo(@PathVariable String username, @RequestBody Todo todo){
        if(todoService.findByUsername(username).isEmpty())
            throw new UserNotFoundException("username:" + username);
        Todo createdTodo = todoService.addTodo(username, todo.getDescription(), todo.getTargetDate(), todo.getIsDone());
        return createdTodo;
    }
}
