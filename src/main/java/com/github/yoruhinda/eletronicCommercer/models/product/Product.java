package com.github.yoruhinda.eletronicCommercer.models.product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
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
    private int product_quantity;
    @Column(name = "product_price")
    private float product_price;
}
