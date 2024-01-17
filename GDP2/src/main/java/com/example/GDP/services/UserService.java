package com.example.GDP.services;

import com.example.GDP.Entites.Project;
import com.example.GDP.Entites.Task;
import com.example.GDP.Entites.User;
import com.example.GDP.Repesitories.ProjectRepository;
import com.example.GDP.Repesitories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProjectRepository projectRepository;
    public boolean isUserPresent(String email,String password) {

        User user =userRepository.findByEmail(email);
        if(user==null)
            return false;
        return password.equals(user.getMdp());

    }
    public User createUser(User user) {
        return userRepository.save(user);
    }
    public User updateUser(Long id, User updatedUser) {
        User existingUser= userRepository.findById(id).orElse(null);
        if (existingUser != null) {

            existingUser.setId(id);
            existingUser.setNom(updatedUser.getNom());
            existingUser.setCompany(updatedUser.getCompany());
            existingUser.setEmail(updatedUser.getEmail());
            existingUser.setMdp(updatedUser.getMdp());
            return  userRepository.save(existingUser);
        }
        return null;
    }
    public void DeleteUser(Long id) {
        userRepository.deleteById(id);
    }
    public User findOneBYId(Long id) {
        return userRepository.findById(id).orElse(null);
    }
    public List<User> findAllUser() {
        return userRepository.findAll();
    }
    public User assignProjectToUser(Long id,Long projectid)
    {
        Set<Project> projectSet=null;
        User user = userRepository.findById(id).get();
        Project project= projectRepository.findById(projectid).get();
        projectSet=user.getProjects();
        projectSet.add(project);
        user.setProjects(projectSet);
        return userRepository.save(user);

    }

        public User findByEmail(String email) {
            return userRepository.findByEmail(email);
        }





}
