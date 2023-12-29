package com.therprfx.spring.todolist.controllers;

import com.therprfx.spring.todolist.beans.Todo;
import com.therprfx.spring.todolist.repositories.ToDoRepository;
import com.therprfx.spring.todolist.service.ToDoService;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("username")
public class ToDoControllerJpa {

    private ToDoRepository toDoRepository;

    public ToDoControllerJpa(ToDoService toDoService, ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    @RequestMapping("welcome")
    public String welcomePage() {
        return "welcome";
    }

    @RequestMapping("task-list")
    public String listAllTasks(ModelMap modelMap) {
        String username = getLoggedInUsername(modelMap);
        List<Todo> taskList = toDoRepository.findByUsername(username);
        modelMap.addAttribute("tasks", taskList);
        return "tasklist";
    }

    @RequestMapping(value = "add-task", method = RequestMethod.GET)
    public String showNewTaskForm(ModelMap modelMap) {
        String username = getLoggedInUsername(modelMap);
        Todo newTask = new Todo(0, username, "Description", LocalDate.now().plusYears(1), false);
        modelMap.put("newTaskForm", newTask);
        modelMap.put("action", "Add Task");
        return "addnewtask";
    }

    @RequestMapping(value = "add-task", method = RequestMethod.POST)
    public String addNewTask(ModelMap modelMap, @Valid Todo newTask, BindingResult result) {
        //Todo validations
        String username = getLoggedInUsername(modelMap);
        newTask.setUsername(username);
        toDoRepository.save(newTask);
        return "redirect:task-list";
    }

    @RequestMapping("delete-task")
    public String deleteTask(@RequestParam int id) {
        toDoRepository.deleteById(id);
        return "redirect:task-list";
    }

    @RequestMapping(value = "edit-task", method = RequestMethod.GET)
    public String showEditTaskForm(@RequestParam int id, ModelMap modelMap) {
        Todo taskToUpdate = toDoRepository.findById(id);
        modelMap.addAttribute("newTaskForm", taskToUpdate);
        modelMap.put("action", "Save Task");
        return "addnewtask";
    }

    @RequestMapping(value = "edit-task", method = RequestMethod.POST)
    public String updateTask(ModelMap modelMap, @Valid Todo editedTask) {
        String username = getLoggedInUsername(modelMap);
        editedTask.setUsername(username);
        toDoRepository.save(editedTask);
        return "redirect:task-list";
    }

    @RequestMapping(value = "cancel-edit-task", method = RequestMethod.POST)
    public String cancelUpdateTask() {
        return "redirect:task-list";
    }

    private static String getLoggedInUsername(ModelMap modelMap) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
