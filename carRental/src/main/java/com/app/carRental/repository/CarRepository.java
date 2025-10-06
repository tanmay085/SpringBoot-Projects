package com.app.carRental.repository;

import com.app.carRental.entity.Booking;
import com.app.carRental.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository< Car ,Long > {


}
