package com.app.employee_department.dto;

import com.app.employee_department.model.Department;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class EmployeeDto {
    private Long eId;
    @NotBlank(message = "Employee name can not be blank")
    private String eName;
    @NotNull(message = "Employee salary can not be null")
    private Long salary;
    @NotNull(message = "Employee age can not be null")
    private Integer age;

    private Department department;

    public Long geteId() {
        return eId;
    }

    public void seteId(Long eId) {
        this.eId = eId;
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
