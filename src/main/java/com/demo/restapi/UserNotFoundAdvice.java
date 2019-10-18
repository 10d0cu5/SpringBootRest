package com.demo.restapi;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class UserNotFoundAdvice {

    @ResponseBody //Will render advice to response body
    @ExceptionHandler(UserNotFoundException.class) //Only responding if UserNotFoundException is thrown
    @ResponseStatus(HttpStatus.NOT_FOUND) //404 Status of Http Response

    String employeeNotFoundHandler(UserNotFoundException ex) {
        return ex.getMessage();
    }

}
