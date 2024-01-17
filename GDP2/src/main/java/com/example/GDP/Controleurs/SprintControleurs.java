package com.example.GDP.Controleurs;

import com.example.GDP.Entites.Sprint;
import com.example.GDP.services.SprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("Sprints")
public class SprintControleurs {
    @Autowired
    private SprintService sprintservice;
    @PostMapping("/ADDSprint")
    public ResponseEntity<Sprint> createSprint(@RequestBody Sprint sprint) {
        sprintservice.createSprint(sprint);
        return ResponseEntity.status(HttpStatus.CREATED).body(sprint);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Sprint> updateSprint(@PathVariable Long id, @RequestBody Sprint sprint) {
        sprintservice.updateSprint(id, sprint);
        return ResponseEntity.ok(sprint);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSprint(@PathVariable Long id) {
        sprintservice.deleteSprint(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/GetSprints")
    public ResponseEntity<List<Sprint>> getAllSprints() {
        List<Sprint> sprints = sprintservice.getAllSprint();
        return ResponseEntity.ok(sprints);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Sprint> getSprintById(@PathVariable Long id) {
        Sprint sprint = sprintservice.getSprintById(id);
        if (sprint != null) {
            return ResponseEntity.ok(sprint);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
