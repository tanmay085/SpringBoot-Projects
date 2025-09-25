package com.app.employee_department.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Department {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long dId;
    private String dName;

    @OneToMany(mappedBy = "department",cascade = CascadeType.ALL)
    private List<Employee> employeeList=new ArrayList<>();

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
