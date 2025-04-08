package com.studyplanner.singleton;

public class UserProfileManager {

    private static UserProfileManager instance;

    private String defaultStrategy = "equal";
    private double defaultTimePerDay = 2.0;

    private UserProfileManager() {}

    public static synchronized UserProfileManager getInstance() {
        if (instance == null) {
            instance = new UserProfileManager();
        }
        return instance;
    }

    public String getDefaultStrategy() {
        return defaultStrategy;
    }

    public void setDefaultStrategy(String strategy) {
        this.defaultStrategy = strategy;
    }

    public double getDefaultTimePerDay() {
        return defaultTimePerDay;
    }
}
