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
    // UC3
    public boolean validateEmail(String email) {
        String regex = "^[a-zA-Z0-9]+([._+-]?[a-zA-Z0-9]+)*@[a-zA-Z0-9]+\\.[a-zA-Z]{2,}(\\.[a-zA-Z]{2,})?$";
        return Pattern.matches(regex, email); // check email format
    }
    // UC4
    public boolean validateMobile(String mobile) {
        String regex = "^[0-9]{2} [0-9]{10}$"; // country code + space + 10 digits
        return Pattern.matches(regex, mobile); // validate mobile number
    }
}