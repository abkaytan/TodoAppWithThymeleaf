//package com.abkode.springboottodoapp.util;
//
//import com.abkode.springboottodoapp.models.TodoItem;
//import com.abkode.springboottodoapp.models.User;
//import com.abkode.springboottodoapp.repository.TodoItemRepository;
//import com.abkode.springboottodoapp.repository.UserRepository;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Component;
//
//@Component
//public class InitializerRunner implements CommandLineRunner {
//
//    private static final Logger logger = LoggerFactory.getLogger(InitializerRunner.class);
//
//    private final UserRepository userRepository;
//    private final TodoItemRepository todoItemRepository;
//
//    public InitializerRunner(UserRepository userRepository, TodoItemRepository todoItemRepository) {
//        this.userRepository = userRepository;
//        this.todoItemRepository = todoItemRepository;
//    }
//
//
//    @Override
//    public void run(String... args) throws Exception {
//
//        User user = new User();
//        user.setId(1L);
//        user.setFirstName("abkode");
//        user.setLastName("bkaytan");
//        user.setEmail("abkode@test.com");
//        user.setPassword("123456");
//
//        TodoItem todoItem = new TodoItem();
//        todoItem.setId(1L);
//        todoItem.setDescription("Start the Todo-App");
//        todoItem.getCompleted();
//
//        user.getTodoItems().add(todoItem);
//
//        todoItemRepository.save(todoItem);
//        userRepository.save(user);
//
//
//    }
//}
