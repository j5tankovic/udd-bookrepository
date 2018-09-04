package com.bdzjn.udd.ebookrepository.service;

import com.bdzjn.udd.ebookrepository.model.Language;
import com.bdzjn.udd.ebookrepository.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageService {

    @Autowired
    LanguageRepository languageRepository;

    public Language findById(long id) {
        return languageRepository.findById(id).get();
    }

    public List<Language> findAll() {
        return languageRepository.findAll();
    }
}
