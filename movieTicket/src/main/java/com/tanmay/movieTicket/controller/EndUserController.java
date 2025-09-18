package com.tanmay.movieTicket.controller;

import com.tanmay.movieTicket.Dto.BookingDto;
import com.tanmay.movieTicket.model.*;
import com.tanmay.movieTicket.repository.TheaterRepository;
import com.tanmay.movieTicket.service.*;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class EndUserController {

    @Autowired
    private CityService cityService;

    @Autowired
    private BookingService bookingService;

    @Autowired
    private MovieService movieService;

    @Autowired
    private ShowService showService;

    @Autowired
    private TheaterService theaterService;


    @GetMapping("/city")
    public List<City> getAllCity(){
        return cityService.getCitylist();
    }

    @GetMapping("/{id}/theater")
    public List<Theater> getTheaterByCity(@PathVariable Long id){
        return cityService.getTheaterByCity(id);
    }

    @GetMapping("/{id}/movie")
    public List<Movie> getMovieByTheater(@PathVariable Long id){
        return movieService.getMovieByTheater(id);
    }

    @GetMapping("/{mId}/{tId}/show")
    public List<Show> getShowByTheaterMovie(@PathVariable Long mId, @PathVariable Long tId){
        return showService.getShowByTheaterMovie(mId,tId);
    }

    @GetMapping("{id}/show")
    public Booking getAvailableSeats(@PathVariable Long id){
        return  bookingService.getAvailableSeats(id);
    }

    @PostMapping("/{showId}/book")
    public Booking bookTicket(
            @PathVariable Long showId,
            @RequestBody Booking bookingRequest) {

        return bookingService.bookTicket(showId, bookingRequest);
    }
}
