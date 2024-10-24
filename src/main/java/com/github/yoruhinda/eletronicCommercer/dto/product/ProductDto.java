package com.github.yoruhinda.eletronicCommercer.dto.product;

import com.github.yoruhinda.eletronicCommercer.models.product.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductDto {
    private Long id;
    @NotBlank
    private String product_name;
    @NotBlank
    private String product_description;
    @NotEmpty
    private int product_quantity;
    @NotEmpty
    private float product_price;

    public Product toModel() {
        return new Product(id, product_name, product_description, product_quantity, product_price);
    }
}
