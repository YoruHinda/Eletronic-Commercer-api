package com.github.yoruhinda.eletronicCommercer.exception;

public class ProductNotFoundException extends NotFoundException{
    public ProductNotFoundException() {
        super("Não foi possivel localizar o produto!");
    }
}
