package com.app.student_management.exception;

public class DepartmentExist extends RuntimeException{

    public DepartmentExist(String message){
        super(message);
    }

}
