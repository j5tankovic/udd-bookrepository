package com.bdzjn.udd.ebookrepository.dto.mapper;

import com.bdzjn.udd.ebookrepository.dto.CategoryDTO;
import com.bdzjn.udd.ebookrepository.model.Category;

public class CategoryMapper {

    public static CategoryDTO toDTO(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getName());

        return categoryDTO;
    }

    public static Category toModel(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setName(categoryDTO.getName());

        return category;
    }
}
