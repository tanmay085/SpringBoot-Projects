package com.project.hospital.management.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private LocalDate birthdate;

    private String gender;

    private String email;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @OneToMany(mappedBy ="patient",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Appointment>appointments=new ArrayList<>();

    @OneToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "Patient_insurance_id")
    private Insurance insurance;



}
