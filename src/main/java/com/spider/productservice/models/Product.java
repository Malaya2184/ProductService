package com.spider.productservice.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private long id;
    private String title;
    private double price;
    private Category category;
    private String description;
    private String image;
}
