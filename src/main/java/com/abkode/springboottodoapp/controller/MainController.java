package com.abkode.springboottodoapp.controller;

import com.abkode.springboottodoapp.models.TodoItem;
import com.abkode.springboottodoapp.models.User;
import com.abkode.springboottodoapp.repository.TodoItemRepository;
import com.abkode.springboottodoapp.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.InputMismatchException;
import java.util.List;

@Controller
public class MainController {

    private final UserRepository userRepository;
    private final TodoItemRepository todoItemRepository;

    public MainController(UserRepository userRepository, TodoItemRepository todoItemRepository) {
        this.userRepository = userRepository;
        this.todoItemRepository = todoItemRepository;
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/index")
    public String home(Model theModel) {
        theModel.addAttribute("users", userRepository.findAll());
        return "index";
    }

    @GetMapping("/tasklist")
    public String tasklist(Model theModel){
        theModel.addAttribute("tasklists", todoItemRepository.findAll());
        return "tasklist";
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable int id){
        User user = userRepository.findById(id).orElseThrow(()-> new InputMismatchException("there is no task with this id"));
        userRepository.delete(user);
        return "redirect:/index";
    }

    /*/tasklist/{id}*/
    @GetMapping("/tasklist/{id}")
    public String showUserTaskList(@PathVariable int id, Model theModel){
        List<TodoItem> todoItem = todoItemRepository.findAllByUserId(id);
        theModel.addAttribute("items", todoItem);
        return "tasklist";
    }

    @GetMapping("/tasklist/delete/{id}")
    public String deleteToDo(@PathVariable int id){
        TodoItem todoItem = todoItemRepository.findById(id).orElseThrow(()-> new InputMismatchException("there is no task with this id"));
        int result = todoItem.getUserId();
        todoItemRepository.delete(todoItem);
        return "redirect:/tasklist/"+result;
    }

    @GetMapping("/tasklist/edit/{id}")
    public String changeStatus(@PathVariable int id){
        TodoItem todoItem = todoItemRepository.findById(id).orElseThrow(()-> new InputMismatchException("there is no task with this id"));
        int result = todoItem.getUserId();
        todoItem.setCompleted(!todoItem.getCompleted());
        todoItemRepository.save(todoItem);
        return "redirect:/tasklist/"+result;
    }

    @GetMapping("/new_task")
    public String showAddTaskPage(TodoItem todoItem){
        return "addtask";
    }

    @PostMapping("/addtask")
    public String addTask(TodoItem todoItem, Model theModel){
        todoItemRepository.save(todoItem);
        int result = todoItem.getUserId();
        return "redirect:/tasklist/"+result;
    }

    /*@GetMapping("/tasklist/{id}")
    public String tasklist(@PathVariable long id ,  Model theModel){
        TodoItem todoItem = todoItemRepository.findById(id).orElseThrow(()->new IllegalArgumentException("there is no item with this id " + id));
        theModel.addAttribute("tasklist", todoItem);
        return "/tasklist/" + id;
    }*/

}

