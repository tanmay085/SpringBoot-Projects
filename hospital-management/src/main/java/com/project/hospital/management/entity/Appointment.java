package com.project.hospital.management.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    private LocalDateTime AppointmentTime;

    private String reason;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JsonBackReference("doctor-appointments")
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
}
