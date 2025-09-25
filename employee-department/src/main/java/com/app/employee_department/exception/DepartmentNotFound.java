package com.app.employee_department.exception;

public class DepartmentNotFound extends  RuntimeException{
    public DepartmentNotFound(String message){
        super(message);
    }
}
