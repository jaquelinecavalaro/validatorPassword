package com.example.validatorPassword.exceptions;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ErrorResponse(
        LocalDateTime timestamp,
        Integer status,
        String error,
        String path) {}
