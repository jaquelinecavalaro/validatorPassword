package com.example.validatorPassword.controller;

import com.example.validatorPassword.service.PasswordValidatorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PasswordValidatorController {

    private final PasswordValidatorService passwordValidatorService;

    public PasswordValidatorController(PasswordValidatorService passwordValidatorService) {
        this.passwordValidatorService = passwordValidatorService;
    }

    @GetMapping("/validatePassword")
    public ResponseEntity<Boolean> validatePassword(@RequestParam String password) {
        boolean isValid = passwordValidatorService.validatePassword(password);
        return ResponseEntity.ok(isValid);
    }
}
