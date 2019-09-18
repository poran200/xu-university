package com.seu.athorization.exception;

public class ResourseNotFoundException extends Exception {
    public ResourseNotFoundException(String message) {
        super(message+"not found !");
    }
}
