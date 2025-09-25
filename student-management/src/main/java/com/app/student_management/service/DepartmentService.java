package com.app.student_management.service;

import com.app.student_management.dto.DepartmentDto;
import com.app.student_management.entity.Department;
import com.app.student_management.exception.DepartmentExist;
import com.app.student_management.exception.DepartmentNotFound;
import com.app.student_management.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public DepartmentDto createDepartment(DepartmentDto departmentDto){
        if (departmentRepository.existsByDepName(departmentDto.getDptName())){
            throw new DepartmentExist("Department Already Exist by"+departmentDto.getDptName());
        }
        Department department=new Department();
        department.setDepName(departmentDto.getDptName());
        department.setTime(departmentDto.getTime());
        departmentRepository.save(department);
        return departmentDto;
    }

    public Department deleteDepartment(Long id){
        Department department= departmentRepository.findById(id)
                .orElseThrow(()-> new DepartmentNotFound("Department not with id:"+id));
        departmentRepository.delete(department);
        return department;
    }
}
