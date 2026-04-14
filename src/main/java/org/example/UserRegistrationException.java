package org.example;

import java.util.regex.Pattern;

// custom exception class
public class UserRegistrationException extends Exception {

    // enum to identify type of error
    public enum ExceptionType {
        INVALID_FIRST_NAME,
        INVALID_LAST_NAME,
        INVALID_EMAIL,
        INVALID_MOBILE,
        INVALID_PASSWORD
    }

    ExceptionType type; // store error type

    public UserRegistrationException(ExceptionType type, String message) {
        super(message); // pass message to Exception class
        this.type = type; // assign type
    }
    // UC12 - First Name with Exception
    public boolean validateFirstName(String firstName) throws UserRegistrationException {

        String regex = "^[A-Z][a-zA-Z]{2,}$"; // rule

        if (Pattern.matches(regex, firstName)) {
            return true; // valid
        } else {
            throw new UserRegistrationException(
                    UserRegistrationException.ExceptionType.INVALID_FIRST_NAME,
                    "Invalid First Name"
            ); // throw exception
        }
    }
}