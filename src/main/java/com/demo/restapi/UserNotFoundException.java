package com.demo.restapi;

public class UserNotFoundException extends RuntimeException  {

    public UserNotFoundException(Long id) { //uesd to render a 404
        super("Could not find employee " + id);
    }
}
