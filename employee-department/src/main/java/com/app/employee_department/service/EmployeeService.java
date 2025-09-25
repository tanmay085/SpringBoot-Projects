package com.app.employee_department.service;

import com.app.employee_department.dto.DepartmentDto;
import com.app.employee_department.dto.EmployeeDto;
import com.app.employee_department.exception.DepartmentNotFound;
import com.app.employee_department.exception.EmployeeNotFound;
import com.app.employee_department.model.Department;
import com.app.employee_department.model.Employee;
import com.app.employee_department.repository.DepartmentRepository;
import com.app.employee_department.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    public EmployeeDto createEmployee(EmployeeDto employeeDto, Long id){
        Employee employee=new Employee();
        employee.seteName(employeeDto.geteName());
        employee.setAge(employeeDto.getAge());
        employee.setSalary(employeeDto.getSalary());
        Department department=departmentRepository.findById(id).
                orElseThrow(()-> new DepartmentNotFound("Department Not  Found By Id:"+id));
        employee.setDepartment(department);
        employeeRepository.save(employee);
        return employeeDto;
    }

    public EmployeeDto getEmployee(Long id){
        EmployeeDto employeeDto = new EmployeeDto();
        Employee employee=employeeRepository.findById(id).
                orElseThrow(()->new EmployeeNotFound("Employee Not Found By id:"+id));
        employeeDto.seteName(employee.geteName());
        employeeDto.setAge(employee.getAge());
        employeeDto.setSalary(employee.getSalary());
        employeeDto.setDepartment(employee.getDepartment());
        return employeeDto;
    }

    public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto){
        Employee employee=employeeRepository.findById(id).
                orElseThrow(()->new EmployeeNotFound("Employee Not Found By id:"+id));
        employee.seteName(employeeDto.geteName());
        employee.setSalary(employeeDto.getSalary());
        employee.setAge(employeeDto.getAge());
        employeeRepository.save(employee);
        return employeeDto;
    }

    public Employee deleteEmployee(Long id){
        Employee employee=employeeRepository.findById(id).
                orElseThrow(()->new EmployeeNotFound("Employee Not Found By id:"+id));
        employeeRepository.delete(employee);
        return employee;
    }

}
