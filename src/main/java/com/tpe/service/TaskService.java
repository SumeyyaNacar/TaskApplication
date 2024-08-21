package com.tpe.service;

import com.tpe.domain.Task;
import com.tpe.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {


    @Autowired
    private TaskRepository repository;

    public void enterTasks(Task task) {
        repository.save(task);
    }

    ///listeyi goruntuleme
    public List<Task> getAllTasks() {
        return repository.getAll();
    }


    //id si verilen taski silme
    public void deleteTask(Long id) {
        repository.delete(id);

    }

    public Task findTaskById(Long identity) {
        Task task = repository.findById(identity)
                .orElseThrow(()->new RuntimeException("Task is not found by ID: "+identity));
        return task;

    }
}
