package com.app.employee_department.model;

import java.time.LocalDateTime;
import java.time.LocalTime;


public class ErrorResponse {
    private LocalTime time;
    private String errorMessage;
    private String errorDetail;
    private String errorCode;

    public String getErrorDetail() {
        return errorDetail;
    }

    public void setErrorDetail(String errorDetail) {
        this.errorDetail = errorDetail;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public ErrorResponse(String errorMessage, String errorDetail, String errorCode) {
        this.time= LocalTime.now();
        this.errorMessage = errorMessage;
        this.errorDetail = errorDetail;
        this.errorCode = errorCode;
    }
}
