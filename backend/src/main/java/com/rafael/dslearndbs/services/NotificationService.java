package com.rafael.dslearndbs.services;

import com.rafael.dslearndbs.dto.NotificationDTO;
import com.rafael.dslearndbs.entities.Notification;
import com.rafael.dslearndbs.entities.User;
import com.rafael.dslearndbs.repositories.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private AuthService authService;

    public Page<NotificationDTO> notificationForCurrentUser(boolean unreadOnly, Pageable pageable) {
        User user = authService.authenticated();
        Page<Notification> page = notificationRepository.find(user, unreadOnly, pageable);
        return page.map(NotificationDTO::new);
    }
}
