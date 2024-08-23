package com.shivam.fistspringapi.models;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
    private Category category;

}

/*



 */