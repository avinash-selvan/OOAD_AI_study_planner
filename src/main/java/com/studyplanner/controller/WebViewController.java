package com.studyplanner.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebViewController {

    @GetMapping("/")
    public String index() {
        return "index"; // loads index.html
    }

    @GetMapping("/tasks")
    public String tasks() {
        return "tasks"; // loads tasks.html
    }

    @GetMapping("/ai-scheduler")
    public String aiScheduler() {
        return "ai-scheduler"; // loads ai-scheduler.html
    }
}
