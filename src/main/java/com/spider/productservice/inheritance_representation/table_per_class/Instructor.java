package com.spider.productservice.inheritance_representation.table_per_class;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tbc_instructors")
public class Instructor extends User {
    private String speciallization;
}
