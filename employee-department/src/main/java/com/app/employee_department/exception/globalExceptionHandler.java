package com.app.employee_department.exception;

import com.app.employee_department.model.Employee;
import com.app.employee_department.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.stream.Collector;
import java.util.stream.Collectors;
@ControllerAdvice
public class globalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(MethodArgumentNotValidException ex){
        String errors= ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.joining(", "));
        ErrorResponse errorResponse= new ErrorResponse(
                "Validation Failed",
                errors,
                "400"
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DepartmentAlreadyExist.class)
    public ResponseEntity<ErrorResponse> departmentAlreadyExist(DepartmentAlreadyExist dae){
        ErrorResponse errorResponse= new ErrorResponse(
                "already exist",
                dae.getMessage(),
                "409"
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(DepartmentNotFound.class)
    public ResponseEntity<ErrorResponse> departmentNotFound(DepartmentNotFound dnf){
        ErrorResponse errorResponse= new ErrorResponse(
                "failed",
                dnf.getMessage(),
                "409"
        );
        return  new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(EmployeeNotFound.class)
    public ResponseEntity<ErrorResponse> employeeNotFound(EmployeeNotFound enf){
        ErrorResponse errorResponse=new ErrorResponse(
                "failed",
                enf.getMessage(),
                "409"
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }
}
