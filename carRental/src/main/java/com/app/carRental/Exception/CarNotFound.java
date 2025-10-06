package com.app.carRental.Exception;

public class CarNotFound extends RuntimeException{
    public CarNotFound(String message){
        super(message);
    }
}
