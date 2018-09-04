package com.bdzjn.udd.ebookrepository.informationRetrieval.repository;

import com.bdzjn.udd.ebookrepository.informationRetrieval.model.IREBook;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IREBookRepository extends ElasticsearchRepository<IREBook, String> {
}
