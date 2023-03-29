package com.gaurav.learning.myClothShop.productService.exceptions;

public class ResourceNotFoundException extends RuntimeException {


    public ResourceNotFoundException(String s) {
        super(s);
    }

    public ResourceNotFoundException(){
        super("Resource Not Found On Server!!!");
    }
}
