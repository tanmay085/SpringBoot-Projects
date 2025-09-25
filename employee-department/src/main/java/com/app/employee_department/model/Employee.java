package com.app.employee_department.model;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
public class Employee {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long eId;

    private String eName;

    private Long salary;

    private Integer age;

    @ManyToOne
    @JoinColumn(name="departmentId")
    private Department department;

    public Long geteId() {
        return eId;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Department getDepartment(){
        return department;
    }
    public void setDepartment(Department department){
        this.department=department;
    }

}
