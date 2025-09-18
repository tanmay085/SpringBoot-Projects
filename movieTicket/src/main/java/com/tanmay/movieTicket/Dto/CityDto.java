package com.tanmay.movieTicket.Dto;

import com.tanmay.movieTicket.model.Theater;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

public class CityDto {

    private Long cId;
    private String cName;
    private Long pincode;




    public Long getId(){
        return cId;
    }

    public String getName(){
        return cName;
    }

    public Long getPincode(){
        return pincode;
    }


    public void setName(String name){
        this.cName=name;
    }

    public void setPincode(Long pincode){
        this.pincode=pincode;
    }
}
