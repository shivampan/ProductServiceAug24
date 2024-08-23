package com.shivam.fistspringapi.models;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product {
    @Id
    private long id;
    private String description;
    private String title;
    private double price;
    private String image;
    @ManyToOne
    private Category category;

}

/*
1      ->       1
Product------category-->M:1
Many          <-      1
--------------------------
M                     1
 */