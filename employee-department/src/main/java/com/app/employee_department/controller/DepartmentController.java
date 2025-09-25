package com.app.employee_department.controller;

import com.app.employee_department.dto.DepartmentDto;
import com.app.employee_department.model.Department;
import com.app.employee_department.service.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/test")
    public String returnString(){
        return "hello SpringBoot";
    }


    @PostMapping("/department")
    public ResponseEntity<DepartmentDto> createDepartment (@Valid @RequestBody DepartmentDto departmentDto){
        return ResponseEntity.ok(departmentService.createDepartment(departmentDto));
    }

    @GetMapping("/{id}/department")
    public DepartmentDto getDepartment (@PathVariable Long id){
        return this.departmentService.getDepartment( id);
    }

    @PutMapping("/{id}/department")
    public DepartmentDto updateDepartment(@Valid@PathVariable Long id, @RequestBody DepartmentDto departmentDto){
        return this.departmentService.updateDepartment(id, departmentDto);
    }

    @DeleteMapping("/{id}/department")
    public Department deleteDepartment(@PathVariable Long id){
        return this.departmentService.deleteDepartment(id);
    }


}
