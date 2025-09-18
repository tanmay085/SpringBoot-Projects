package com.tanmay.movieTicket.service;

import com.tanmay.movieTicket.Dto.BookingDto;
import com.tanmay.movieTicket.model.Booking;
import com.tanmay.movieTicket.model.Show;
import com.tanmay.movieTicket.repository.BookingRepository;
import com.tanmay.movieTicket.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;

@Service
public class BookingService {

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private BookingRepository bookingRepository;

    public Booking thebook( Booking booking){
        return bookingRepository.save(booking);
    }

    public Booking getAvailableSeats(Long id){
        Show show= showRepository.findById(id).get();

        return bookingRepository.findByShow(show);
    }

    public Booking bookTicket(Long showId, Booking bookingRequest) {
        // Fetch the show
        Show show = showRepository.findById(showId).get();
        bookingRequest.setShow(show);

        // Save the booking
        return bookingRepository.save(bookingRequest);
    }
}


