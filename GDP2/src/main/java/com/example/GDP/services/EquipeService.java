package com.example.GDP.services;

import com.example.GDP.Entites.Equip;
import com.example.GDP.Repesitories.EquipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipeService {
    @Autowired
    private  EquipRepository equipRepository;

    public Equip createEquipe(Equip equipe) {
        return equipRepository.save(equipe);
    }

    public void deleteEquipe(Long id) {
        equipRepository.deleteById(id);
    }

    public Equip updateEquipe(Long id, Equip equipe) {
        Equip existingEquipe = equipRepository.findById(id).orElse(null);
        if (existingEquipe != null) {
            existingEquipe.setNom(equipe.getNom());
            existingEquipe.setRole(equipe.getRole());

            equipRepository.save(existingEquipe);
        }
        return existingEquipe;
    }
    public List<Equip> getAllEquipe() {
        return equipRepository.findAll();
    }


}
