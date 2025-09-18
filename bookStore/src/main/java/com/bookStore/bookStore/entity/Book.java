package com.bookStore.bookStore.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {

    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    private Long id;
    private String name;
    private String author;
    private Integer price;

    public long getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getAuthor(){
        return author;
    }
    public Integer getPrice(){
        return price;
    }

    public void setId(Long id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setAuthor(String author){
        this.author = author;
    }
    public void setPrice(Integer price){
        this.price = price;
    }



}
