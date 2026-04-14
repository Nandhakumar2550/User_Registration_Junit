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
    // UC5
    public boolean validatePasswordRule1(String password) {
        String regex = "^.{8,}$"; // minimum 8 characters
        return Pattern.matches(regex, password); // validate length
    }
    // UC6
    public boolean validatePasswordRule2(String password) {
        String regex = "^(?=.*[A-Z]).{8,}$"; // at least 1 uppercase letter
        return Pattern.matches(regex, password); // validate uppercase
    }
    // UC7
    public boolean validatePasswordRule3(String password) {
        String regex = "^(?=.*[0-9]).{8,}$"; // at least 1 number
        return Pattern.matches(regex, password); // validate numeric
    }
    // UC8
    public boolean validatePasswordRule4(String password) {
        String regex = "^(?=[^@#$%^&+=!]*[@#$%^&+=!][^@#$%^&+=!]*$).{8,}$"; // exactly 1 special char
        return Pattern.matches(regex, password); // validate special character rule
    }
    // UC10 (FULL VALIDATION)
    public boolean validateUser(String firstName, String lastName, String email, String mobile, String password) {

        boolean first = validateFirstName(firstName); // call first name validation
        boolean last = validateLastName(lastName); // call last name validation
        boolean mail = validateEmail(email); // call email validation
        boolean mob = validateMobile(mobile); // call mobile validation

        boolean pass = validatePasswordRule1(password) && // check rule1
                validatePasswordRule2(password) && // check rule2
                validatePasswordRule3(password) && // check rule3
                validatePasswordRule4(password);   // check rule4

        return first && last && mail && mob && pass; // return true only if all validations pass
    }




    // UC12 - First Name Validation
    public boolean validateFirstNames(String firstName) throws UserRegistrationException {

        String regex = "^[A-Z][a-zA-Z]{2,}$"; // define rule for first name

        if (Pattern.matches(regex, firstName)) { // check if input matches regex
            return true; // return true if valid
        } else {
            throw new UserRegistrationException(
                    UserRegistrationException.ExceptionType.INVALID_FIRST_NAME, // set error type
                    "Invalid First Name" // error message
            ); // throw exception if invalid
        }
    }

    // Last Name Validation
    public boolean validateLastNames(String lastName) throws UserRegistrationException {

        String regex = "^[A-Z][a-zA-Z]{2,}$"; // define rule

        if (Pattern.matches(regex, lastName)) { // validate last name
            return true; // valid
        } else {
            throw new UserRegistrationException(
                    UserRegistrationException.ExceptionType.INVALID_LAST_NAME,
                    "Invalid Last Name"
            ); // throw exception
        }
    }

    // Email Validation
    public boolean validateEmails(String email) throws UserRegistrationException {

        String regex = "^[a-zA-Z0-9]+([._+-]?[a-zA-Z0-9]+)*@[a-zA-Z0-9]+\\.[a-zA-Z]{2,}(\\.[a-zA-Z]{2,})?$";

        if (Pattern.matches(regex, email)) { // validate email
            return true;
        } else {
            throw new UserRegistrationException(
                    UserRegistrationException.ExceptionType.INVALID_EMAIL,
                    "Invalid Email"
            ); // throw exception
        }
    }

    // Mobile Validation
    public boolean validateMobiles(String mobile) throws UserRegistrationException {

        String regex = "^[0-9]{2} [0-9]{10}$"; // define rule

        if (Pattern.matches(regex, mobile)) { // validate mobile
            return true;
        } else {
            throw new UserRegistrationException(
                    UserRegistrationException.ExceptionType.INVALID_MOBILE,
                    "Invalid Mobile"
            ); // throw exception
        }
    }

    // Password Validation (All rules combined)
    public boolean validatePassword(String password) throws UserRegistrationException {

        String regex = "^(?=.*[A-Z])(?=.*[0-9])(?=[^@#$%^&+=!]*[@#$%^&+=!][^@#$%^&+=!]*$).{8,}$";

        if (Pattern.matches(regex, password)) { // validate password
            return true;
        } else {
            throw new UserRegistrationException(
                    UserRegistrationException.ExceptionType.INVALID_PASSWORD,
                    "Invalid Password"
            ); // throw exception
        }
    }




    //UC13

    UserValidation firstNameValidator = (firstName) -> {
        String regex = "^[A-Z][a-zA-Z]{2,}$"; // define rule for first name
        return Pattern.matches(regex, firstName); // validate using regex
    };


    UserValidation lastNameValidator = (lastName) -> {
        String regex = "^[A-Z][a-zA-Z]{2,}$"; // define rule
        return Pattern.matches(regex, lastName); // validate last name
    };


    UserValidation emailValidator = (email) -> {
        String regex = "^[a-zA-Z0-9]+([._+-]?[a-zA-Z0-9]+)*@[a-zA-Z0-9]+\\.[a-zA-Z]{2,}(\\.[a-zA-Z]{2,})?$";
        return Pattern.matches(regex, email); // validate email
    };


    UserValidation mobileValidator = (mobile) -> {
        String regex = "^[0-9]{2} [0-9]{10}$"; // country code + space + 10 digits
        return Pattern.matches(regex, mobile); // validate mobile
    };


    UserValidation passwordValidator = (password) -> {
        String regex = "^(?=.*[A-Z])(?=.*[0-9])(?=[^@#$%^&+=!]*[@#$%^&+=!][^@#$%^&+=!]*$).{8,}$";
        return Pattern.matches(regex, password); // validate password
    };
}
