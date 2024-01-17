package com.example.GDP.Repesitories;

import com.example.GDP.Entites.Equip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipRepository extends JpaRepository<Equip, Long> {
}
