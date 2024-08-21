package com.shivam.fistspringapi.controllers;


import com.shivam.fistspringapi.exceptions.ProductNotFoundException;
import com.shivam.fistspringapi.models.Product;
import com.shivam.fistspringapi.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

//localhost:8080/products
@RestController //This controller is going to REST HTTP API's
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //localhost:8080/products/1
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) throws ProductNotFoundException{
        Product product= productService.getProductById(id);
        ResponseEntity<Product> responseEntity;
        if(product==null){
            responseEntity=new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            return responseEntity;
        }
        responseEntity=new ResponseEntity<>(product, HttpStatus.OK);
        return responseEntity;

    }

    // localhost:8080/products
    @GetMapping()
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    //createProduct
    //deleteProduct
    //updateProduct -> Partial Update (PATCH)
    //replaceProduct -> Replace (PUT)

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long id, @RequestBody Product product) {
    return productService.replaceProduct(id,product);
    }
}