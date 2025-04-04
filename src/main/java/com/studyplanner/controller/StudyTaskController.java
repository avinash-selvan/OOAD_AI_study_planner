package com.studyplanner.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.studyplanner.model.StudyTask;
import com.studyplanner.repository.StudyTaskRepository;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class StudyTaskController {

    @Autowired
    private StudyTaskRepository studyTaskRepository;

    @GetMapping
    public List<StudyTask> getAllTasks() {
        return studyTaskRepository.findAll();
    }

    @PostMapping
    public StudyTask createTask(@RequestBody StudyTask task) {
        return studyTaskRepository.save(task);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTask(@PathVariable Long id, @RequestBody StudyTask updatedTask) {
            return studyTaskRepository.findById(id)
                .map(task -> {
                    task.setTitle(updatedTask.getTitle());
                    task.setDescription(updatedTask.getDescription());
                    task.setDueDate(updatedTask.getDueDate());
                    studyTaskRepository.save(task);
                    return ResponseEntity.ok(task);
                })
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }


    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        studyTaskRepository.deleteById(id);
    }
}

