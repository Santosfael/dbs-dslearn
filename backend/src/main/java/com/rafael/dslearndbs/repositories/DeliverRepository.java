package com.rafael.dslearndbs.repositories;

import com.rafael.dslearndbs.entities.Deliver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliverRepository extends JpaRepository<Deliver, Long> {
    
}
