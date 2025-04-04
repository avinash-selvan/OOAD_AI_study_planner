package com.studyplanner.model;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "study_tasks")
public class StudyTask {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private boolean completed;
    private LocalDate dueDate;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public LocalDate getDueDate() { // ✅ Add this if missing
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) { // ✅ Add this if missing
        this.dueDate = dueDate;
    }
}
