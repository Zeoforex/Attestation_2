package com.dibirov.dibirov.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ParameterNotSpecifiedException extends RuntimeException {
    public void ParameterNotSpecified() {
        super();
    }

    public String  ParameterNotSpecified(String message) {
        super(message);
    }
}
