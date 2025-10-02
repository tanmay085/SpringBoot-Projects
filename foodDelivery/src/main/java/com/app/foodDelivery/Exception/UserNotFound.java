package com.app.foodDelivery.Exception;

public class UserNotFound extends RuntimeException{
    public UserNotFound (String message){
        super(message);
    }
}
