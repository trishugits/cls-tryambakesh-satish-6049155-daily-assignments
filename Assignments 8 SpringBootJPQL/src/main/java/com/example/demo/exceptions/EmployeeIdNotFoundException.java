package com.example.demo.exceptions;

@SuppressWarnings("serial")
public class EmployeeIdNotFoundException 
        extends RuntimeException{

    public EmployeeIdNotFoundException(String msg){
        super(msg);
    }
}