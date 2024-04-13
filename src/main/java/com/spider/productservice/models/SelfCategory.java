package com.spider.productservice.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.*;
import org.hibernate.annotations.Cascade;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "categories")
public class SelfCategory extends BaseModel {
//    @Id
//    private Long id;
    // I have mentioned mapped by so that it will not create anathor tabl for mapping
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "category",cascade = CascadeType.REMOVE)
//    @JsonBackReference
    List<SelfProduct> products;
    private String title;
}
