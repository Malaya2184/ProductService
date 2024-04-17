package com.spider.productservice.repositories;

import com.spider.productservice.models.SelfCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<SelfCategory,Long> {
    SelfCategory save(SelfCategory selfCategory);
    void deleteById(Long id);
//    lazy fetching of category and no product fetching
//    because product in category is in collection so by dfault it is lazy fetch
//    check testCategoryRepoQueries
    Optional<SelfCategory> findById(Long id);
}
