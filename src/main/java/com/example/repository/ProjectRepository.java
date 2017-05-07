package com.example.repository;

import com.example.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    //TODO Or it's make easily to code findByUserUsername?
    List<Project> findByUserUsername(String username);
    List<Project> findByUserId(Long userId);

}
