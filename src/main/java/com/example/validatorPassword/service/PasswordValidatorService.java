package com.example.validatorPassword.service;

import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class PasswordValidatorService {

    //minha regra de negócio
    public boolean validatePassword(String password) {
        return hasMinimumLength(password) &&
                hasDigit(password) &&
                hasLowerCaseLetter(password) &&
                hasUpperCaseLetter(password) &&
                hasSpecialCharacter(password) &&
                hasNoRepeatedCharacters(password);
    }

    //verifica minimo de caracter e se há espaço em branco
    private boolean hasMinimumLength(String password) {
        return password != null && password.length() >= 9 && !password.contains(" ");
    }

    //verifica se há ao menos um digito
    private boolean hasDigit(String password) {
        Pattern digitPattern = Pattern.compile(".*\\d.*");
        return digitPattern.matcher(password).matches();
    }

    //verifica se há letra minuscula
    private boolean hasLowerCaseLetter(String password) {
        Pattern lowerCasePattern = Pattern.compile(".*[a-z].*");
        return lowerCasePattern.matcher(password).matches();
    }

    //verifica se há letra maiuscula
    private boolean hasUpperCaseLetter(String password) {
        Pattern upperCasePattern = Pattern.compile(".*[A-Z].*");
        return upperCasePattern.matcher(password).matches();
    }

    //verifica se há caracter especial
    private boolean hasSpecialCharacter(String password) {
        Pattern specialCharPattern = Pattern.compile(".*[!@#$%^&*()\\-+].*");
        return specialCharPattern.matcher(password).matches();
    }

    //verifica se não há caracter repetido
    private boolean hasNoRepeatedCharacters(String password) {
        Pattern noRepeatPattern = Pattern.compile("^(?!.*(.).*\\1).*$");
        return noRepeatPattern.matcher(password).matches();
    }

}
