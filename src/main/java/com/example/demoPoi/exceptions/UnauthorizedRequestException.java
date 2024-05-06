package com.example.demoPoi.exceptions;

import com.example.demoPoi.constants.MessageErrors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class UnauthorizedRequestException extends RuntimeException {

    public UnauthorizedRequestException(MessageErrors exception) {
        super(exception.toString());
    }

}