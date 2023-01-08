package com.example.cleanCodeAndTest.exceptions;

import com.example.cleanCodeAndTest.domain.enumeration.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BusinessException extends RuntimeException{
    private final Integer code;

    public BusinessException(String message,  ErrorCode code) {
        super(message);
        this.code = code.code;
    }
}
