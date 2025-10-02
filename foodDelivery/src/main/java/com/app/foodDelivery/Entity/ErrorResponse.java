package com.app.foodDelivery.Entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
@Getter
@Setter
public class ErrorResponse {

    private LocalTime time;
    private String errorMessage;
    private String errorCode;
    private String errorDetail;

    public ErrorResponse(String errorMessage, String errorCode, String errorDetail) {
        this.time=LocalTime.now();
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
        this.errorDetail = errorDetail;
    }
}
