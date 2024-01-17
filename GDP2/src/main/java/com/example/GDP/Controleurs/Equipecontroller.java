package com.example.GDP.Controleurs;

import com.example.GDP.Entites.Equip;
import com.example.GDP.services.EquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Controller
@RestController
@RequestMapping("/Equip")
public class Equipecontroller {
    @Autowired
    private EquipeService equipeservice;
    @PostMapping("/ADDEquip")
    public ResponseEntity<Equip> createEquip(@RequestBody Equip equip) {
        Equip createEquip=equipeservice.createEquipe(equip);
        return ResponseEntity.status(HttpStatus.CREATED).body(createEquip);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Equip> updateEquipe(@PathVariable Long id, @RequestBody Equip updatedEquipe) {
        Equip equipe = equipeservice.updateEquipe(id, updatedEquipe);
        if (equipe != null) {
            return ResponseEntity.ok(equipe);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEquipe(@PathVariable Long id) {
        equipeservice.deleteEquipe(id);
        return ResponseEntity.noContent().build();


    }
    @GetMapping("/GetEquipes")
    public ResponseEntity<List<Equip>> getAllEquipe() {
        List<Equip>equipe= equipeservice.getAllEquipe();
        return ResponseEntity.ok(equipe);
    }


}

