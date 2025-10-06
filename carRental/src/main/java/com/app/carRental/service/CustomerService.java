package com.app.carRental.service;

import com.app.carRental.Exception.*;
import com.app.carRental.dto.BookingDto;
import com.app.carRental.dto.CustomerDto;
import com.app.carRental.entity.Booking;
import com.app.carRental.entity.BookingStatus;
import com.app.carRental.entity.Car;
import com.app.carRental.entity.Customer;
import com.app.carRental.repository.BookingRepository;
import com.app.carRental.repository.CarRepository;
import com.app.carRental.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private BookingRepository   bookingRepository;

    public CustomerDto createCustomer(CustomerDto customerDto){
        Customer customer=new Customer();
        customer.setName(customerDto.getName());
        customer.setPhone(customerDto.getPhone());
        customer.setEmail(customerDto.getEmail());
        customerRepository.save(customer);
        return customerDto;
    }

    public void createBooking(Long custId, Long carId,BookingDto bookingDto){
        if(bookingDto.getStartTime()==null||bookingDto.getEndTime()==null||
        !bookingDto.getStartTime().isBefore(bookingDto.getEndTime())){
            throw  new InvalidDateException("Invalid Date:");
        }
        Car car= carRepository.findById(carId)
                .orElseThrow(()-> new CarNotFound("car not found by id:"+carId));

        Customer customer=customerRepository.findById(custId)
                .orElseThrow(()->new CustomerNotFound("customer not found by id:"+custId));

        boolean overlap = bookingRepository.existsOverlappingBooking(car.getId(), bookingDto.getStartTime(),bookingDto.getEndTime());
        if (overlap) throw new CarAlreadyBookedException("Car is already booked for the selected dates.");

        long hour= Duration.between(bookingDto.getStartTime(), bookingDto.getEndTime()).toHours();
        long days=Math.max(1,(int)Math.ceil(hour/24.0));
        BigDecimal total=car.getDailyPrice().multiply(BigDecimal.valueOf(days));

        Booking booking= new Booking();
        booking.setCustomer(customer);
        booking.setCar(car);
        booking.setTotalPrice(total);
        booking.setStartTime(bookingDto.getStartTime());
        booking.setEndTime(bookingDto.getEndTime());
        booking.setStatus(BookingStatus.PENDING);

        bookingRepository.save(booking);



    }

    public void deleteBooking(Long id){
        Booking booking= bookingRepository.findById(id)
                .orElseThrow(()->new BookingNotFound("Booking not found by id:"+id));
        bookingRepository.delete(booking);
    }

    public List<Car> getAllCars(){
        return carRepository.findAll();
    }

}
