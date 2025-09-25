package com.app.student_management.repository;

import com.app.student_management.entity.Department;
import com.app.student_management.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    boolean existsByDepName(String depName);
}
