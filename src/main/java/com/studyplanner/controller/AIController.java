package com.studyplanner.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import com.studyplanner.ai.pythonAIAdapter; // change if your adapter package is different
import com.studyplanner.model.StudyPlanRequest; // path to where you put StudyPlanRequest.java

@RestController
@RequestMapping("/api/ai")
public class AIController {

    private final pythonAIAdapter aiAdapter = new pythonAIAdapter();

    @PostMapping("/generate-plan")
    public ResponseEntity<?> getStudyPlan(@RequestBody StudyPlanRequest request) {
        try {
            Map<String, Double> plan = aiAdapter.generateStudyPlan(request.getTopics(), request.getTimeAvailable());
            return ResponseEntity.ok(plan);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("AI Planner failed: " + e.getMessage());
        }
    }
}

