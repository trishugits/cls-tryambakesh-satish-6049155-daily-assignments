package com.example.demo.exceptions;

public class MobileNumberDoesNotExistsForEmployeeException extends RuntimeException {
    public MobileNumberDoesNotExistsForEmployeeException(String msg) {
        super(msg);
    }
}