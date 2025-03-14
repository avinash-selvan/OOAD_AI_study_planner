package com.studyplanner.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class StudyTaskController {

    @GetMapping("/hello")
    public String hello() {
        return "Spring Boot is working!";
    }
}
