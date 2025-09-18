package com.tanmay.movieTicket.Dto;

import com.tanmay.movieTicket.model.City;
import com.tanmay.movieTicket.model.Show;

import java.util.List;

public class TheaterDto {

    private Long tId;
    private String tName;
    private String tArea;


    private City city;


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
