package com.example.validatorPassword.controller;

import com.example.validatorPassword.service.PasswordValidatorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user-area")
public class PasswordValidatorController {

    private final PasswordValidatorService passwordValidatorService;

    public PasswordValidatorController(PasswordValidatorService passwordValidatorService) {
        this.passwordValidatorService = passwordValidatorService;
    }

    @GetMapping("/validate-password")
    public ResponseEntity<Boolean> validatePassword(@RequestBody String password) {
        boolean isValid = passwordValidatorService.validatePassword(password);
        return ResponseEntity.ok(isValid);
    }
}
