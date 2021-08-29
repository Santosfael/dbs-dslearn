package com.rafael.dslearndbs.services;

import com.rafael.dslearndbs.dto.NotificationDTO;
import com.rafael.dslearndbs.entities.Deliver;
import com.rafael.dslearndbs.entities.Notification;
import com.rafael.dslearndbs.entities.User;
import com.rafael.dslearndbs.observers.DeliverRevisionObserver;
import com.rafael.dslearndbs.repositories.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.time.Instant;

@Service
public class NotificationService implements DeliverRevisionObserver {

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private AuthService authService;

    @Autowired
    private DeliverService deliverService;

    @PostConstruct
    private void initialize() {
        deliverService.subscribeDeliverRevisionObserver(this);
    }

    @Transactional(readOnly = true)
    public Page<NotificationDTO> notificationForCurrentUser(boolean unreadOnly, Pageable pageable) {
        User user = authService.authenticated();
        Page<Notification> page = notificationRepository.find(user, unreadOnly, pageable);
        return page.map(NotificationDTO::new);
    }

    @Transactional
    public void saveDeliverNotification(Deliver deliver) {
        Long sectionId = deliver.getLesson().getSection().getId();
        Long resourceId = deliver.getLesson().getSection().getResource().getId();
        Long offerId = deliver.getLesson().getSection().getResource().getOffer().getId();

        String route = "/offers/" + offerId + "/resources/" + resourceId + "/sections/" + sectionId;
        String text = deliver.getFeedback();
        Instant moment = Instant.now();
        User user = deliver.getEnrollment().getStudent();

        Notification notification = new Notification(null, text, moment, false, route, user);
        notificationRepository.save(notification);
    }

    @Override
    public void onSaveRevision(Deliver deliver) {
        saveDeliverNotification(deliver);
    }
}
