package com.studyplanner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.studyplanner.model.StudyTask;

@Repository
public interface StudyTaskRepository extends JpaRepository<StudyTask, Long> {   
}
