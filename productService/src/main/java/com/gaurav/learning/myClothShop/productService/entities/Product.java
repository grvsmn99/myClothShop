package com.gaurav.learning.myClothShop.productService.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name="product_table")
public class Product {

    @Id
    private String id;

    private String name;
    private String description;
    private BigDecimal price;

}
