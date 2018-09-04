package com.bdzjn.udd.ebookrepository.repository;

import com.bdzjn.udd.ebookrepository.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
