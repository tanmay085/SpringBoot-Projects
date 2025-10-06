package com.app.carRental.controller;

import com.app.carRental.dto.CarDto;
import com.app.carRental.entity.Booking;
import com.app.carRental.service.AdminService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/car")
    public ResponseEntity<CarDto> createCar(@Valid @RequestBody CarDto carDto){
        return ResponseEntity.ok(adminService.createCar(carDto));
    }

    @GetMapping("{id}/car")
    public ResponseEntity<CarDto> getCar(@PathVariable Long id){
        return ResponseEntity.ok(adminService.getCar(id));

    }

    @PutMapping("/{id}/car")
    public ResponseEntity<Void> updateCar(@Valid @RequestBody CarDto carDto, @PathVariable Long id){
        adminService.updateCar(carDto, id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}/car")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id){
        adminService.deleteCar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}/Booking")
    public ResponseEntity<Void> confirmBooking(@PathVariable Long id){
        adminService.confirmBooking(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}/Booking")
    public ResponseEntity<Void> cancelBooking(@PathVariable Long id){
        adminService.cancelBooking(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("{id}/booking")
    public ResponseEntity<List<Booking>> getBookingByCarId(@PathVariable Long id){
        return ResponseEntity.ok(adminService.getBookings(id));
    }
}
