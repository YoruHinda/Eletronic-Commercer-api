package com.github.yoruhinda.eletronicCommercer.domain.entity.product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "product")
@Entity(name = "product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "product_name")
    private String product_name;
    @Column(name = "product_description")
    private String product_description;
    @Column(name = "product_quantity")
    private Integer product_quantity;
    @Column(name = "product_price")
    private Float product_price;
    @Column(name = "product_image_name")
    private String product_image_name;
}
