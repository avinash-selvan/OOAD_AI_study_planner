package com.studyplanner.ai;

import java.util.List;
import java.util.Map;

public interface AIPlanner {
    Map<String, Double> generateStudyPlan(List<String> topics, double timeAvailable, String strategyName);
}
