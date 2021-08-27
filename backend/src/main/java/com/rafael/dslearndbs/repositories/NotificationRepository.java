package com.rafael.dslearndbs.repositories;

import com.rafael.dslearndbs.entities.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
