package com.SeletivoNeki.Exception;

public class NotFoundException extends RuntimeException{

    public NotFoundException() {
    }
    public NotFoundException(String message) {
        super(message);
    }
}
