package com.example.validatorPassword.controller;

import com.example.validatorPassword.service.PasswordValidatorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoSettings;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static com.example.validatorPassword.common.TestConstants.HAS_DIGIT_NUMBER_FALSE;
import static com.example.validatorPassword.common.TestConstants.RULES_TRUE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;

@MockitoSettings
public class PasswordValidatorControllerTest {

    @Mock
    private PasswordValidatorService passwordValidatorService;

    @InjectMocks
    private PasswordValidatorController passwordValidatorController;

    @BeforeEach
    public void setUp() {
        reset(passwordValidatorService);
    }

    @Test
    @DisplayName("should return ok and true when have params and all rules is true")
    public void getValidatePasswordShouldReturnOkAndTrue(){
        when(passwordValidatorService.getValidatePassword(any())).thenReturn(true);

        var response = passwordValidatorController.getValidatePassword(RULES_TRUE);
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(true, response.getBody());
    }
    @Test
    @DisplayName("should return ok and false when have params and all rules is true")
    public void getValidatePasswordShouldReturnOkAndFalse(){
        when(passwordValidatorService.getValidatePassword(any())).thenReturn(false);

        var response = passwordValidatorController.getValidatePassword(HAS_DIGIT_NUMBER_FALSE);
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(false, response.getBody());
    }

    @Test
    @DisplayName("should return error when input is null")
    public void getValidatePasswordShouldReturnError() {
        when(passwordValidatorService.getValidatePassword(any())).thenReturn(null);

        var response = passwordValidatorController.getValidatePassword(null);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(false, response.getBody());
    }

}
