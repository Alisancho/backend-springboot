package com.javabegin.backendspringboot.controller;

import com.javabegin.backendspringboot.entity.Category;
import com.javabegin.backendspringboot.repository.CategoryRepository;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("add")
    public Category add(@RequestBody Category category) {
        return categoryRepository.save(category);
    }
}
