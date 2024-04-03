package com.spider.productservice.inheritance_representation.joined_table;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "jt_instructors")
public class Instructor extends User {
    private String speciallization;
}
