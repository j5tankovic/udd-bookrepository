package com.bdzjn.udd.ebookrepository.repository;

import com.bdzjn.udd.ebookrepository.model.Category;
import com.bdzjn.udd.ebookrepository.model.EBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
