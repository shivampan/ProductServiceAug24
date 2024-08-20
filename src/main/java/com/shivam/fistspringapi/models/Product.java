package com.shivam.fistspringapi.models;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private long id;
    private String description;
    private String title;
    private double price;
    private String image;
    private Category category;

}
