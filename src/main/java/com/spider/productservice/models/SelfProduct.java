package com.spider.productservice.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "products")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class SelfProduct extends BaseModel {
//    @Id
//    private long id;
    private String title;
    private double price;
//    @ManyToOne(cascade = CascadeType.ALL)
    @ManyToOne(cascade = CascadeType.PERSIST) // only save cascade
//    @JsonManagedReference
    private SelfCategory category;
    private String description;
    private String image;
}
