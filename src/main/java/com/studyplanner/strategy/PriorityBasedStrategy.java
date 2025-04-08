package com.studyplanner.strategy;

import java.util.*;

import org.springframework.stereotype.Component;


@Component
public class PriorityBasedStrategy implements PostAIStrategy {

    @Override
    public Map<String, Double> distributeTime(List<String> topics, Map<String, Double> aiPlan, double timeAvailable) {
        // Prioritize topics with higher AI scores
        Map<String, Double> sorted = new LinkedHashMap<>();
        topics.sort((t1, t2) -> Double.compare(aiPlan.getOrDefault(t2, 0.0), aiPlan.getOrDefault(t1, 0.0)));

        double total = topics.stream()
            .mapToDouble(topic -> aiPlan.getOrDefault(topic, 0.0))
            .sum();

        for (String topic : topics) {
            double ratio = aiPlan.getOrDefault(topic, 0.0) / total;
            sorted.put(topic, ratio * timeAvailable);
        }

        return sorted;
    }
}
