package com.rafael.dslearndbs.repositories;

import com.rafael.dslearndbs.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
