package com.bdzjn.udd.ebookrepository.repository;

import com.bdzjn.udd.ebookrepository.model.EBook;
import com.bdzjn.udd.ebookrepository.service.EBookService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EBookRepository extends JpaRepository<EBook, Long> {

    @Query("select b from EBook b join b.category c where c.id = :id")
    List<EBook> getBooks(@Param("id") long id);
}
