package com.spider.productservice.repositories;

import com.spider.productservice.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Categoryrepository extends JpaRepository<Category,Long> {
    Category save(Category category);
}
