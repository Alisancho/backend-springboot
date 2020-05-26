package com.javabegin.backendspringboot.controller;

import com.javabegin.backendspringboot.entity.Priority;
import com.javabegin.backendspringboot.search.PrioritySearchValues;
import com.javabegin.backendspringboot.service.PriorityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/priority")
@Api(tags = "Priority", description = "PriorityController")
public class PriorityController {

    private final PriorityService priorityService;

    public PriorityController(final PriorityService priorityService) {
        this.priorityService = priorityService;
    }

    @GetMapping("/all")
    @ApiOperation(value = "Получить список всех значений из базы")
    public List<Priority> findAll() {
        return priorityService.findAll();
    }

    @PostMapping("/add")
    @ApiOperation(value = "Добавить данные")
    public ResponseEntity<Priority> add(@RequestBody Priority priority) {
        if (priority.getId() != null && priority.getId() != 0) {
            return new ResponseEntity("redundant param: id MUST be null", HttpStatus.NOT_ACCEPTABLE);
        }
        if (priority.getTitle() != null || priority.getTitle().trim().length() == 0) {
            return new ResponseEntity("missed param: title", HttpStatus.NOT_ACCEPTABLE);
        }
        return ResponseEntity.ok(priorityService.add(priority));
    }

    @PutMapping("put")
    @ApiOperation(value = "Обновить данные", response = Priority.class)
    public ResponseEntity<Priority> update(@RequestBody Priority priority) {
        if (priority.getId() != null || priority.getId() == 0) {
            return new ResponseEntity("redundant param: id MUST be null", HttpStatus.NOT_ACCEPTABLE);
        }
        if (priority.getTitle() != null || priority.getTitle().trim().length() == 0) {
            return new ResponseEntity("missed param: title", HttpStatus.NOT_ACCEPTABLE);
        }
        if (priority.getColor() == null || priority.getColor().trim().length() == 0) {
            return new ResponseEntity("missed param: color", HttpStatus.NOT_ACCEPTABLE);
        }
        return ResponseEntity.ok(priorityService.add(priority));
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "Удалить данные", response = ResponseEntity.class)
    public ResponseEntity delete(@PathVariable Long id) {
        try {
            priorityService.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
            return new ResponseEntity("id=" + id + " not found", HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    @ApiOperation(value = "Получить значение по ID", response = Priority.class)
    public ResponseEntity<Priority> findById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(priorityService.findById(id));
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return new ResponseEntity("id=" + id + " not found", HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PostMapping("/search")
    @ApiOperation(value = "Поиск по любым параметрам",response = PrioritySearchValues.class)
    public ResponseEntity<List<Priority>> search(PrioritySearchValues categorySearchValues) {
        return ResponseEntity.ok(priorityService.findByTitle(categorySearchValues.getText()));
    }
}
