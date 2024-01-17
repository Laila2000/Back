package com.example.GDP.Controleurs;

import com.example.GDP.Entites.Project;
import com.example.GDP.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@Controller
@RestController
@RequestMapping("/Project")
public class ProjectControleurs {
    @Autowired

    private ProjectService projectservice;
    @PostMapping("/Add")
    public ResponseEntity<Project> createProject(@RequestBody Project project) {
        projectservice.createProject(project);
        return ResponseEntity.status(HttpStatus.CREATED).body(project);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
        projectservice.deleteProject(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable Long id, @RequestBody Project project) {
        projectservice.updateProject(id, project);
        return ResponseEntity.ok(project);
    }
    @GetMapping("/Getprojects")
    public ResponseEntity<List<Project>> getAllProjects() {
        List<Project> projects = projectservice.getAllProjects();
        return ResponseEntity.ok(projects);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable Long id) {
        Project project = projectservice.getProjectById(id);
        if (project != null) {
            return ResponseEntity.ok(project);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
