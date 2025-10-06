package com.app.carRental.service;

import com.app.carRental.Exception.BookingNotFound;
import com.app.carRental.Exception.CarNotFound;
import com.app.carRental.dto.CarDto;
import com.app.carRental.entity.Booking;
import com.app.carRental.entity.BookingStatus;
import com.app.carRental.entity.Car;
import com.app.carRental.repository.BookingRepository;
import com.app.carRental.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private BookingRepository bookingRepository;

    public CarDto createCar(CarDto carDto){

        Car car=new Car();
        car.setDailyPrice(carDto.getDailyPrice());
        car.setRegisterNumber(carDto.getRegisterNumber());
        car.setYear(carDto.getYear());
        carRepository.save(car);
        return carDto;
    }

    public CarDto getCar(Long id){
        Car car= carRepository.findById(id).
                orElseThrow(()-> new CarNotFound("Restaurant Not found by id: "+id));
        CarDto carDto=new CarDto();
        carDto.setYear(car.getYear());
        carDto.setDailyPrice(car.getDailyPrice());
        carDto.setRegisterNumber(car.getRegisterNumber());
        return carDto;
    }

    public void updateCar(CarDto carDto, Long id){
        Car car= carRepository.findById(id)
                .orElseThrow(()-> new CarNotFound("car not found by id:"+id));
        car.setYear(carDto.getYear());
        car.setDailyPrice(carDto.getDailyPrice());
        car.setRegisterNumber(carDto.getRegisterNumber());
        carRepository.save(car);
    }

    public void deleteCar(Long id){
        Car car =carRepository.findById(id)
                .orElseThrow(()-> new CarNotFound("car not found by id:"+id));
        carRepository.delete(car);
    }

    public void confirmBooking(Long id){
        Booking booking= bookingRepository.findById(id).
                orElseThrow(()-> new BookingNotFound("Booking not found by id:"+id));
        booking.setStatus(BookingStatus.CONFIRM);
        bookingRepository.save(booking);
    }

    public void cancelBooking(Long id){
        Booking booking= bookingRepository.findById(id).
                orElseThrow(()-> new BookingNotFound("Booking not found by id:"+id));
        booking.setStatus(BookingStatus.CANCELLED);
        bookingRepository.save(booking);
    }

    public List<Booking> getBookings(Long id){
        Car car = carRepository.findById(id).
                orElseThrow(()-> new CarNotFound("car not by id:"+id));
        return bookingRepository.findByCar(car);
    }
}
