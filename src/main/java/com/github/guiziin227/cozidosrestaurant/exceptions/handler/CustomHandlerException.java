package com.github.guiziin227.cozidosrestaurant.exceptions.handler;

import com.github.guiziin227.cozidosrestaurant.exceptions.ExceptionResponse;
import com.github.guiziin227.cozidosrestaurant.exceptions.OrderConflictException;
import com.github.guiziin227.cozidosrestaurant.exceptions.UserExistsException;
import com.github.guiziin227.cozidosrestaurant.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestController
@ControllerAdvice
public class CustomHandlerException extends ResponseEntityExceptionHandler {

    @ExceptionHandler({UserNotFoundException.class})
    public final ResponseEntity<ExceptionResponse> handleNotFoundException(Exception ex, WebRequest request) {
        ExceptionResponse resp = new ExceptionResponse(
                new Date(),
                ex.getMessage(),
                request.getDescription(false)
        );
        return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({OrderConflictException.class,UserExistsException.class})
    public final ResponseEntity<ExceptionResponse> handleExistsException(Exception ex, WebRequest request) {
        ExceptionResponse resp = new ExceptionResponse(
                new Date(),
                ex.getMessage(),
                request.getDescription(false)
        );
        return new ResponseEntity<>(resp, HttpStatus.CONFLICT);
    }



}
