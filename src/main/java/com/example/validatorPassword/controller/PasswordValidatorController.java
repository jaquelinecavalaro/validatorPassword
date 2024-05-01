package com.example.validatorPassword.controller;

import com.example.validatorPassword.service.PasswordValidatorService;
import com.example.validatorPassword.service.impl.PasswordValidatorServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user-area")
public class PasswordValidatorController {

    private final PasswordValidatorService passwordValidatorService;

    public PasswordValidatorController(PasswordValidatorService passwordValidatorService) {
        this.passwordValidatorService = passwordValidatorService;
    }

    @GetMapping("/validate-password")
    public ResponseEntity<Boolean> validatePassword(@RequestParam String password) {
        boolean isValid = passwordValidatorService.getValidatePassword(password);
        return ResponseEntity.ok(isValid);
    }
}
