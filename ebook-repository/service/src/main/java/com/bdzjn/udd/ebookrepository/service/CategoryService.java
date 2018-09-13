package com.bdzjn.udd.ebookrepository.service;

import com.bdzjn.udd.ebookrepository.model.Category;
import com.bdzjn.udd.ebookrepository.model.EBook;
import com.bdzjn.udd.ebookrepository.repository.CategoryRepository;
import com.bdzjn.udd.ebookrepository.repository.EBookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    private EBookRepository eBookRepository;

    public CategoryService(CategoryRepository categoryRepository,
                           EBookRepository eBookRepository) {
        this.categoryRepository = categoryRepository;
        this.eBookRepository = eBookRepository;
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    public Category findById(long categoryId) {
        return categoryRepository.findById(categoryId).get();
    }

    public List<EBook> getBooks(long id) {
        return eBookRepository.getBooks(id);
    }
}
