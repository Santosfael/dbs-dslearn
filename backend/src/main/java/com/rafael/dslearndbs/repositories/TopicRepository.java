package com.rafael.dslearndbs.repositories;

import com.rafael.dslearndbs.entities.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, Long> {
}
