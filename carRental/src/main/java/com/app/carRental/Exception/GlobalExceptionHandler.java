package com.app.carRental.Exception;

import com.app.carRental.entity.Booking;
import com.app.carRental.entity.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.http.converter.HttpMessageNotReadableException;
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
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CarNotFound.class)
    public ResponseEntity<ErrorResponse> carNotFoundById(CarNotFound nf){
        ErrorResponse errorResponse=new ErrorResponse(
                "falied",
                nf.getMessage(),
                "409"
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidDateException.class)
    public ResponseEntity<ErrorResponse> invalidDate(InvalidDateException dx){
        ErrorResponse errorResponse=new ErrorResponse(
                "falied",
                dx.getMessage(),
                "409"
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CustomerNotFound.class)
    public ResponseEntity<ErrorResponse> customerNotFound(CustomerNotFound nf){
        ErrorResponse errorResponse=new ErrorResponse(
                "falied",
                nf.getMessage(),
                "409"
        );
        return  new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(CarAlreadyBookedException.class)
    public ResponseEntity<ErrorResponse> carAlreadyBooked(CarAlreadyBookedException bx){
        ErrorResponse errorResponse=new ErrorResponse(
                "falied",
                bx.getMessage(),
                "409"
        );
        return  new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BookingNotFound.class)
    public ResponseEntity<ErrorResponse> bookingNotFound(BookingNotFound bx){
        ErrorResponse errorResponse=new ErrorResponse(
                "falied",
                bx.getMessage(),
                "409"
        );
        return  new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> handleInvalidFormat(HttpMessageNotReadableException ex) {
        return ResponseEntity.badRequest().body("Invalid date-time format. Use 'yyyy-MM-ddTHH:mm:ss'");
    }

}
