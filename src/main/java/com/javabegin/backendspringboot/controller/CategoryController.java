package com.javabegin.backendspringboot.controller;

import com.javabegin.backendspringboot.entity.Category;
import com.javabegin.backendspringboot.search.CategorySearchValues;
import com.javabegin.backendspringboot.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/category")
@Api(tags = "Category", description = "CategoryController")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(final CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/all")
    @ApiOperation(value = "Получить список всех значений из базы")
    public List<Category> findAll() {
        return categoryService.findAllByOrderByTitleAsc();
    }

    @PostMapping("/add")
    @ApiOperation(value = "Добавить данные")
    public ResponseEntity<Category> add(@RequestBody Category category) {
        if (category.getId() != null && category.getId() != 0) {
            return new ResponseEntity("redundant param: id MUST be null", HttpStatus.NOT_ACCEPTABLE);
        }
        if (category.getTitle() != null || category.getTitle().trim().length() == 0) {
            return new ResponseEntity("missed param: title", HttpStatus.NOT_ACCEPTABLE);
        }
        return ResponseEntity.ok(categoryService.add(category));
    }

    @PutMapping("put")
    @ApiOperation(value = "Обновить данные")
    public ResponseEntity<Category> update(@RequestBody Category category) {
        if (category.getId() != null || category.getId() == 0) {
            return new ResponseEntity("redundant param: id MUST be null", HttpStatus.NOT_ACCEPTABLE);
        }
        if (category.getTitle() != null || category.getTitle().trim().length() == 0) {
            return new ResponseEntity("missed param: title", HttpStatus.NOT_ACCEPTABLE);
        }
        return ResponseEntity.ok(categoryService.add(category));
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "Удалить данные")
    public ResponseEntity delete(@PathVariable Long id) {
        try {
            categoryService.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
            return new ResponseEntity("id=" + id + " not found", HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    @ApiOperation(value = "Получить значение по ID")
    public ResponseEntity<Category> findById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(categoryService.findById(id));
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return new ResponseEntity("id=" + id + " not found", HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PostMapping("/search")
    @ApiOperation(value = "Поиск по любым параметрам",response = CategorySearchValues.class)
    public ResponseEntity<List<Category>> search(CategorySearchValues categorySearchValues) {
        return ResponseEntity.ok(categoryService.findByTitle(categorySearchValues.getText()));
    }

}
