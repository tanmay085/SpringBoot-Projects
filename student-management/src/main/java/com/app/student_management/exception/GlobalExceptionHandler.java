package com.app.student_management.exception;

import com.app.student_management.entity.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

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

    @ExceptionHandler(DepartmentExist.class)
    public ResponseEntity<ErrorResponse>handleDepartmentExist(DepartmentExist de){
        ErrorResponse errorResponse= new ErrorResponse(
                "dublicate department",
                de.getMessage(),
                "409"
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(DepartmentNotFound.class)
    public ResponseEntity<ErrorResponse>handleDepartmentNotFound(DepartmentNotFound dnf){
        ErrorResponse errorResponse=new ErrorResponse(
                "Department not found",
                dnf.getMessage(),
                "409"
        );
        return new ResponseEntity<>(errorResponse,HttpStatus.CONFLICT);
    }

    @ExceptionHandler(StudentNotFound.class)
    public ResponseEntity<ErrorResponse>handleStudentNotFound(StudentNotFound snf){
        ErrorResponse errorResponse=new ErrorResponse(
                "student not found",
                snf.getMessage(),
                "409"
        );
        return new ResponseEntity<>(errorResponse,HttpStatus.CONFLICT);
    }
}
