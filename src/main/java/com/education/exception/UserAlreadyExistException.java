package com.education.exception;

public class UserAlreadyExistException extends RuntimeException {
    public UserAlreadyExistException(){
        super("Username is already exist");
    }
}
