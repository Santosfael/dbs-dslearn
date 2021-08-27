package com.rafael.dslearndbs.repositories;

import com.rafael.dslearndbs.entities.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
}
