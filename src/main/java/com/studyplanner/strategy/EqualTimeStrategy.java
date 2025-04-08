package com.studyplanner.strategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EqualTimeStrategy implements StudyPlanStrategy {

    @Override
    public Map<String, Double> distributeTime(List<String> topics, Map<String, Double> aiPlan, double timeAvailable) {
        Map<String, Double> result = new HashMap<>();
        double perTopicTime = timeAvailable / topics.size();

        for (String topic : topics) {
            result.put(topic, perTopicTime);
        }

        return result;
    }

    @Override
    public Map<String, Double> generatePlan(List<String> topics, int timeAvailable) {
        return null; // Optional: You can leave this empty if you're using only the distributeTime() method
    }
}
