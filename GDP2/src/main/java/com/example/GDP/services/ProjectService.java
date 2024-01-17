package com.example.GDP.services;

import com.example.GDP.Entites.Project;
import com.example.GDP.Repesitories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    @Autowired

    private ProjectRepository projectRepository;
    public  void  createProject (Project project){
        projectRepository.save(project); }

    public  void  updateProject (Long id ,Project project){
        Project existingProject = projectRepository.findById(id).orElse(null);
        if (existingProject != null){
            project.setId(id);
            project.setNom(project.getNom());
            project.setDescription(project.getDescription());
            project.setDate_debut(project.getDate_debut());
            project.setDate_fin((project.getDate_fin()));

            projectRepository.save(project);}

    }

    public  void deleteProject (Long id){
        projectRepository.deleteById(id);
    }
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }
    public Project getProjectById(Long id) {
        return projectRepository.findById(id).orElse(null);
    }

}
