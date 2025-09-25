package com.app.student_management.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {
    @NotBlank(message = "Department name cannot be blank")
    private String dptName;
    @NotBlank(message = "time cannot be blank")
    private String time;
}
