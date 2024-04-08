package com.spider.productservice.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;
import org.hibernate.annotations.Cascade;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "products")
public class SelfProduct extends BaseModel {
//    @Id
//    private long id;
    private String title;
    private double price;
    @ManyToOne(cascade = CascadeType.ALL)
    private SelfCategory category;
    private String description;
    private String image;
}
