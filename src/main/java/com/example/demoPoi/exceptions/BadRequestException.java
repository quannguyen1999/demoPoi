package com.example.demoPoi.exceptions;

import com.example.demoPoi.constants.MessageErrors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {

    public BadRequestException(MessageErrors exception) {
        super(exception.toString());
    }

}