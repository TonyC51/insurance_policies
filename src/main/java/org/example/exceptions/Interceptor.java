package org.example.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class Interceptor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value
            = {InsurancePolicyNotExistException.class})
    public ResponseEntity<Object> handleNotExistingInsurancePolicy(
            InsurancePolicyNotExistException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
