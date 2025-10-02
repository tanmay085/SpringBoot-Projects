package com.app.foodDelivery.Exception;

public class MenuNotFound extends RuntimeException{
    public MenuNotFound(String message){
        super(message);
    }
}
