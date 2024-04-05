package com.spider.productservice.inheritance_representation.joined_table;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "jt_tas")
@PrimaryKeyJoinColumn(name = "userId")
public class Ta extends User {
    private int numberOfSessions;
    private double avgrating;
}
