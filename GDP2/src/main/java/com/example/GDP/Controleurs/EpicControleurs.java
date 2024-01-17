package com.example.GDP.Controleurs;

import com.example.GDP.Entites.Epic;
import com.example.GDP.services.EpicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/Epic")
public class EpicControleurs {
    @Autowired
    private EpicService epicservice;
    @PostMapping("/ADDEpic")
    public ResponseEntity<Epic> createEpic(@RequestBody Epic epic) {
        epicservice.createEpic(epic);
        return ResponseEntity.status(HttpStatus.CREATED).body(epic);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Epic> updateEpic(@PathVariable Long id, @RequestBody Epic epic) {
        epicservice.updateEpic(id, epic);
        return ResponseEntity.ok(epic);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEpic(@PathVariable Long id) {
        epicservice.deleteEpic(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("GetEpics")
    public ResponseEntity<List<Epic>> getAllEpics() {
        List<Epic> Epics = epicservice.getAllEpics();
        return ResponseEntity.ok(Epics);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Epic> getEpicById(@PathVariable Long id) {
        Epic epic = epicservice.getEpicById(id);
        if (epic != null) {
            return ResponseEntity.ok(epic);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
