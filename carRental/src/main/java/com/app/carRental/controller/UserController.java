package com.app.carRental.controller;

import com.app.carRental.dto.BookingDto;
import com.app.carRental.dto.CustomerDto;
import com.app.carRental.entity.Booking;
import com.app.carRental.entity.BookingStatus;
import com.app.carRental.entity.Car;
import com.app.carRental.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private CustomerService customerService;


    @PostMapping("/customer")
    public ResponseEntity<CustomerDto> createCustomer(@Valid @RequestBody CustomerDto customerDto){
        return ResponseEntity.ok(customerService.createCustomer(customerDto));

    }

    @PostMapping("/{custId}/{carId}/booking")
    public ResponseEntity<Void> createBooking(@PathVariable Long custId, @PathVariable Long carId, @RequestBody BookingDto bookingDto){
        customerService.createBooking(custId, carId,bookingDto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}/booking")
    public ResponseEntity<Void> deleteBooking(@PathVariable Long id){
        customerService.deleteBooking(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/car")
    public ResponseEntity<List<Car>> getAllCars(){
        return  ResponseEntity.ok(customerService.getAllCars());
    }




}
