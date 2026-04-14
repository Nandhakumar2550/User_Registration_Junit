package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class UserRegistrationTest {

    User_Registration user = new User_Registration(); // create object

    // UC1
    @Test
    void testFirstName() {
        assertTrue(user.validateFirstName("Nandha")); // valid case
        assertFalse(user.validateFirstName("na")); // invalid case
    }
    // UC2
    @Test
    void testLastName() {
        assertTrue(user.validateLastName("Kumar")); // valid
        assertFalse(user.validateLastName("ku")); // invalid
    }
    // UC3
    @Test
    void testEmail() {
        assertTrue(user.validateEmail("abc.xyz@bl.co.in")); // valid email
        assertFalse(user.validateEmail("abc@.com")); // invalid email
    }
    // UC4
    @Test
    void testMobile() {
        assertTrue(user.validateMobile("91 9919819801")); // valid mobile
        assertFalse(user.validateMobile("919919819801")); // invalid mobile
    }
    // UC5
    @Test
    void testPasswordRule1() {
        assertTrue(user.validatePasswordRule1("abcdefgh")); // valid length
        assertFalse(user.validatePasswordRule1("abc")); // invalid
    }
    // UC6
    @Test
    void testPasswordRule2() {
        assertTrue(user.validatePasswordRule2("Abcdefgh")); // has uppercase
        assertFalse(user.validatePasswordRule2("abcdefgh")); // no uppercase
    }
    // UC7
    @Test
    void testPasswordRule3() {
        assertTrue(user.validatePasswordRule3("abcd1234")); // has number
        assertFalse(user.validatePasswordRule3("abcdefgh")); // no number
    }
    // UC8
    @Test
    void testPasswordRule4() {
        assertTrue(user.validatePasswordRule4("abcde@12")); // exactly one special char
        assertFalse(user.validatePasswordRule4("abc@@123")); // invalid
    }
    // UC9
    @Test
    void testEmailSamples() {
        assertTrue(user.validateEmail("abc@yahoo.com")); // sample 1
        assertTrue(user.validateEmail("abc-100@yahoo.com")); // sample 2
        assertTrue(user.validateEmail("abc.100@yahoo.com")); // sample 3
    }

    // UC10
    @Test
    void testFullValidation() {
        assertTrue(user.validateUser(
                "Nandha", // valid first name
                "Kumar", // valid last name
                "abc.xyz@bl.co.in", // valid email
                "91 9919819801", // valid mobile
                "Abcdef1@" // valid password
        ));
    }
        // UC11
        @ParameterizedTest
        @ValueSource(strings = {
                "abc@yahoo.com",
                "abc.xyz@bl.co.in",
                "user@gmail.com"
        })
        void testMultipleEmails(String email) {
            assertTrue(user.validateEmail(email)); // validate multiple emails
        }
}