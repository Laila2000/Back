package com.example.GDP.Repesitories;

import com.example.GDP.Entites.Epic;
import com.example.GDP.Entites.User;
import jakarta.validation.OverridesAttribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

}
