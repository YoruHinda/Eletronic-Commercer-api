package com.github.yoruhinda.eletronicCommercer.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long product_id;
    @Column
    private String product_name;
    @Column
    private int product_quantity;
    @Column
    private float product_price;
}
