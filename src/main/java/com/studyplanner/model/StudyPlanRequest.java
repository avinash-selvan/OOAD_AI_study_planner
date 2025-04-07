package com.studyplanner.model;

import java.util.List;

public class StudyPlanRequest {
    private List<String> topics;
    private int timeAvailable;

    // Getters and setters
    public List<String> getTopics() {
        return topics;
    }

    public void setTopics(List<String> topics) {
        this.topics = topics;
    }

    public int getTimeAvailable() {
        return timeAvailable;
    }

    public void setTimeAvailable(int timeAvailable) {
        this.timeAvailable = timeAvailable;
    }
}

