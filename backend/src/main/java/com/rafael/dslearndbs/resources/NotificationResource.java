package com.rafael.dslearndbs.resources;

import com.rafael.dslearndbs.dto.NotificationDTO;
import com.rafael.dslearndbs.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/notifications")
public class NotificationResource {

    @Autowired
    private NotificationService notificationService;

    @GetMapping
    public ResponseEntity<Page<NotificationDTO>> findAll(
            @RequestParam(value = "", defaultValue = "false") Boolean unreadOnly,
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "12") Integer size
    ) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<NotificationDTO> notificationDTOPage = notificationService.notificationForCurrentUser(unreadOnly, pageRequest);

        return ResponseEntity.ok().body(notificationDTOPage);
    }
}