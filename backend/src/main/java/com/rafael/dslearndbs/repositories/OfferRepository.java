package com.rafael.dslearndbs.repositories;

import com.rafael.dslearndbs.entities.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferRepository extends JpaRepository<Offer, Long> {
}
