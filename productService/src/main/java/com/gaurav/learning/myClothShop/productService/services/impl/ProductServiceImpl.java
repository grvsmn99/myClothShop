package com.gaurav.learning.myClothShop.productService.services.impl;

import com.gaurav.learning.myClothShop.productService.entities.Product;
import com.gaurav.learning.myClothShop.productService.exceptions.ResourceNotFoundException;
import com.gaurav.learning.myClothShop.productService.models.ProductRequest;
import com.gaurav.learning.myClothShop.productService.models.ProductResponse;
import com.gaurav.learning.myClothShop.productService.repository.ProductRepository;
import com.gaurav.learning.myClothShop.productService.services.ProductService;
import com.gaurav.learning.myClothShop.productService.utils.ProductUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;

    @Override
    public ProductResponse addProduct(ProductRequest productRequest) {
        Product product = ProductUtil.mapProductRequestToProduct(productRequest);

        product.setId(UUID.randomUUID().toString());
        log.debug("product = "+product);
        Product productResponse = repository.save(product);
        log.info("Product add successfully...");
        log.debug("productResponse = "+productResponse);
        return ProductUtil.mapProductToProductResponse(productResponse);
    }

    @Override
    public ProductResponse getProduct(String id) {
        log.debug("User Id = "+id);
        Product response = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product Not Found with id:"+id));
        log.info("product fetched = "+response.toString());
        return ProductUtil.mapProductToProductResponse(response);
    }

    @Override
    public List<ProductResponse> getProducts() {
        List<ProductResponse> response = repository.findAll()
                .stream()
                .map(ProductUtil::mapProductToProductResponse)
                .collect(Collectors.toList());
        log.info("List of products fetched successfully");
        return response;
    }
}
