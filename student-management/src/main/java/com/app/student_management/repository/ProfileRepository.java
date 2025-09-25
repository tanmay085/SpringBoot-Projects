package com.app.student_management.repository;

import com.app.student_management.entity.Profile;
import com.app.student_management.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
    Profile findByStudent(Student student);
}
