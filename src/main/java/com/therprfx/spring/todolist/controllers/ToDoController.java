package com.therprfx.spring.todolist.controllers;

import com.therprfx.spring.todolist.beans.Todo;
import com.therprfx.spring.todolist.service.ToDoService;
import jakarta.validation.Valid;
import org.springframework.ui.ModelMap;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
public class ToDoController {

    private ToDoService toDoService;

    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @RequestMapping("task-list")
    public String listAllTasks(ModelMap modelMap) {
        List<Todo> taskList = toDoService.findByUsername("rprfelix");
        modelMap.addAttribute("tasks", taskList);
        return "tasklist";
    }

    @RequestMapping(value = "add-task", method = RequestMethod.GET)
    public String showNewTaskForm(ModelMap modelMap) {
        Todo newTask = new Todo(0, (String) modelMap.get("username"), "Description", LocalDate.now().plusYears(1), false);
        modelMap.addAttribute("newTaskForm", newTask);
        modelMap.put("action", "Add Task");
        return "addnewtask";
    }

    @RequestMapping(value = "add-task", method = RequestMethod.POST)
    public String addNewTask(ModelMap modelMap, @Valid Todo newTask, BindingResult result) {
        //Todo validations
        toDoService.addNewTask((String) modelMap.get("username"), newTask.getDescription(), LocalDate.now().plusYears(1), false);
        return "redirect:task-list";
    }

    @RequestMapping( "delete-task")
    public String deleteTask(@RequestParam int id){
        toDoService.deleteById(id);
        return "redirect:task-list";
    }

    @RequestMapping(value = "edit-task", method = RequestMethod.GET)
    public String showEditTaskForm(@RequestParam int id, ModelMap modelMap) {
        Todo taskToUpdate = toDoService.findById(id);
        modelMap.addAttribute("newTaskForm", taskToUpdate);
        modelMap.put("action", "Save Task");
        return "addnewtask";
    }

    @RequestMapping(value = "edit-task", method = RequestMethod.POST)
    public String updateTask(ModelMap modelMap, @Valid Todo editedTask) {
        toDoService.updateTask(editedTask);
        return "redirect:task-list";
    }
}
