package com.github.yoruhinda.eletronicCommercer.domain.entity.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductImage {
    private String product_image_name;
    private byte[] image;
}
