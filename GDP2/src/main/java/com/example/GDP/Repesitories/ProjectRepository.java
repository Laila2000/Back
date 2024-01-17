package com.example.GDP.Repesitories;

import com.example.GDP.Entites.Project;
import com.example.GDP.Entites.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

}
