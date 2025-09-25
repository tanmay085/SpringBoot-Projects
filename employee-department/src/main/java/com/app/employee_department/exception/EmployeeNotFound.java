package com.app.employee_department.exception;

import com.app.employee_department.model.Employee;

public class EmployeeNotFound extends  RuntimeException{
    public EmployeeNotFound(String message){
        super(message);
    }
}
