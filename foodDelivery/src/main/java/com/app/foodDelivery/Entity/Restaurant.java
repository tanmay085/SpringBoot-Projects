package com.app.foodDelivery.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long restaurantId;

    private String name;

    private String address;

    private String phone;

    @OneToMany(mappedBy = "restaurant",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<MenuItem> menuItems=new ArrayList<>();
}
