package com.undal.todoserver.service;

import com.undal.todoserver.exceptions.CategoryNotFoundException;
import com.undal.todoserver.model.Category;
import com.undal.todoserver.model.Todo;
import com.undal.todoserver.repo.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category addCategory(Category category){
        category.setId(java.util.UUID.randomUUID().toString());
        return categoryRepository.save(category);
    }

    public List<Category> findAllCategories(){
        return categoryRepository.findAll();
    }

    public Category updateCategory(Category category){
        return categoryRepository.save(category);
    }

    public void deleteCategory(String id){
        categoryRepository.deleteCategoryById(id);
    }

    public Category findCategoryById(String id){
        return categoryRepository.findCategoryById(id)
                .orElseThrow(()-> new CategoryNotFoundException("Category by id " + id + " was not found"));
    }


}
