package com.example.validatorPassword.service;

import org.springframework.stereotype.Service;

@Service
public interface PasswordValidatorService {

    boolean getValidatePassword(final String password);
}
