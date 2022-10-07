package com.abkode.springboottodoapp.repository;

import com.abkode.springboottodoapp.models.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TodoItemRepository extends JpaRepository<TodoItem, Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM TASKlIST WHERE TODO_USER_ID= ?1")
    List<TodoItem> findAllByUserId(int id);
}
