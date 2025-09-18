package com.bookStore.bookStore.entity;

import jakarta.persistence.*;

@Entity
@Table(name="myBooks")
public class MyBookList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String author;
    private Integer price;

    public Long getId() {
        return id;
    }
    public String getName(){
        return name;
    }
    public String getAuthor(){
        return author;
    }
    public int getPrice(){
        return price;
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
    public MyBookList() {
    }
    public MyBookList(String name, String author, Integer price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }



}
