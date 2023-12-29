package com.therprfx.spring.todolist.repositories;

import com.therprfx.spring.todolist.beans.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ToDoRepository extends JpaRepository<Todo, Integer> {

    public List<Todo> findByUsername(String username);
    public Todo findById(int id);
    public Todo deleteById(int id);

}
