package com.app.carRental.Exception;

public class InvalidDateException extends RuntimeException{
    public InvalidDateException (String message){
        super(message);
    }
}
