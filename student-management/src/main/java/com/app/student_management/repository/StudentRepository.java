package com.app.student_management.repository;

import com.app.student_management.entity.Department;
import com.app.student_management.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByDepartment(Department department);
}
