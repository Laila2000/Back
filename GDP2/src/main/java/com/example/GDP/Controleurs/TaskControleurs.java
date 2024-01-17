package com.example.GDP.Controleurs;

import com.example.GDP.Entites.Task;
import com.example.GDP.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/Tasks")
public class TaskControleurs {
    @Autowired
    private TaskService taskService;
    @PostMapping("/ADDTask")
    public ResponseEntity<Task> createTache(@RequestBody Task tache) {
        Task createTask = taskService.createTask(tache);
        return ResponseEntity.status(HttpStatus.CREATED).body(createTask);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTache(@PathVariable Long id, @RequestBody Task updatedTache) {
        Task tache = taskService.updateTask(id, updatedTache);
        if (tache != null) {
            return ResponseEntity.ok(tache);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTache(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();


    }
    @GetMapping("GetTasks")
    public ResponseEntity<List<Task>> getAllTache() {
        List<Task>tasks= taskService.getAllTache();
        return ResponseEntity.ok(tasks);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Task> getTacheById(@PathVariable Long id) {
        Task tache = taskService.getTacheById(id);
        if (tache != null) {
            return ResponseEntity.ok(tache);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
