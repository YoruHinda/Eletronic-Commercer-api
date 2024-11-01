package com.github.yoruhinda.eletronicCommercer.exception;

public class UserNotFoundException extends NotFoundException{

    public UserNotFoundException() {
        super("Não foi possivel localizar o usuario!");
    }
}
