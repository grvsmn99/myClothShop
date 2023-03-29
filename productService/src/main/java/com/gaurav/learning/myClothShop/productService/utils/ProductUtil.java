package com.gaurav.learning.myClothShop.productService.utils;

import com.gaurav.learning.myClothShop.productService.entities.Product;
import com.gaurav.learning.myClothShop.productService.models.ProductRequest;
import com.gaurav.learning.myClothShop.productService.models.ProductResponse;

public class ProductUtil {

    public static Product mapProductRequestToProduct(ProductRequest productRequest) {
        return Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice()).build();
    }

    public static ProductResponse mapProductToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice()).build();
    }
}
