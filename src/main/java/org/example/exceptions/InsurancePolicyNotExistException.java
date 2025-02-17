package org.example.exceptions;

public class InsurancePolicyNotExistException extends RuntimeException {

    private final String message;

    public InsurancePolicyNotExistException(Integer id) {
        this.message = "No Insurance Policy With id " + id;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
