package org.example;

// functional interface for lambda validation
@FunctionalInterface
public interface UserValidation {
    boolean validate(String input); // abstract method to validate input
}