package org.example;

import org.junit.jupiter.api.Test;
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

}