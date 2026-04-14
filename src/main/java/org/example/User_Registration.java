package org.example;

import java.util.regex.Pattern;

public class User_Registration {

    // UC1
    public boolean validateFirstName(String firstName) {
        String regex = "^[A-Z][a-zA-Z]{2,}$"; // define rule: first letter capital + min 3 chars
        return Pattern.matches(regex, firstName); // check if input matches rule and return result
    }
    // UC2
    public boolean validateLastName(String lastName) {
        String regex = "^[A-Z][a-zA-Z]{2,}$"; // define same rule for last name
        return Pattern.matches(regex, lastName); // validate last name using regex
    }
}