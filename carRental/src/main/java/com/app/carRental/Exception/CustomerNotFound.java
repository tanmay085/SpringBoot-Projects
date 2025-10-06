package com.app.carRental.Exception;

public class CustomerNotFound extends RuntimeException {
    public CustomerNotFound (String message){
        super(message);
    }
}
