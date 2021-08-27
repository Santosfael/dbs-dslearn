package com.rafael.dslearndbs.repositories;

import com.rafael.dslearndbs.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
