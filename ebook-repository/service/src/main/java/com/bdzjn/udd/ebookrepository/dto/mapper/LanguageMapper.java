package com.bdzjn.udd.ebookrepository.dto.mapper;

import com.bdzjn.udd.ebookrepository.dto.LanguageDTO;
import com.bdzjn.udd.ebookrepository.model.Language;

public class LanguageMapper {

    public static LanguageDTO toDTO(Language language) {
        LanguageDTO languageDTO = new LanguageDTO();
        languageDTO.setId(language.getId());
        languageDTO.setName(language.getName());

        return languageDTO;
    }
}
