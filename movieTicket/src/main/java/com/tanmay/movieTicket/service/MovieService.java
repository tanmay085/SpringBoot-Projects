package com.tanmay.movieTicket.service;

import com.tanmay.movieTicket.Dto.MovieDto;
import com.tanmay.movieTicket.model.Movie;
import com.tanmay.movieTicket.model.Theater;
import com.tanmay.movieTicket.repository.MovieRepository;
import com.tanmay.movieTicket.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private TheaterRepository theaterRepository;

    public MovieDto createMovie( Long id ,MovieDto movieDto){
        Movie movie= new Movie();
        movie.setmName(movieDto.getmName());
        movie.setDirector(movieDto.getDirector());
        movie.setGenre(movieDto.getGenre());
        Theater theater =theaterRepository.findById(id).get();
        movie.setTheater(theater);
        movieRepository.save(movie);
        return movieDto;
    }

    public MovieDto getMovie(Long id, MovieDto movieDto){
        Movie movie =movieRepository.findById(id).get();
        movieDto.setmName(movie.getmName());
        movieDto.setDirector(movie.getDirector());
        movieDto.setGenre(movie.getGenre());
        return movieDto;
    }


    public List<Movie> getMovielist(){
        return movieRepository.findAll();
    }

    public MovieDto updateMovie(Long id, MovieDto movieDto){
        Movie movie=movieRepository.findById(id).get();
        movie.setmName(movieDto.getmName());
        movieDto.setGenre(movieDto.getGenre());
        movieDto.setDirector(movieDto.getDirector());
        movieRepository.save(movie);
        return movieDto;
    }

    public Movie deleteMovie(Long id){
        Movie movie=movieRepository.findById(id).get();
        movieRepository.delete(movie);
        return movie;
    }

    public List<Movie>getMovieByTheater(Long id){
        Theater theater=theaterRepository.findById(id).get();
        return movieRepository.findByTheater(theater);
    }

}
