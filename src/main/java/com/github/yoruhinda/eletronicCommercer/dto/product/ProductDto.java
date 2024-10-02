package com.github.yoruhinda.eletronicCommercer.dto.product;

import com.github.yoruhinda.eletronicCommercer.models.product.Product;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductDto {
    private Long id;
    private String product_name;
    private int product_quantity;
    private float product_price;

    public Product toModel(){
        return new Product(id, product_name, product_quantity, product_price);
    }
}
