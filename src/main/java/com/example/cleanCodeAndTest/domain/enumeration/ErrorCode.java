package com.example.cleanCodeAndTest.domain.enumeration;

public enum ErrorCode {

    NOT_FOUND(404);


    public final Integer code;
    ErrorCode(int code) {
        this.code = code;
    }
}
