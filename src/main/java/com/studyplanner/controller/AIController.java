package com.studyplanner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.List;
import java.util.HashMap;

import com.studyplanner.ai.pythonAIAdapter; // change if your adapter package is different
import com.studyplanner.model.StudyPlanRequest; // path to where you put StudyPlanRequest.java
// import com.studyplanner.strategy.StudyPlanStrategy;
import com.studyplanner.strategy.PostAIStrategy;
import com.studyplanner.strategy.EqualTimeStrategy;

// @RestController
// @RequestMapping("/api/ai")
// public class AIController {

//     private final Map<String, PostAIStrategy> strategyMap;

//     @Autowired
//     public AIController(List<PostAIStrategy> strategies) {
//         this.strategyMap = new HashMap<>();
//         for (PostAIStrategy strategy : strategies) {
//             strategyMap.put(strategy.getClass().getSimpleName().toLowerCase(), strategy);
//         }
//     }

//     @Autowired
//     private pythonAIAdapter aiAdapter;

//     @PostMapping("/generate-plan")
//     public ResponseEntity<?> getStudyPlan(@RequestBody StudyPlanRequest request) {
//         try {
//             String strategyKey = request.getStrategy().toLowerCase(); // e.g. "equaltimestrategy"
//             PostAIStrategy selectedStrategy = strategyMap.getOrDefault(strategyKey, new EqualTimeStrategy());

//             aiAdapter.setStrategy(selectedStrategy); // You’ll need to add a setter

//             Map<String, Double> plan = aiAdapter.generateStudyPlan(
//                 request.getTopics(), request.getTimeAvailable(), strategyKey
//             );

//             return ResponseEntity.ok(plan);
//         } catch (Exception e) {
//             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                     .body("AI Planner failed: " + e.getMessage());
//         }
//     }
// }

@RestController
@RequestMapping("/api/ai")
public class AIController {

    private final Map<String, PostAIStrategy> strategyMap;

    @Autowired
    public AIController(List<PostAIStrategy> strategies) {
        this.strategyMap = new HashMap<>();
        for (PostAIStrategy strategy : strategies) {
            strategyMap.put(strategy.getClass().getSimpleName().toLowerCase(), strategy);
        }
    }

    @Autowired
    private pythonAIAdapter aiAdapter;

    @PostMapping("/generate-plan")
    public ResponseEntity<?> getStudyPlan(@RequestBody StudyPlanRequest request) {
        try {
            String strategyKey = request.getStrategy().toLowerCase(); // e.g. "equaltimestrategy"
            PostAIStrategy selectedStrategy = strategyMap.getOrDefault(strategyKey, new EqualTimeStrategy());

            aiAdapter.setStrategy(selectedStrategy); // You’ll need to add a setter

            Map<String, Double> plan = aiAdapter.generateStudyPlan(
                request.getTopics(), request.getTimeAvailable(), strategyKey
            );

            return ResponseEntity.ok(plan);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("AI Planner failed: " + e.getMessage());
        }
    }
}



