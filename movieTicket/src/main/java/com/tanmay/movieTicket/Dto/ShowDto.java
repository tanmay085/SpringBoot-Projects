package com.tanmay.movieTicket.Dto;

import com.tanmay.movieTicket.model.Movie;
import com.tanmay.movieTicket.model.Theater;
import jakarta.persistence.*;

public class ShowDto {


    private Long showId;
    private String time;


    private Movie movie;


    private Theater theater;


    public Long getId(){
        return showId;
    }
    public String getTime(){
        return time;
    }
    public Movie getMovie(){
        return movie;
    }
    public Theater getTheater(){
        return theater;
    }



    public void setTime(String time){
        this.time=time;
    }
    public void setMovie(Movie movie){
        this.movie=movie;
    }
    public void setTheater(Theater theater){
        this.theater=theater;
    }
}
