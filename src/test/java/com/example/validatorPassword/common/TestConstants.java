package com.example.validatorPassword.common;

import lombok.Getter;

@Getter
public class TestConstants {

    public static final String RULES_TRUE = "AbTp9!fok";

    public static final String HAS_MINIMUM_LENGTH_FALSE = "a8J#";

    public static final String HAS_DIGIT_NUMBER_FALSE = "AbTpl!fok";

    public static final String HAS_LOWER_CASE_LETTER_FALSE = "ABTP9!FOK";

    public static final String HAS_UPPER_CASE_LETTER_FALSE = "abtp9!fok";

    public static final String HAS_SPECIAL_CHARACTER_FALSE = "aBtplg1fok";

    public static final String HAS_NO_REPEATED_CHARACTER_FALSE = "AaTp9!fok";

}
