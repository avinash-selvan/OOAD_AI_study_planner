package com.studyplanner.strategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EqualTimeStrategy implements StudyPlanStrategy {

    @Override
    public Map<String, Double> generatePlan(List<String> topics, int timeAvailable) {
        Map<String, Double> plan = new HashMap<>();
        double timePerTopic = (double) timeAvailable / topics.size();

        for (String topic : topics) {
            plan.put(topic, timePerTopic);
        }

        return plan;
    }
}
