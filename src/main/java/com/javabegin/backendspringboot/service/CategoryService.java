package com.javabegin.backendspringboot.service;

import com.javabegin.backendspringboot.entity.Category;
import com.javabegin.backendspringboot.repository.CategoryRepository;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CategoryService {

    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public List<Category> findAll() {
        return repository.findAll();
    }

    public Category add(Category category) {
        return repository.save(category);
    }

    public Category update(Category category){
        return repository.save(category);
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }

    public List<Category> findByTitle(String text){
        return repository.findByTitle(text);
    }

    public Category findById(Long id){
        return repository.findById(id).get();
    }
    public List<Category> findAllByOrderByTitleAsc(){
        return repository.findAllByOrderByTitleAsc();
    }
}
