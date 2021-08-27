package com.rafael.dslearndbs.repositories;

import com.rafael.dslearndbs.entities.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceRepository extends JpaRepository<Resource, Long> {
}
