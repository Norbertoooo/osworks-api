package com.spring.osworks.api.exceptionHandler;

public class DomainException extends RuntimeException{

    public DomainException(String message){
        super(message);
    }
}
