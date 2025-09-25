package com.app.employee_department.dto;

import com.app.employee_department.model.Employee;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public class DepartmentDto {

    private Long dId;

    @NotBlank(message = "department name can not be blank")
    private String dName;
    private List<Employee> employeeList;

    public Long getdId(){
        return dId;
    }
    public String getdName(){
        return dName;
    }
    public List<Employee> getEmployeeList(){
        return employeeList;
    }



    public void setdName(String dName){
        this.dName=dName;
    }

    public void setEmployeeList(List<Employee> employeeList){
        this.employeeList=employeeList;
    }


}
