package com.github.yoruhinda.eletronicCommercer.dto.product;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductDtoResponse {
    private String product_name;
    private int product_quantity;
    private float product_price;
}
