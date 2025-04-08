package com.studyplanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.studyplanner.singleton.UserProfileManager;

import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class StudyPlannerApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(StudyPlannerApplication.class, args);
	}

	 @Override
    public void run(String... args) throws Exception {
        // 🔥 Singleton Pattern Test Code
        UserProfileManager manager1 = UserProfileManager.getInstance();
        UserProfileManager manager2 = UserProfileManager.getInstance();

        manager1.setDefaultStrategy("priority");

        System.out.println("Manager 1 Strategy: " + manager1.getDefaultStrategy());
        System.out.println("Manager 2 Strategy: " + manager2.getDefaultStrategy());
    }

}
