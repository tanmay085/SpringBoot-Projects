package com.app.employee_department.service;


import com.app.employee_department.dto.DepartmentDto;
import com.app.employee_department.exception.DepartmentAlreadyExist;
import com.app.employee_department.exception.DepartmentNotFound;
import com.app.employee_department.model.Department;
import com.app.employee_department.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public DepartmentDto createDepartment(DepartmentDto departmentDto){
        Department department= new Department();
        Optional<Department> existingDepartment=departmentRepository.findByDName(departmentDto.getdName());
        if(existingDepartment.isPresent()){
            throw new DepartmentAlreadyExist("department already exist");
        }
        department.setdName(departmentDto.getdName());
        this.departmentRepository.save(department);
        return departmentDto;
    }

    public DepartmentDto getDepartment(Long id){
        DepartmentDto  departmentDto=new DepartmentDto();
        Department department=departmentRepository.findById(id).
                orElseThrow(()-> new DepartmentNotFound("Department Not  Found By Id:"+id));
        departmentDto.setdName(department.getdName());
        return departmentDto;
    }

    public DepartmentDto updateDepartment(Long id, DepartmentDto departmentDto){
        Department department=new Department();
        department=departmentRepository.findById(id).
                orElseThrow(()-> new DepartmentNotFound("Department Not  Found By Id:"+id));
        department.setdName(departmentDto.getdName());
        departmentRepository.save(department);
        return departmentDto;

    }

    public Department deleteDepartment(Long id){
        Department department=departmentRepository.findById(id).
                orElseThrow(()-> new DepartmentNotFound("Department Not  Found By Id:"+id));
        departmentRepository.delete(department);
        return department;
    }
}
