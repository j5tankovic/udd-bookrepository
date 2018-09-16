package com.bdzjn.udd.ebookrepository.api;

import com.bdzjn.udd.ebookrepository.dto.CategoryDTO;
import com.bdzjn.udd.ebookrepository.dto.EBookDTO;
import com.bdzjn.udd.ebookrepository.dto.mapper.CategoryMapper;
import com.bdzjn.udd.ebookrepository.dto.mapper.EBookMapper;
import com.bdzjn.udd.ebookrepository.model.Category;
import com.bdzjn.udd.ebookrepository.model.EBook;
import com.bdzjn.udd.ebookrepository.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/categories")
@CrossOrigin("http://localhost:8081")
public class CategoryApi {

    private CategoryService categoryService;

    private EBookMapper eBookMapper;

    @Autowired
    public CategoryApi(CategoryService categoryService,
                       EBookMapper eBookMapper) {
        this.categoryService = categoryService;
        this.eBookMapper = eBookMapper;
    }

    @GetMapping("")
    public ResponseEntity getCategories() {
        List<Category> categories = categoryService.findAll();
        List<CategoryDTO> categoryDTOList = categories
                .stream()
                .map(CategoryMapper::toDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(categoryDTOList, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity addCategory(@RequestBody CategoryDTO categoryDTO) {
        Category category = CategoryMapper.toModel(categoryDTO);
        category = categoryService.save(category);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity updateCategory(@RequestBody CategoryDTO categoryDTO) {
        Category category = CategoryMapper.toModel(categoryDTO);
        category = categoryService.save(category);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @GetMapping("{id}/books")
    public ResponseEntity getBooks(@PathVariable long id) {
        List<EBook> eBookList = categoryService.getBooks(id);
        List<EBookDTO> eBookDTOList = eBookList.stream().map(eBookMapper::toEBookDTO)
                .collect(Collectors.toList());

        return new ResponseEntity<>(eBookDTOList, HttpStatus.OK);
    }
}
