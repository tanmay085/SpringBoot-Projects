package com.app.student_management.service;

import com.app.student_management.dto.StudentDto;
import com.app.student_management.entity.Department;
import com.app.student_management.entity.Student;
import com.app.student_management.exception.DepartmentNotFound;
import com.app.student_management.exception.StudentNotFound;
import com.app.student_management.repository.DepartmentRepository;
import com.app.student_management.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

    public StudentDto createStudent ( StudentDto studentDto,Long id){
        Student student=new Student();
        if(departmentRepository.findById(id).isPresent()){
            Department department= departmentRepository.findById(id).get();
            student.setDepartment(department);
            student.setName(studentDto.getName());
            student.setSClass(studentDto.getSClass());
            studentRepository.save(student);
            return studentDto;
        }else{
            throw new DepartmentNotFound("department not found with id :"+id);
        }

    }

    public Student deleteStudent(Long id){
        Student student= studentRepository.findById(id)
                .orElseThrow(()->new StudentNotFound("student not found with id:"+id));
        studentRepository.delete(student);
        return student;
    }

    public List<Student> studentGetByDepartment(Long depId){
        Department department=departmentRepository.findById(depId)
                .orElseThrow(()-> new DepartmentNotFound("department not found by id:"+depId));
        return studentRepository.findByDepartment(department);
    }
}
