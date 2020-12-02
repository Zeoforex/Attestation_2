package com.dibirov.dibirov.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND) //404 ошибка
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message){
        super(message);
        /*
        конструктор с ошибкой
         */
    }
    public ResourceNotFoundException(String message, Throwable cause){
        super(message,cause);
    }


}
