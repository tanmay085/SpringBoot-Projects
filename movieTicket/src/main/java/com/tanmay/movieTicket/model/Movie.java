package com.tanmay.movieTicket.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

@Entity
@Table(name="tableMovie")
@EntityListeners(AuditingEntityListener.class)
public class Movie {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long mId;
    private String mName;
    private String director;
    private String genre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private Theater theater;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "show-movie")
    private List<Show> show;
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
    public Theater getTheater(){
        return theater;
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
    public void setTheater(Theater theater){
        this.theater=theater;
    }





}
