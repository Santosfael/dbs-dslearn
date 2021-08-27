package com.rafael.dslearndbs.repositories;

import com.rafael.dslearndbs.entities.Section;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SectionRepository extends JpaRepository<Section, Long> {
}
