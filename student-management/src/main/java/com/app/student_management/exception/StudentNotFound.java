package com.app.student_management.exception;

public class StudentNotFound extends RuntimeException{
    public StudentNotFound (String message){
        super (message);
    }
}
