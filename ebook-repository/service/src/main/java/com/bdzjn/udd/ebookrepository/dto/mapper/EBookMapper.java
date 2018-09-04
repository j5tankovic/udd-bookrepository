package com.bdzjn.udd.ebookrepository.dto.mapper;

import com.bdzjn.udd.ebookrepository.dto.EBookDTO;
import com.bdzjn.udd.ebookrepository.model.EBook;
import com.bdzjn.udd.ebookrepository.service.CategoryService;
import com.bdzjn.udd.ebookrepository.service.LanguageService;
import com.bdzjn.udd.ebookrepository.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EBookMapper {

    @Autowired
    UserService userService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    LanguageService languageService;

    public EBook toEBook(EBookDTO eBookDTO) {
        EBook ebook = new EBook();
        ebook.setTitle(eBookDTO.getTitle());
        ebook.setCataloguer(userService.findOne(eBookDTO.getCataloguerId()).get());
        ebook.setPublicationYear(eBookDTO.getPublicationYear());
        ebook.setFilename(eBookDTO.getFilename());
        ebook.setKeywords(eBookDTO.getKeywords());
        ebook.setAuthor(eBookDTO.getAuthor());
        ebook.setCategory(categoryService.findById(eBookDTO.getCategoryId()));
        ebook.setLanguage(languageService.findById(eBookDTO.getLanguageId()));
        ebook.setMimeType(eBookDTO.getMimeType());

        return ebook;
    }

    public EBookDTO toEBookDTO(EBook eBook) {
        EBookDTO eBookDTO = new EBookDTO();
        eBookDTO.setAuthor(eBook.getAuthor());
        eBookDTO.setKeywords(eBook.getKeywords());
        eBookDTO.setTitle(eBook.getTitle());
        eBookDTO.setPublicationYear(eBook.getPublicationYear());
        eBookDTO.setId(eBook.getId());
        eBookDTO.setMimeType(eBook.getMimeType());

        return eBookDTO;
    }
}
