package com.tanmay.movieTicket.repository;

import com.tanmay.movieTicket.model.Booking;
import com.tanmay.movieTicket.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Long> {
    public Booking findByShow(Show show);
}
