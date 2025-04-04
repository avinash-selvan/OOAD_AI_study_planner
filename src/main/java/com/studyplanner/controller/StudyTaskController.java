package com.studyplanner.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.studyplanner.model.StudyTask;
import com.studyplanner.repository.StudyTaskRepository;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class StudyTaskController {

    @Autowired
    private StudyTaskRepository taskRepository;

    @GetMapping
    public List<StudyTask> getAllTasks() {
        return taskRepository.findAll();
    }

    @PostMapping
    public StudyTask createTask(@RequestBody StudyTask task) {
        return taskRepository.save(task);
    }

    @PutMapping("/{id}")
    public StudyTask updateTask(@PathVariable Long id, @RequestBody StudyTask taskDetails) {
        StudyTask task = taskRepository.findById(id).orElseThrow();
        task.setTitle(taskDetails.getTitle());
        task.setDescription(taskDetails.getDescription());
        task.setCompleted(taskDetails.isCompleted());
        return taskRepository.save(task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskRepository.deleteById(id);
    }
}

