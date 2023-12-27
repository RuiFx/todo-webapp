package com.therprfx.spring.todolist.service;

import com.therprfx.spring.todolist.beans.Todo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class ToDoService {

    private static List<Todo> taskList = new ArrayList<>();

    private static int taskCount = 0;

    static {
        taskList.add(new Todo(++taskCount, "rprfelix", "Learn AWS", LocalDate.now().plusYears(1), false));
        taskList.add(new Todo(++taskCount, "rprfelix", "Learn DevOps", LocalDate.now().plusYears(1), false));
        taskList.add(new Todo(++taskCount, "rprfelix", "Learn Azure", LocalDate.now().plusYears(1), false));
    }

    public List<Todo> findByUsername(String username){
        return taskList;
    }

    public Todo findById(int id){
        Predicate<? super Todo> predicate = taskList -> taskList.getId() == id;
        Todo task = taskList.stream().filter(predicate).findFirst().get();
        return task;
    }

    public void deleteById(int id){
        Predicate<? super Todo> predicate = taskList -> taskList.getId() == id;
        taskList.removeIf(predicate);
    }

    public void updateTask(Todo editedTask) {
        deleteById(editedTask.getId());
        taskList.add(editedTask);
    }

    public void addNewTask(String username, String description, LocalDate targetDate, boolean done){
        Todo newTask = new Todo(++taskCount, username, description, targetDate, done);
        taskList.add(newTask);

    }

    public static int getTaskCount() {
        return taskCount;
    }
}
