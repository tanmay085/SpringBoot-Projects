package com.app.foodDelivery.Exception;

import com.app.foodDelivery.Entity.ErrorResponse;
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
        String errors=ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.joining(","));
        ErrorResponse errorResponse=new ErrorResponse(
                "validation failed",
                errors,
                "400"
        );
        return  new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<ErrorResponse> handleRestaurantNotFound(RestaurantNotFound rsn){
        ErrorResponse errorResponse=new ErrorResponse(
                "failed",
                rsn.getMessage(),
                "409"
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

    public ResponseEntity<ErrorResponse>handleMenuNotFound(MenuNotFound mnf){
        ErrorResponse errorResponse=new ErrorResponse(
                "failed",
                mnf.getMessage(),
                "409"
        );
        return  new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

    public ResponseEntity<ErrorResponse>handleUserNotFound(UserNotFound unf){
        ErrorResponse errorResponse=new ErrorResponse(
                "failed",
                unf.getMessage(),
                "409"
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }
}
