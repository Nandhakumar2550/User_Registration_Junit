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
}