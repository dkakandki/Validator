package com.example.Validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SuppressWarnings("InstantiationOfUtilityClass")
@SpringBootTest
class ValidatorTests {

    Validator validator;

    @BeforeEach
    void setup() {
        validator = new Validator();
    }

    @Test
    void PhoneNumberValidation() {
        Assertions.assertTrue(Validator.isPhoneNumberValid("0123456789"));
        Assertions.assertTrue(Validator.isPhoneNumberValid("0123456"));
        Assertions.assertTrue(Validator.isPhoneNumberValid("012345"));
        Assertions.assertFalse(Validator.isPhoneNumberValid("01234567891")); // phone number too long
        Assertions.assertFalse(Validator.isPhoneNumberValid("1234567891")); // Doesn't start with 0
        Assertions.assertFalse(Validator.isPhoneNumberValid("01234")); // phone number too short
        Assertions.assertFalse(Validator.isPhoneNumberValid("01a234")); // phone number contains non numerical value
        Assertions.assertFalse(Validator.isPhoneNumberValid("")); // empty string
    }

    @Test
    void EmailValidation() {
        Assertions.assertTrue(Validator.isEmailValid("validator@example.com"));
        Assertions.assertTrue(Validator.isEmailValid("validator@subdomain.example.co.se"));
        Assertions.assertFalse(Validator.isEmailValid("validator@example")); // Missing Top Level Domain
        Assertions.assertFalse(Validator.isEmailValid("validator_example.com")); // Missing '@' character
        Assertions.assertFalse(Validator.isEmailValid("validator@.com")); //Missing Domain Name
        Assertions.assertFalse(Validator.isEmailValid("validator@.com")); //Multiple '@' Characters
        Assertions.assertFalse(Validator.isEmailValid("")); //empty string
    }
}
