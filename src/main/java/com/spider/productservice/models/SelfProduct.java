package com.spider.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "products")
public class SelfProduct extends BaseModel {
//    @Id
//    private long id;
    private String title;
    private double price;
    @ManyToOne
    private SelfCategory category;
    private String description;
    private String image;
}
