package com.shivam.fistspringapi.models;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Entity;


@Getter
@Setter
@Entity
public class Category {
    @Id
    private int id;
    private String desc;
}
