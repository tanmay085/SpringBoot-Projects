package com.app.student_management.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;
    private String email;
    private Long phone;

    @OneToOne
    @JoinColumn(name = "Student_id")
    @JsonBackReference
    private Student student;
}
