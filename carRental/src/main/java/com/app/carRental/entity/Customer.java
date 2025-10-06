package com.app.carRental.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "customers")
public class Customer {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private  Long id;
    @NotBlank(message = "name can't be blank")
    private  String name;
    @NotBlank(message = "email can't be blank")
    @Email(message = "email format is wrong")
    private String email;
    @NotBlank(message = "phone number can't be blank")
    private String phone;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    private List<Booking> bookings=new ArrayList<>();
}
