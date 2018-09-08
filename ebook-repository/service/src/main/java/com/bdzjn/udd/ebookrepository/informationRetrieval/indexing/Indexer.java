package com.bdzjn.udd.ebookrepository.informationRetrieval.indexing;

import com.bdzjn.udd.ebookrepository.informationRetrieval.model.IREBook;
import com.bdzjn.udd.ebookrepository.informationRetrieval.repository.IREBookRepository;
import org.springframework.stereotype.Service;

@Service
public class Indexer {

    private IREBookRepository ireBookRepository;

    public Indexer(IREBookRepository ireBookRepository) {
        this.ireBookRepository = ireBookRepository;
    }

    public IREBook add(IREBook ebook) {
        return ireBookRepository.index(ebook);
    }

    public IREBook update(IREBook ebook) {
        return ireBookRepository.save(ebook);
    }

    public void delete(IREBook ebook) {
        ireBookRepository.delete(ebook);
    }
}
