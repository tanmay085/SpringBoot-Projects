package com.tanmay.movieTicket.controller;

import com.tanmay.movieTicket.Dto.CityDto;
import com.tanmay.movieTicket.Dto.MovieDto;
import com.tanmay.movieTicket.Dto.ShowDto;
import com.tanmay.movieTicket.Dto.TheaterDto;
import com.tanmay.movieTicket.model.City;
import com.tanmay.movieTicket.model.Movie;
import com.tanmay.movieTicket.model.Theater;
import com.tanmay.movieTicket.service.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TicketBookingController {

    @Autowired
    private CityService cityService;
    @Autowired
    private MovieService movieService;
    @Autowired
    private ShowService showService;
    @Autowired
    private TheaterService theaterService;


    @GetMapping("/test")
    public String returnString(){
        return "Movie Ticket Booking";
    }

    @PostMapping("/city")
    public CityDto creatCity(@RequestBody CityDto cityDto){
        return this.cityService.createCity(cityDto);
    }

    @PostMapping("{id}/movie")
    public MovieDto createMovie(@PathVariable Long id,@RequestBody MovieDto movieDto){
        return this.movieService.createMovie(id,movieDto);
    }

    @PostMapping("/{id}/theater")
    public TheaterDto createTheater(@PathVariable long id,@RequestBody TheaterDto theaterDto){
        return this.theaterService.createTheater(id,theaterDto);
    }

    @PostMapping("/{Id}/{id}/show")
    public ShowDto createShow(@PathVariable Long Id, @PathVariable Long id, @RequestBody ShowDto showDto){
        return this.showService.createShow(Id,id, showDto);
    }

    @GetMapping("/{id}/city")
    public CityDto getCity(@PathVariable Long id, @RequestBody CityDto cityDto){
        return this.cityService.getCity(id,cityDto);
    }

    @GetMapping ("/{id}/movie")
    public MovieDto getMovie(@PathVariable Long id, MovieDto movieDto){
        return this.movieService.getMovie(id,movieDto);
    }

    @GetMapping("/{id}/theater")
    public TheaterDto getTheater (@PathVariable Long id, @RequestBody TheaterDto theaterDto){
        return this.theaterService.getTheater(id, theaterDto);
    }

    @GetMapping("/movie")
    public List<Movie> getMovie(){
        return movieService.getMovielist();
    }

    @GetMapping("/city")
    public List<City> getCity(){
        return cityService.getCitylist();
    }

    @GetMapping("/theater")
    public List<Theater> getTheaterlist(){
        return this.theaterService.getTheaterlist();
    }

    @PutMapping("/{id}/city")
    public CityDto updateCity(@PathVariable Long id, @RequestBody CityDto cityDto){
        return cityService.updateCity(id,cityDto);
    }

    @PutMapping("/{id}/movie")
    public MovieDto updateMovie(@PathVariable Long id, @RequestBody MovieDto movieDto){
        return this.movieService.updateMovie(id, movieDto);
    }

    @PutMapping("/{id}/theater")
    public TheaterDto updateTheater(@PathVariable Long id, @RequestBody TheaterDto theaterDto){
        return this.theaterService.updateTheater(id,theaterDto);
    }


    @DeleteMapping("/{id}/city")
    public City deleteCity(@PathVariable Long id){
        return this.cityService.deleteCity(id);
    }

    @DeleteMapping ("/{id}/movie")
    public Movie deleteMovie(@PathVariable Long id){
        return  this.movieService.deleteMovie(id);
    }

    @DeleteMapping("/{id}/theater")
    public Theater deleteTheater(@PathVariable Long id){
        return this.theaterService.deleteTheater(id);
    }




}
