package com.spider.productservice.models;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "dummmy_table")
public class DummyTableToCheckSchemaMigration extends BaseModel {

    private String dummyTitle;
}
