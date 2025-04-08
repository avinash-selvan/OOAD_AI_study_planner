package com.studyplanner.ai;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.studyplanner.strategy.StudyPlanStrategy;

import org.springframework.http.*;
import java.util.*;

@Service
public class pythonAIAdapter implements AIPlanner {

    private StudyPlanStrategy strategy;
    private static final String AI_URL = "http://localhost:5005/plan"; // Python Flask app URL

    public pythonAIAdapter(StudyPlanStrategy strategy) {
        this.strategy = strategy;
    }
    

    @Override
    public Map<String, Double> generateStudyPlan(List<String> topics, double timeAvailable) {
        RestTemplate restTemplate = new RestTemplate();

        Map<String, Object> payload = new HashMap<>();
        payload.put("topics", topics);
        payload.put("timeAvailable", timeAvailable);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(payload, headers);

        ResponseEntity<Map> response = restTemplate.postForEntity(AI_URL, request, Map.class);

        // Raw plan from AI
        Map<String, Double> aiPlan = response.getBody();

        // Apply strategy on the AI plan (for example, re-balancing)
        return strategy.distributeTime(topics, aiPlan, timeAvailable);
}
}
