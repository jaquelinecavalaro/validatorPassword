package com.example.validatorPassword.service.impl;

import com.example.validatorPassword.service.PasswordValidatorService;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class PasswordValidatorServiceImpl implements PasswordValidatorService {

    //minha regra de negócio
    @Override
    public boolean getValidatePassword(String password) {
        return hasMinimumLength(password) &&
                hasDigitNumber(password) &&
                hasLowerCaseLetter(password) &&
                hasUpperCaseLetter(password) &&
                hasSpecialCharacter(password) &&
                hasNoRepeatedCharacters(password);
    }

    //verifica minimo de caracter e se há espaço em branco
    private boolean hasMinimumLength(String password) {

        return password != null && password.length() >= 9 && !password.contains(" ");
    }

    //verifica se há ao menos um digito numerico
    private boolean hasDigitNumber(String password) {
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
        // ignorando uppercase e lowercase
        String lowercasePassword = password.toLowerCase();

        // Verifica se há letras repetidas
        for (int i = 0; i < lowercasePassword.length(); i++) {
            char currentChar = lowercasePassword.charAt(i);
            if (Character.isLetter(currentChar) && lowercasePassword.substring(i + 1).contains(String.valueOf(currentChar))) {
                return false;
            }
        }
        return true;
    }


}
