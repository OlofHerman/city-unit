package com.intraservice.alpha.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(long id) {
        super("City unit with ID: " + id + " not found.");
    }
}
