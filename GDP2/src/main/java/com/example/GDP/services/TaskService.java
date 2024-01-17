package com.example.GDP.services;

import com.example.GDP.Entites.Task;
import com.example.GDP.Repesitories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
   @Autowired
   private TaskRepository taskRepository;

    public List<Task> getAllTache() {
        return taskRepository.findAll();
    }



    public Task createTask(Task task) {
        return taskRepository.save(task);
    }


    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTacheById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    public Task updateTask(Long id, Task updatedTask) {
        Task existingTask = taskRepository.findById(id).orElse(null);
        if (existingTask != null) {

            existingTask.setId(updatedTask.getId());
            existingTask.setDescription(updatedTask.getDescription());
            existingTask.setTitre(updatedTask.getTitre());

            existingTask.setStatute(updatedTask.getTitre());

            return taskRepository.save(existingTask);
        }
        return null;
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
