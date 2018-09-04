package com.bdzjn.udd.ebookrepository.api;

import com.bdzjn.udd.ebookrepository.dto.LanguageDTO;
import com.bdzjn.udd.ebookrepository.dto.mapper.LanguageMapper;
import com.bdzjn.udd.ebookrepository.model.Language;
import com.bdzjn.udd.ebookrepository.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/languages")
@CrossOrigin("http://localhost:8081")
public class LanguageApi {

    @Autowired
    LanguageService languageService;

    @GetMapping("")
    public ResponseEntity getAll(){
        List<Language> languageList = languageService.findAll();
        List<LanguageDTO> languageDTOList = languageList
                .stream()
                .map(LanguageMapper::toDTO)
                .collect(Collectors.toList());

        return new ResponseEntity<>(languageDTOList, HttpStatus.OK);
    }
}
