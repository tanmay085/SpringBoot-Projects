package com.tanmay.movieTicket.Dto;

import com.tanmay.movieTicket.model.Show;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

public class MovieDto {

    private Long mId;
    private String mName;
    private String director;
    private String genre;


    public Long getId(){
        return mId;
    }
    public String getmName(){
        return mName;
    }
    public String getDirector(){
        return director;
    }
    public String getGenre(){
        return genre;
    }



    public void setmName(String name){
        this.mName=name;
    }
    public void setDirector(String director){
        this.director=director;
    }
    public void setGenre(String genre){
        this.genre=genre;
    }
}
