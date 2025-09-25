package com.app.student_management.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String sClass;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private Profile profile;

    @ManyToOne
    @JoinColumn(name = "Department_id")
    @JsonBackReference
    private Department department;
}
