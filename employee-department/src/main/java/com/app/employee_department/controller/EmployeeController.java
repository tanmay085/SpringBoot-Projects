package com.app.employee_department.controller;

import com.app.employee_department.dto.DepartmentDto;
import com.app.employee_department.dto.EmployeeDto;
import com.app.employee_department.model.Employee;
import com.app.employee_department.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/{id}/employee")
    public EmployeeDto createEmployee(@Valid @PathVariable Long id, @RequestBody EmployeeDto employeeDto){
        return this.employeeService.createEmployee(employeeDto,id);
    }

    @GetMapping("/{id}/employee")
    public EmployeeDto getEmployee(@PathVariable Long id){
        return this.employeeService.getEmployee(id);
    }

    @PutMapping("/{id}/employee")
    public EmployeeDto updateEmployee(@Valid@PathVariable Long id, @RequestBody EmployeeDto employeeDto){
        return this.employeeService.updateEmployee(id, employeeDto);
    }

    @DeleteMapping("/{id}/employee")
    public Employee deleteEmployee(@PathVariable Long id){
        return this.employeeService.deleteEmployee(id);
    }
}
