package com.tanmay.movieTicket.model;

import jakarta.persistence.*;
import org.hibernate.boot.registry.selector.StrategyRegistration;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

@Entity
@Table(name="tableCity")
@EntityListeners(AuditingEntityListener.class)
public class City {
    @GeneratedValue(strategy=GenerationType.AUTO )
    @Id
    private Long cId;
    private String cName;
    private Long pincode;

    @OneToMany(mappedBy = "city",cascade = CascadeType.ALL)
    private List<Theater> theaters;


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
