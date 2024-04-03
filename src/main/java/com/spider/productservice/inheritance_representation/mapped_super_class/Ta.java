package com.spider.productservice.inheritance_representation.mapped_super_class;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "msc_tas")
public class Ta extends User{
    private int numberOfSessions;
    private double avgrating;
}
