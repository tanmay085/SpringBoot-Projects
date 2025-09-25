package com.app.student_management.controller;

import com.app.student_management.dto.DepartmentDto;
import com.app.student_management.dto.ProfileDto;
import com.app.student_management.dto.StudentDto;
import com.app.student_management.entity.Department;
import com.app.student_management.entity.Student;
import com.app.student_management.service.DepartmentService;
import com.app.student_management.service.ProfileService;
import com.app.student_management.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.servlet.function.ServerResponse.ok;

@RestController

public class AdminController {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private ProfileService profileService;

    @Autowired
    private StudentService studentService;

    @PostMapping("department")
    public ResponseEntity<DepartmentDto> createDepartment(@Valid @RequestBody DepartmentDto departmentDto) {
        return ResponseEntity.ok(departmentService.createDepartment(departmentDto));
    }

    @PostMapping("student/{id}")
    public ResponseEntity<StudentDto> createStudent(@Valid@RequestBody StudentDto studentDto,@PathVariable Long id){
        return ResponseEntity.ok(studentService.createStudent(studentDto,id));
    }

    @PostMapping("profile/{id}")
    public ResponseEntity<ProfileDto> createProfile(@Valid@RequestBody ProfileDto profileDto, @PathVariable Long id){
        return ResponseEntity.ok(profileService.createProfile(profileDto, id));
    }

    @DeleteMapping("deleteDepartment/{id}")
    public ResponseEntity<Department> deleteDepartment(@PathVariable Long id){
        return ResponseEntity.ok(departmentService.deleteDepartment(id));
    }

    @DeleteMapping("deleteStudent/{id}")
    public ResponseEntity<Student>deleteStudent(@PathVariable Long id){
        return ResponseEntity.ok(studentService.deleteStudent(id));
    }
}
