package com.project.hospital.management.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AppointmentDto {

    private LocalDateTime dateTime;
    private String reason;
}
