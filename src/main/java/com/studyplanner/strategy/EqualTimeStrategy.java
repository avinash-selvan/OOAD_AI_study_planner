package com.studyplanner.strategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class EqualTimeStrategy implements PostAIStrategy {

    @Override
    public Map<String, Double> distributeTime(List<String> topics, Map<String, Double> aiPlan, double timeAvailable) {
        Map<String, Double> result = new HashMap<>();
        double perTopicTime = timeAvailable / topics.size();

        for (String topic : topics) {
            result.put(topic, perTopicTime);
        }

        return result;
    }
}
