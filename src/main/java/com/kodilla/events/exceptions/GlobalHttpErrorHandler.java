package com.kodilla.events.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalHttpErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CantDivideByZeroException.class)
    public ResponseEntity<Object> handleCantDivideByZeroException(CantDivideByZeroException exception) {
        return new ResponseEntity<>("It isn't possible to divide by zero", HttpStatus.BAD_REQUEST);
    }
}
