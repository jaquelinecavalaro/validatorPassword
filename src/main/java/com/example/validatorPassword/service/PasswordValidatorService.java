package com.example.validatorPassword.service;

import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class PasswordValidatorService {
    public boolean validatePassword(String password) {
        if (password == null || password.length() < 9) return false;

        Pattern digitPattern = Pattern.compile(".*\\d.*");
        Pattern lowerCasePattern = Pattern.compile(".*[a-z].*");
        Pattern upperCasePattern = Pattern.compile(".*[A-Z].*");
        Pattern specialCharPattern = Pattern.compile(".*[!@#$%^&*()\\-+].*");
        Pattern noRepeatPattern = Pattern.compile("^(?!.*(.).*\\1).*$");

        return digitPattern.matcher(password).matches() &&
                lowerCasePattern.matcher(password).matches() &&
                upperCasePattern.matcher(password).matches() &&
                specialCharPattern.matcher(password).matches() &&
                noRepeatPattern.matcher(password).matches();
    }
}
