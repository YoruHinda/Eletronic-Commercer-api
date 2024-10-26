package com.github.yoruhinda.eletronicCommercer.dto.product;

import com.github.yoruhinda.eletronicCommercer.models.product.Product;
import jakarta.validation.constraints.*;
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
    @NotNull
    @Min(0)
    private Integer product_quantity;
    @NotNull
    @Min(0)
    private Float product_price;
    private String product_image_name;

    public Product toModel() {
        return new Product(id, product_name, product_description, product_quantity, product_price, product_image_name);
    }
}
