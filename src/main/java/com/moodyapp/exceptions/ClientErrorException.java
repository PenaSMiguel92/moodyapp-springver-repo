package com.moodyapp.exceptions;

public class ClientErrorException extends Exception {
    public ClientErrorException(String message) {
        super(message);
    }
}
