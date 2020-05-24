package com.javabegin.backendspringboot.controller;

import com.javabegin.backendspringboot.entity.Category;
import com.javabegin.backendspringboot.entity.Priority;
import com.javabegin.backendspringboot.repository.CategoryRepository;
import com.javabegin.backendspringboot.repository.PriorityRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryRepository categoryRepository;

    public CategoryController(final CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/test2")
    public List<Category> test() {
        return categoryRepository.findAll();
    }
}
