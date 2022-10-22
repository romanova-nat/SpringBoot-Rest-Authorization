package ru.netology.springbootauthorizationservice.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(InvalidCredentials.class)
    ResponseEntity<String> handleInvalidCredentials(InvalidCredentials ex) {
        System.out.println("Error 400: " + ex.getMessage());
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(UnauthorizedUser.class)
    ResponseEntity handleUnauthorizedUser(UnauthorizedUser ex) {
        System.out.println("Error 401: " + ex.getMessage());
        return new ResponseEntity(ex.getMessage(), HttpStatus.UNAUTHORIZED);
    }
}