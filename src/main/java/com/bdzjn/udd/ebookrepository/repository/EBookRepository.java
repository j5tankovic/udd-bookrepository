package com.bdzjn.udd.ebookrepository.repository;

import com.bdzjn.udd.ebookrepository.model.EBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EBookRepository extends JpaRepository<EBook, Long> {
}
