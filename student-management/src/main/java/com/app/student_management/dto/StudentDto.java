package com.app.student_management.dto;

import com.app.student_management.entity.Department;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDto {
    @NotBlank(message = "name can not be blank")
    private String name;
    @NotBlank(message = "Class can not be blank")
    private String sClass;
    private Department department;
}
