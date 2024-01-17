package com.example.GDP.Controleurs;

import com.example.GDP.Entites.Task;
import com.example.GDP.Entites.User;
import com.example.GDP.services.ProjectService;
import com.example.GDP.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
@CrossOrigin
@Controller
@RestController
@RequestMapping("/User")
public class UserControleurs {
    @Autowired
    private UserService userService;

    @PostMapping("/AddUser")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user); // Use the service method here
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.findOneBYId(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        User user = userService.findOneBYId(id);
        if (user != null) {
            userService.DeleteUser(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<User> UpdateUser(@PathVariable Long id, @RequestBody User user) {
        User existingUser = userService.findOneBYId(id);
        if (existingUser != null) {
            user.setId(id);
            User updateduser = userService.updateUser(id, user);
            return ResponseEntity.ok(updateduser);
        } else {
            return ResponseEntity.notFound().build();

        }
    }
    @PutMapping("/{id}/project/{projectid}")
    public User assignProjectToUser(@PathVariable Long id,@PathVariable Long projectid)
    {
        return userService.assignProjectToUser(id,projectid);
    }
    @GetMapping("/GetUsers")
    public ResponseEntity<List<User>> getAllUser() {
        List<User>Users= userService.findAllUser();
        return ResponseEntity.ok(Users);
    }
    @GetMapping("/login")
    public boolean login(@RequestParam String email,@RequestParam String mdp) {
        return  userService.isUserPresent(email,mdp);
    }

}
