package com.project.hospital.management.repository;

import com.project.hospital.management.entity.Insurance;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsuranceRepository extends JpaRepository<Insurance, Long> {
}
