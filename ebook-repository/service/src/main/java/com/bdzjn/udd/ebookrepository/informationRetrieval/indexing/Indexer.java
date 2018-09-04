package com.bdzjn.udd.ebookrepository.informationRetrieval.indexing;

import com.bdzjn.udd.ebookrepository.informationRetrieval.model.IREBook;
import com.bdzjn.udd.ebookrepository.informationRetrieval.repository.IREBookRepository;
import org.springframework.stereotype.Service;

@Service
public class Indexer {

    private IREBookRepository IREBookRepository;

    public Indexer(IREBookRepository IREBookRepository) {
        this.IREBookRepository = IREBookRepository;
    }

    //TODO probably need to change this
    public IREBook add(IREBook ebook) {
        return IREBookRepository.index(ebook);
    }

    public IREBook update(IREBook ebook) {
        return IREBookRepository.save(ebook);
    }

    public void delete(IREBook ebook) {
        if (IREBookRepository.equals(ebook)) {
            IREBookRepository.delete(ebook);
        }
    }

    public void index() {
        //TODO implement
    }
}
