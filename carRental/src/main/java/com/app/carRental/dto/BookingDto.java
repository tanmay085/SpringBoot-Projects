package com.app.carRental.dto;

import com.app.carRental.entity.BookingStatus;
import com.app.carRental.entity.Car;
import com.app.carRental.entity.Customer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Fallback;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data @NoArgsConstructor @AllArgsConstructor
public class BookingDto {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
//    @Enumerated(EnumType.STRING)
//    private BookingStatus status;
//    private BigDecimal totalPrice;
//
//    private Car car;
//
//    private Customer customer;
}
