package com.app.carRental.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalTime;
@Data

public class ErrorResponse {

    private LocalTime time;
    private String errorMessage;
    private String errorCode;
    private String errorDetail;

    public ErrorResponse(String errorDetail, String errorCode, String errorMessage) {
        this.time=LocalTime.now();
        this.errorDetail = errorDetail;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
