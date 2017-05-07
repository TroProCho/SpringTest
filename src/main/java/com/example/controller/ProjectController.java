package com.example.controller;


import com.example.model.Project;
import com.example.repository.ProjectRepository;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;

    @Autowired
    public ProjectController(ProjectRepository projectRepository, UserRepository userRepository) {
        this.projectRepository = projectRepository;
        this.userRepository = userRepository;
    }

    @GetMapping
    public Collection<Project> getProjects(@PathVariable Long userId) {
        return projectRepository.findByUserId(userId);
    }

    @PostMapping
    public void addProject(@RequestBody Project project, @PathVariable Long userId) {
        //TODO getUserName from context
        String username = null;
        project.setUser(userRepository.findByUsername(username));
        projectRepository.save(project);
    }

    @PutMapping("/{id}")
    public void updateProject(@PathVariable Long id, @RequestBody Project project) {
        //TODO create PUT
    }

    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable Long id) {
        //TODO
        String username = null;
        projectRepository.findByUserUsername(username).forEach(project -> {
            if (project.getId().equals(id)) {
                projectRepository.delete(id);
            }
        });
    }
}
