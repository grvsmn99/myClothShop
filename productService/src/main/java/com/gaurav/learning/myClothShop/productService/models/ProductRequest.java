package com.gaurav.learning.myClothShop.productService.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductRequest {

    private String name;
    private String description;
    private BigDecimal price;
}
