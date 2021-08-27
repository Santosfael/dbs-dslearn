package com.rafael.dslearndbs.repositories;

import com.rafael.dslearndbs.entities.Enrollment;
import com.rafael.dslearndbs.entities.pk.EnrollmentPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<Enrollment, EnrollmentPK> {
}
