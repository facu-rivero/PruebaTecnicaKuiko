package com.pruebatecnica.kuikoservice.exceptions;

import com.pruebatecnica.kuikoservice.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<ErrorDto> runtimeExpectionHandler(RuntimeException ex) {
        ErrorDto error = ErrorDto.builder().message(ex.getMessage()).build();
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = NoSuchElementException.class)
    public ResponseEntity<ErrorDto> noSuchElementExceptionHandler(NoSuchElementException ex) {
        ErrorDto error = ErrorDto.builder().message(ex.getMessage()).build();
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }
}
