package com.example.demoPoi.exceptions;

public class InternerServerException extends RuntimeException {

    public InternerServerException(String exception) {
        super(exception);
    }
}