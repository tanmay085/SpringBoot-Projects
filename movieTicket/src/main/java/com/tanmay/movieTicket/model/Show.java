package com.tanmay.movieTicket.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Show {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long show_Id;
    private String time;

    @OneToOne(mappedBy = "show", cascade = CascadeType.ALL)
    @JsonBackReference
    private Booking booking;


    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference(value = "show-movie")
    private Movie movie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference(value = "show-theater")
    private Theater theater;


    public Long getShow_Id(){
        return show_Id;
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


    public void setShow_Id(long show_Id) {
        this.show_Id = show_Id;
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
