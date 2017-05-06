package com.example.project;


import com.example.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users/{userId}/projects")
public class ProjectController {

    @Autowired
    private ProjectRepository projectRepository;

    @GetMapping
    public List<Project> getAllProjects(@PathVariable Long userId) {
        return projectRepository.findByUserId(userId);
    }

    @PostMapping
    public void addProject(@RequestBody Project project, @PathVariable Long userId) {
        User user = new User();
        user.setId(userId);
        project.setUser(user);
        projectRepository.save(project);
    }

    @PutMapping("/{id}")
    public void updateProject(@PathVariable Long id, @RequestBody Project project) {

    }

    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable Long id) {

    }
}
