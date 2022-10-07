package com.abkode.springboottodoapp;

import com.abkode.springboottodoapp.configuration.SwaggerConfiguration;
import com.abkode.springboottodoapp.models.TodoItem;
import com.abkode.springboottodoapp.models.User;
import com.abkode.springboottodoapp.repository.TodoItemRepository;
import com.abkode.springboottodoapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableWebMvc
@EnableSwagger2
public class SpringBootTodoappApplication implements CommandLineRunner{

    @Autowired
    SwaggerConfiguration swaggerConfiguration;

    private final UserRepository userRepository;
    private final TodoItemRepository todoItemRepository;

    public SpringBootTodoappApplication(UserRepository userRepository, TodoItemRepository todoItemRepository) {
        this.userRepository = userRepository;
        this.todoItemRepository = todoItemRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootTodoappApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        userRepository.save(User.builder().id(1).firstName("ali").lastName("birinci").email("a@mail.com").password(passwordEncoder.encode("123")).build());
        userRepository.save(User.builder().id(2).firstName("mehmet").lastName("ikinci").email("m@mail.com").password(passwordEncoder.encode("456")).build());

        todoItemRepository.save(TodoItem.builder().id(1).description("math homework").completed(false).userId(1).build());
        todoItemRepository.save(TodoItem.builder().id(2).description("shopping").completed(false).userId(1).build());

        todoItemRepository.save(TodoItem.builder().id(3).description("homework").completed(false).userId(2).build());
        todoItemRepository.save(TodoItem.builder().id(4).description("grocery").completed(false).userId(2).build());


    }

}
