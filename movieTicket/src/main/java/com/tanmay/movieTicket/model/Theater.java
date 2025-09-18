package com.tanmay.movieTicket.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

@Entity
@Table(name = "tableTheater")
@EntityListeners(AuditingEntityListener.class)
public class Theater {

    @GeneratedValue(strategy=GenerationType.AUTO)
    @Id
    private Long tId;
    private String tName;
    private String tArea;

    @ManyToOne(fetch = FetchType.LAZY  )
    private City city;

    @OneToMany(mappedBy = "theater", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Movie> movie;

    @OneToMany(mappedBy="theater", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "show-theater")
    private List<Show> show;

    public Long getId() {
        return tId;
    }
    public String getName(){
        return tName;
    }
    public String getArea(){
        return tArea;
    }
    public City  getCity(){
        return city;
    }





    public void setName(String tName){
        this.tName=tName;
    }
    public void setArea(String tArea){
        this.tArea=tArea;
    }
    public void setCity(City city){
        this.city=city;
    }
   


}
