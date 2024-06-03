package com.integratedserver.errors;

public class InvalidApiRoute extends Exception {
    // Default constructor
    public InvalidApiRoute() {
        super();
    }

    // Constructor that accepts a message
    public InvalidApiRoute(String message) {
        super(message);
    }

    // Constructor that accepts a message and a cause
    public InvalidApiRoute(String message, Throwable cause) {
        super(message, cause);
    }

    // Constructor that accepts a cause
    public InvalidApiRoute(Throwable cause) {
        super(cause);
    }
}
