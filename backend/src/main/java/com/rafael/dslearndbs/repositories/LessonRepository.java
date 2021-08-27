package com.rafael.dslearndbs.repositories;

import com.rafael.dslearndbs.entities.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
}
