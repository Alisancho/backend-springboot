package com.javabegin.backendspringboot.controller;

import com.javabegin.backendspringboot.entity.Priority;
import com.javabegin.backendspringboot.repository.PriorityRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/priority")
public class PriorityController {

    private final PriorityRepository priorityRepository;

    public PriorityController(final PriorityRepository priorityRepository) {
        this.priorityRepository = priorityRepository;
    }

    @GetMapping("/test")
    public List<Priority> test() {
        return priorityRepository.findAll();
    }
}
