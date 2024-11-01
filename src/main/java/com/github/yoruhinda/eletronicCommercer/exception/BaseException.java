package com.github.yoruhinda.eletronicCommercer.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public abstract class BaseException extends RuntimeException{
    private final HttpStatus status;

    public BaseException(final String message, final HttpStatus status){
        super(message);
        this.status = status;
    }
}
