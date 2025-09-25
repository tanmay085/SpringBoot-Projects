package com.app.student_management.exception;

public class DepartmentNotFound extends RuntimeException{
    public DepartmentNotFound (String message){
        super(message);
    }
}
