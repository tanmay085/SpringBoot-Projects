package com.app.carRental.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@Table(name = "Bookings",
indexes = {@Index(name = "idx_Booking_car_dates",columnList = "car_id, start_date, end_date")})

public class Booking {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @Column(name = "Start_date", nullable = false)
    private LocalDateTime startTime;
    @Column(name = "End_date", nullable = false)
    private LocalDateTime endTime;
    @Enumerated(EnumType.STRING)
    private BookingStatus status;
    private BigDecimal totalPrice;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;



}
