package com.github.yoruhinda.eletronicCommercer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductDto {
    private String product_name;
    private int product_quantity;
    private float product_price;
}
