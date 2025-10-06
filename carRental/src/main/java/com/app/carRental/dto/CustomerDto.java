package com.app.carRental.dto;

import com.app.carRental.entity.Booking;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data @AllArgsConstructor @NoArgsConstructor
public class CustomerDto {
    @NotBlank(message = "name can't be blank")
    private  String name;
    @NotBlank(message = "email can't be blank")
    @Email(message = "email format is wrong")
    private String email;
    @NotBlank(message = "phone number can't be blank")
    private String phone;

    private List<Booking> bookings=new ArrayList<>();
}
