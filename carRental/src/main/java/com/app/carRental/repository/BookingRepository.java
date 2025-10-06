package com.app.carRental.repository;

import com.app.carRental.entity.Booking;
import com.app.carRental.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Long > {
    List<Booking> findByCar(Car car);
    @Query("""
       SELECT CASE WHEN COUNT(b) > 0 THEN true ELSE false END
       FROM Booking b
       WHERE b.car.id = :carId
         AND b.startTime <= :endTime
         AND b.endTime >= :startTime
    """)
    boolean existsOverlappingBooking(@Param("carId") Long carId,
                                     @Param("startTime") LocalDateTime startTime,
                                     @Param("endTime") LocalDateTime endTime);
}
