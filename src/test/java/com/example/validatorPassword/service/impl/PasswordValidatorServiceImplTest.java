package com.example.validatorPassword.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static com.example.validatorPassword.common.TestConstants.*;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PasswordValidatorServiceImplTest {

    @InjectMocks
    PasswordValidatorServiceImpl passwordValidatorService;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("should return true when all rules is true")
    public void shouldReturnTrueWhenAllRulesIsTrue(){

        assertTrue(passwordValidatorService.getValidatePassword(RULES_TRUE));
    }

    @Test
    @DisplayName("should return false when rule hasMinimumLength is false")
    public void shouldReturnFalseWhenRuleHasMinimumLengthhasMinimumLengthIsFalse(){

        assertFalse(passwordValidatorService.getValidatePassword(HAS_MINIMUM_LENGTH_FALSE));
    }

    @Test
    @DisplayName("should return false when rule hasDigitNumber is false")
    public void shouldReturnFalseWhenRuleHasDigitNumberIsFalse(){

        assertFalse(passwordValidatorService.getValidatePassword(HAS_DIGIT_NUMBER_FALSE));
    }

    @Test
    @DisplayName("should return false when rule hasLowerCaseLetter is false")
    public void shouldReturnFalseWhenRuleHasLowerCaseLetterIsFalse(){

        assertFalse(passwordValidatorService.getValidatePassword(HAS_LOWER_CASE_LETTER_FALSE));
    }

    @Test
    @DisplayName("should return false when rule hasUpperCaseLetter is false")
    public void shouldReturnFalseWhenRuleHasUpperCaseLetterIsFalse(){

        assertFalse(passwordValidatorService.getValidatePassword(HAS_UPPER_CASE_LETTER_FALSE));
    }

    @Test
    @DisplayName("should return false when rule hasSpecialCharacter is false")
    public void shouldReturnFalseWhenRuleHasSpecialCharacterFalse(){

        assertFalse(passwordValidatorService.getValidatePassword(HAS_SPECIAL_CHARACTER_FALSE));
    }

    @Test
    @DisplayName("should return false when rule hasNoRepeatedCharacter is false")
    public void shouldReturnFalseWhenRuleHasNoRepeatedCharacterFalse(){

        assertFalse(passwordValidatorService.getValidatePassword(HAS_NO_REPEATED_CHARACTER_FALSE));
    }
}
