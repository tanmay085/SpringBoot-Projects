package com.app.student_management.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfileDto {
    @NotBlank(message = "Address can not be blank")
    private String address;
    @NotNull(message = "Phone number can not be blank")
    private Long phone;
    @NotBlank(message = "Email can not be blank")
    private String email;
}
