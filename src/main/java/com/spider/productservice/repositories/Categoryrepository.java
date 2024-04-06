package com.spider.productservice.repositories;

import com.spider.productservice.models.SelfCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Categoryrepository extends JpaRepository<SelfCategory,Long> {
    SelfCategory save(SelfCategory selfCategory);
}
