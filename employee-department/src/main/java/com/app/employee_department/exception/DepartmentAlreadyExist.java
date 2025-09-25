package com.app.employee_department.exception;

public class DepartmentAlreadyExist extends RuntimeException {
    public DepartmentAlreadyExist(String message){
        super(message);
    }

}
