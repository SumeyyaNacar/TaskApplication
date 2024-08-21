package com.tpe.controller;

import com.tpe.domain.Task;
import com.tpe.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/tasks")
// localhost:8080/TodoApplication/tasks/enterTask + body(form)+ POST--create
// localhost:8080/TodoApplication/tasks + GET--read
// localhost:8080/TodoApplication/tasks/delete/1 + DELETE
// localhost:8080/TodoApplication/tasks/update?id=1+ UPDATE

public class TaskController {

    @Autowired
    private TaskService service;

    //kullaniciya form goster. kullanicidan gelen formu GET(http) methodu ile karsilariz.
    // @GetMapping anotasyonu @RequestMappingden gelen pathi form ile eslestirmeyi saglar
    // localhost:8080/TodoApplication/tasks/form + GET

    @GetMapping("/form")
    public String displayForm(@ModelAttribute("task") Task task){
        return "taskForm";

    }
    //enterTask: ..tasks/enterTask +POST --> response olarak: tum taskleri goster
    // localhost:8080/TodoApplication/tasks/enterTask + POST

    @PostMapping("/enterTask")
    public String createTask(@ModelAttribute("tasks") Task task){
        service.enterTasks(task);
        return "redirect:/tasks";
    }

    //tum tasklari listeleme
    // localhost:8080/TodoApplication/tasks+ GET
    @GetMapping
    public ModelAndView getAllTasks(){
        List<Task> taskList = service.getAllTasks();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("tasks", taskList);
        modelAndView.setViewName("tasks");//bu model hangi sayfada goruntulenecek
        return modelAndView;

    }

    //silme:http://localhost:8080/TodoApplication/tasks/delete/4 + GET--silme islemi sonrasinda taskleri gostermek istedik
    //response: tum taskleri listeleyelim

    @GetMapping("/delete/{identity}")
    public String deleteTask(@PathVariable("{identity}") Long id){
        service.deleteTask(id);
        return "redirect:/tasks";
    }

    //guncelleme: http://localhost:8080/TodoApp254/tasks/update?id=2&yenisorgu + FORM--tum bilgilr +GET(formu gosterme)

    //kullanicidan bilgi almak icin
    //1-form(body)--taskin tum bilgileri alacaksak
    //2-path param--id gibi az bilgi
    //3-query param--id gibi az bilgi

    @GetMapping("/update")
    public ModelAndView displayFormForUpdate(@RequestParam("id") Long identity){
        Task foundTask = service.findTaskById(identity);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("taskForm");
        mav.addObject("task",foundTask);
        return mav;

    }



















}
