package com.app.student_management.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ErrorResponse {

    LocalDateTime time;
    String errorMessage;
    String errorDetails;
    String errorCode;

    public ErrorResponse(String errorMessage, String errorDetails, String errorCode) {
        this.time= LocalDateTime.now();
        this.errorMessage = errorMessage;
        this.errorDetails = errorDetails;
        this.errorCode = errorCode;
    }
}
