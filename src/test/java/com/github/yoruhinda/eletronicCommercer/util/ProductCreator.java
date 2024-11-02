package com.github.yoruhinda.eletronicCommercer.util;

import com.github.yoruhinda.eletronicCommercer.domain.dto.product.ProductDto;

public class ProductCreator {
    public static ProductDto createProduct(){
        return ProductDto.builder()
                .product_name("Video Card RTX 4090 TI 6GB")
                .product_description("Video Card RTX")
                .product_quantity(10)
                .product_price(1999.90f)
                .product_image_name("rtx.jpg")
                .build();
    }

    public static ProductDto createValidProduct(){
        return ProductDto.builder()
                .id(1L)
                .product_name("Video Card RTX 4090 TI 6GB")
                .product_description("Video Card RTX")
                .product_quantity(10)
                .product_price(1999.90f)
                .product_image_name("rtx.jpg")
                .build();
    }

    public static ProductDto createUpdatedProduct(){
        return ProductDto.builder()
                .id(1L)
                .product_name("Video Card RTX 4090 TI 16GB")
                .product_description("Video Card RTX 16GB")
                .product_quantity(5)
                .product_price(1999.90f)
                .product_image_name("rtx.jpg")
                .build();
    }
}
