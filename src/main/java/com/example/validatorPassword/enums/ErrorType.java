package com.example.validatorPassword.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ErrorType {
    BAD_REQUEST_INVALID_PARAMETER("Invalid parameter type");

    private final String message;

    ErrorType(String message) { this.message = message; }

    @JsonValue
    public String getMessage(){ return this.message;}
}
