package com.nvooaj.apptarea.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TareaException extends RuntimeException{
    public TareaException(String message) { super(message);}
}
