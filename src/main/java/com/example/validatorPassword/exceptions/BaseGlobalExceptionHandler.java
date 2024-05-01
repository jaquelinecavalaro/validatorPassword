package com.example.validatorPassword.exceptions;

import com.example.validatorPassword.enums.ErrorType;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.LocalDateTime;


@Slf4j
@RestControllerAdvice
public class BaseGlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorResponse> invalidParameterType(final RuntimeException ex,
                                                              final HttpServletRequest request) {
        log.error(ex.getMessage());

        var error = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .error(ErrorType.BAD_REQUEST_INVALID_PARAMETER.getMessage())
                .path(request.getRequestURI())
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    //arumar as exceções personalizadas
    //construir o readme
    //desenhar a arquitetura do programa
    //explicar minha linha de raciocinio
    //separar massas
    //utilizar o yaml

}
