package com.tanmay.movieTicket.service;

import com.tanmay.movieTicket.Dto.ShowDto;
import com.tanmay.movieTicket.model.Booking;
import com.tanmay.movieTicket.model.Movie;
import com.tanmay.movieTicket.model.Show;
import com.tanmay.movieTicket.model.Theater;
import com.tanmay.movieTicket.repository.BookingRepository;
import com.tanmay.movieTicket.repository.MovieRepository;
import com.tanmay.movieTicket.repository.ShowRepository;
import com.tanmay.movieTicket.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowService {

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private TheaterRepository theaterRepository;

    @Autowired
    private MovieRepository movieRepository;


    @Autowired
    private BookingService  bookingService;

    public ShowDto createShow(Long movieId, Long theaterId, ShowDto showDto) {
        Show show = new Show();
        show.setTime(showDto.getTime());

        Movie movie = movieRepository.findById(movieId).orElseThrow();
        show.setMovie(movie);

        Theater theater = theaterRepository.findById(theaterId).orElseThrow();
        show.setTheater(theater);

        Show savedShow = showRepository.save(show);

        // Create empty booking for this show
        Booking booking = new Booking();
        booking.setShow(savedShow);
        bookingService.thebook(booking);

        return showDto;
    }


    public List<Show> getShowByTheaterMovie(Long mId, Long tId){
        Movie movie=movieRepository.findById(mId).get();
        Theater theater=theaterRepository.findById(tId).get();
        return showRepository.findByMovieAndTheater(movie, theater);
    }


}
