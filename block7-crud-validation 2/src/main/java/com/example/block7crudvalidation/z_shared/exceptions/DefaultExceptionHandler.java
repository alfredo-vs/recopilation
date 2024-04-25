package com.example.block7crudvalidation.z_shared.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

@ControllerAdvice
public class DefaultExceptionHandler {

    @ResponseBody
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<CustomError> handleNotFoundException(NotFoundException notFoundException) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new CustomError(LocalDateTime.now(),
                        HttpStatus.NOT_FOUND.value(),
                        notFoundException.getMessage()));

    }



    @ResponseBody
    @ExceptionHandler(UnprocessableEntityException.class)
    public ResponseEntity<CustomError> handleUnprocesableEntityException(UnprocessableEntityException unProcessableEntityException) {

        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body(new CustomError(LocalDateTime.now(),
                        HttpStatus.UNPROCESSABLE_ENTITY.value(),
                        unProcessableEntityException.getMessage()));
    }
}
