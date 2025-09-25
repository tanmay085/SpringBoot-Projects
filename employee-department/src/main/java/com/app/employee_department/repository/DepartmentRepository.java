package com.app.employee_department.repository;

import com.app.employee_department.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {


    Optional<Department> findByDName(String dName);
}
