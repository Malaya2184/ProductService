package com.spider.productservice.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
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
//    @ManyToOne(cascade = CascadeType.ALL)
    @ManyToOne(cascade = CascadeType.PERSIST) // only save cascade
//    @JsonBackReference
    private SelfCategory category;
    private String description;
    private String image;
}
