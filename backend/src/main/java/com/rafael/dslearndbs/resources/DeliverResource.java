package com.rafael.dslearndbs.resources;

import com.rafael.dslearndbs.dto.DeliverRevisionDTO;
import com.rafael.dslearndbs.services.DeliverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/deliveries")
public class DeliverResource {

    @Autowired
    private DeliverService deliverService;

    @PreAuthorize(value = "hasAnyRole('ADMIN', 'INSTRUCTOR')")
    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> saveRevision(@PathVariable Long id, @RequestBody DeliverRevisionDTO deliverRevisionDTO) {
        deliverService.saveRevision(id, deliverRevisionDTO);
        return ResponseEntity.noContent().build();
    }
}
