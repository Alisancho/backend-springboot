package com.javabegin.backendspringboot.controller;

import com.javabegin.backendspringboot.entity.Stat;
import com.javabegin.backendspringboot.repository.StatRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Api(tags = "Stat", description = "PriorityController")
public class StatController {

    private final StatRepository statRepository;
    private final Long defaultId = 1L;

    public StatController(StatRepository statRepository) {
        this.statRepository = statRepository;
    }

    @GetMapping("/stst")
    @ApiOperation(value = "Получить список всех значений из базы")
    public ResponseEntity<Stat> findByAll() {
        return ResponseEntity.ok(statRepository.findById(defaultId).get());
    }
}
