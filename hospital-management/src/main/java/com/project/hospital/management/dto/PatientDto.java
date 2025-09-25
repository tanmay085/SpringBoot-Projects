package com.project.hospital.management.dto;

import com.project.hospital.management.entity.Insurance;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Getter
@Setter
public class PatientDto {
    private String name;

    private LocalDate birthDate;

    private String email;

    private String gender;



}
