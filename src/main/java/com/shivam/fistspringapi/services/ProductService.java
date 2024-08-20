package com.shivam.fistspringapi.services;

import com.shivam.fistspringapi.models.Product;

import java.util.List;



public interface ProductService {
    Product getProductById(Long id);

    List<Product> getAllProducts();

    Product replaceProduct(Long id,Product product);
}
