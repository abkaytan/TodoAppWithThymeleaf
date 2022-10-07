package com.abkode.springboottodoapp.controller;

import com.abkode.springboottodoapp.models.TodoItem;
import com.abkode.springboottodoapp.models.User;
import com.abkode.springboottodoapp.repository.TodoItemRepository;
import com.abkode.springboottodoapp.repository.UserRepository;
import com.abkode.springboottodoapp.request.AddTodoItemRequest;
import com.abkode.springboottodoapp.request.UserRegistrationRequest;
import com.abkode.springboottodoapp.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;
    private final TodoItemRepository todoItemRepository;


    @GetMapping("/{userId}")
    public User getUserById(@PathVariable Integer userId){
        return userRepository.findById(userId).orElseThrow(()-> new NoSuchElementException());
    }

    @PostMapping("/{userId}/todos")
    public void addTodoItem(@PathVariable Integer userId, @RequestBody AddTodoItemRequest todoItemRequest){
        User user = userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException());
        TodoItem todoItem = new TodoItem();
        todoItem.setDescription(todoItemRequest.getDescription());
        user.getTodoItems().add(todoItem);
        todoItemRepository.save(todoItem);
        userRepository.save(user);
    }

    @GetMapping("{userId}/todos/{todoItemId}")
    public void getTodo(@PathVariable Integer userId,@PathVariable Integer todoItemId){
        User user = userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException());
        TodoItem todoItem = todoItemRepository.findById(todoItemId).orElseThrow(() -> new NoSuchElementException());
        user.getTodoItems().add(todoItem);
        todoItemRepository.findById(todoItemId);
    }



    @PostMapping("/todos/{todoItemId}")
    public void toggleTodoItemCompleted(@PathVariable Integer todoItemId){
        TodoItem todoItem = todoItemRepository.findById(todoItemId).orElseThrow(() -> new NoSuchElementException());
        todoItem.setCompleted(!todoItem.getCompleted());
        todoItemRepository.save(todoItem);
    }

    @DeleteMapping("{userId}/todos/{todoItemId}")
    public void deleteTodo(@PathVariable Integer userId,@PathVariable Integer todoItemId){
        User user = userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException());
        TodoItem todoItem = todoItemRepository.findById(todoItemId).orElseThrow(() -> new NoSuchElementException());
        user.getTodoItems().remove(todoItem);
        todoItemRepository.delete(todoItem);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Integer userId){
        User user = userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException());
        userRepository.delete(user);
    }

}
