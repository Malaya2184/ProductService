package com.spider.productservice.models;

import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FakeStoreProduct {
    private long id;
    private String title;
    private double price;
    private FakeStoreCategory fakeStoreCategory;
    private String description;
    private String image;
}
