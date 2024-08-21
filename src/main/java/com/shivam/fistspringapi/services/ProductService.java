package com.shivam.fistspringapi.services;

import com.shivam.fistspringapi.exceptions.ProductNotFoundException;
import com.shivam.fistspringapi.models.Product;

import java.util.List;



public interface ProductService {
    Product getProductById(Long id) throws ProductNotFoundException;

    List<Product> getAllProducts();

    Product replaceProduct(Long id,Product product);
}
