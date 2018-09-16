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

    public EBook toEBook(EBookDTO eBookDTO) {
        EBook ebook = new EBook();
        ebook.setId(eBookDTO.getId());
        ebook.setTitle(eBookDTO.getTitle());
        ebook.setCataloguer(userService.findOne(eBookDTO.getCataloguerId()).get());
        ebook.setPublicationYear(eBookDTO.getPublicationYear());
        ebook.setFilename(eBookDTO.getFilename());
        ebook.setKeywords(eBookDTO.getKeywords());
        ebook.setAuthor(eBookDTO.getAuthor());
        ebook.setCategory(eBookDTO.getCategory());
        ebook.setLanguage(eBookDTO.getLanguage());
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
        eBookDTO.setFilename(eBook.getFilename());
        eBookDTO.setCategory(eBook.getCategory());
        eBookDTO.setLanguage(eBook.getLanguage());

        return eBookDTO;
    }
}
