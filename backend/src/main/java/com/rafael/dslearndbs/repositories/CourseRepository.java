package com.rafael.dslearndbs.repositories;

import com.rafael.dslearndbs.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
