package com.addmission.server.exception;

public class ResourceNotFoundException extends Exception {
    public ResourceNotFoundException(String resource) {
        super(resource + " Not Found!");
    }
}
