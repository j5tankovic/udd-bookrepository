package com.bdzjn.udd.ebookrepository.repository;

import com.bdzjn.udd.ebookrepository.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Long> {
}
