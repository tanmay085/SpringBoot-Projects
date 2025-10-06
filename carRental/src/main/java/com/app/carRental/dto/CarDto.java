package com.app.carRental.dto;

import com.app.carRental.entity.Booking;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
@Data @NoArgsConstructor @AllArgsConstructor
public class CarDto {
    private String registerNumber;
    private Integer year;
    @NotNull(message = "rental price per day can't be empty")
    private BigDecimal dailyPrice;


    private List<Booking> bookings=new ArrayList<>();
}
