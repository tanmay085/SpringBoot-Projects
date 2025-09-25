package com.app.student_management.controller;

import com.app.student_management.dto.StudentDto;
import com.app.student_management.entity.Profile;
import com.app.student_management.entity.Student;
import com.app.student_management.service.ProfileService;
import com.app.student_management.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class User {
    @Autowired
    private StudentService studentService;

    @Autowired
    private ProfileService profileService;

    @GetMapping("getStudent/{depId}")
    public List<Student> studentGetByDepartment(@PathVariable Long depId){
        return studentService.studentGetByDepartment(depId);
    }

    @GetMapping("getProfile/{id}")
    public ResponseEntity<Profile> profileGetByStudent(@PathVariable Long id){
        return ResponseEntity.ok(profileService.profileGetByStudent(id));
    }
}
