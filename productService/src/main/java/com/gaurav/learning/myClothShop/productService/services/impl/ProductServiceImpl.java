package com.gaurav.learning.myClothShop.productService.services.impl;

import com.gaurav.learning.myClothShop.productService.entities.Product;
import com.gaurav.learning.myClothShop.productService.exceptions.ResourceNotFoundException;
import com.gaurav.learning.myClothShop.productService.models.ProductRequest;
import com.gaurav.learning.myClothShop.productService.models.ProductResponse;
import com.gaurav.learning.myClothShop.productService.repository.ProductRepository;
import com.gaurav.learning.myClothShop.productService.services.ProductService;
import com.gaurav.learning.myClothShop.productService.utils.ProductUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    private Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    private ProductRepository repository;

    @Override
    public ProductResponse addProduct(ProductRequest productRequest) {
        Product product = ProductUtil.mapProductRequestToProduct(productRequest);

        product.setId(UUID.randomUUID().toString());
        logger.info("product = "+product.toString());
        Product productResponse = repository.save(product);
        logger.info("productResponse = "+productResponse.toString());
        return ProductUtil.mapProductToProductResponse(productResponse);
    }

    @Override
    public ProductResponse getProduct(String id) {
        logger.info("User Id = "+id);
        Product response = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product Not Found with id:"+id));
        logger.info("product fetch = "+response.toString());
        return ProductUtil.mapProductToProductResponse(response);
    }

    @Override
    public List<ProductResponse> getProducts() {
        List<ProductResponse> response = repository.findAll()
                .stream()
                .map(product -> ProductUtil.mapProductToProductResponse(product))
                .collect(Collectors.toList());
        return response;
    }
}
